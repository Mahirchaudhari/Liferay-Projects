/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.gsb.school.management.service.impl;

import com.gsb.school.management.model.School;
import com.gsb.school.management.service.base.SchoolLocalServiceBaseImpl;
import com.liferay.asset.kernel.model.AssetEntry;
import com.liferay.asset.kernel.model.AssetLinkConstants;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.ResourceConstants;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.ContentTypes;

import java.util.Date;

import org.osgi.service.component.annotations.Component;

/**
 * The implementation of the school local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the <code>com.gsb.school.management.service.SchoolLocalService</code> interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see SchoolLocalServiceBaseImpl
 */
@Component(
	property = "model.class.name=com.gsb.school.management.model.School",
	service = AopService.class
)
public class SchoolLocalServiceImpl extends SchoolLocalServiceBaseImpl {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Use <code>com.gsb.school.management.service.SchoolLocalService</code> via
	 * injection or a <code>org.osgi.util.tracker.ServiceTracker</code> or use
	 * <code>com.gsb.school.management.service.SchoolLocalServiceUtil</code>.
	 */
	@Indexable(type = IndexableType.REINDEX)
	public School addSchool(long userId, String name, String city, String state, long totalStudents, int rating, ServiceContext serviceContext) throws PortalException {

		long groupId = serviceContext.getScopeGroupId();

		User user = userLocalService.getUserById(userId);

		Date now = new Date();

		long schoolId = counterLocalService.increment(School.class.getName());

		School school = schoolPersistence.create(schoolId);

		school.setUuid(serviceContext.getUuid());
		school.setUserId(userId);
		school.setGroupId(groupId);
		school.setCompanyId(user.getCompanyId());
		school.setUserName(user.getFullName());
		school.setCreateDate(serviceContext.getCreateDate(now));
		school.setModifiedDate(serviceContext.getCreateDate(now));
		school.setName(name);
		school.setState(state);
		school.setCity(city);
		school.setTotalStudents(totalStudents);
		school.setRating(rating);

		schoolPersistence.update(school);

		resourceLocalService.addResources(user.getCompanyId(), groupId, userId, School.class.getName(), school.getSchoolId(), false, true, true);
		
		AssetEntry assetEntry = assetEntryLocalService.updateEntry(userId, groupId, school.getCreateDate(), school.getModifiedDate(), School.class.getName(), schoolId, school.getUuid(), 0, serviceContext.getAssetCategoryIds(), serviceContext.getAssetTagNames(), true, true, null, null, null, null, ContentTypes.TEXT_HTML, school.getName(), StringPool.BLANK,
			StringPool.BLANK, null, null, 0, 0, null);

		assetLinkLocalService.updateLinks(userId, assetEntry.getEntryId(), serviceContext.getAssetLinkEntryIds(), AssetLinkConstants.TYPE_RELATED);

		return school;
	}

	@Indexable(type = IndexableType.REINDEX)
	public School updateSchool(long userId, long schoolId, String name, String city, String state, long totalStudents, int rating, ServiceContext serviceContext) throws PortalException {

		Date now = new Date();

		School school = getSchool(schoolId);

		User user = userLocalService.getUser(userId);
		school.setUserId(userId);
		school.setUserName(user.getFullName());
		school.setModifiedDate(serviceContext.getModifiedDate(now));
		school.setName(name);
		school.setState(state);
		school.setCity(city);
		school.setTotalStudents(totalStudents);
		school.setRating(rating);

		schoolPersistence.update(school);

		school = schoolLocalService.updateSchool(school);

		resourceLocalService.updateResources(serviceContext.getCompanyId(), serviceContext.getScopeGroupId(), School.class.getName(), schoolId, serviceContext.getModelPermissions());

		AssetEntry assetEntry = assetEntryLocalService.updateEntry(school.getUserId(), school.getGroupId(), school.getCreateDate(), school.getModifiedDate(), School.class.getName(), schoolId, school.getUuid(), 0, serviceContext.getAssetCategoryIds(), serviceContext.getAssetTagNames(), true, true, school.getCreateDate(), null, null, null,
			ContentTypes.TEXT_HTML, school.getName(), null, null, null, null, 0, 0, serviceContext.getAssetPriority());

		assetLinkLocalService.updateLinks(serviceContext.getUserId(), assetEntry.getEntryId(), serviceContext.getAssetLinkEntryIds(), AssetLinkConstants.TYPE_RELATED);

		return school;
	}

	@Indexable(type = IndexableType.DELETE)
	public School deleteSchool(long schoolId, ServiceContext serviceContext) throws PortalException {

		School school = getSchool(schoolId);

		school = deleteSchool(school);

		resourceLocalService.deleteResource(serviceContext.getCompanyId(), School.class.getName(), ResourceConstants.SCOPE_INDIVIDUAL, school.getSchoolId());

		AssetEntry assetEntry = assetEntryLocalService.fetchEntry(School.class.getName(), schoolId);

		assetLinkLocalService.deleteLinks(assetEntry.getEntryId());

		assetEntryLocalService.deleteEntry(assetEntry);

		return school;
	}

}