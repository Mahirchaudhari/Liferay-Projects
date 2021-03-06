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

package com.gsb.school.management.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

import org.osgi.annotation.versioning.ProviderType;

/**
 * Provides a wrapper for {@link SchoolLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see SchoolLocalService
 * @generated
 */
@ProviderType
public class SchoolLocalServiceWrapper
	implements SchoolLocalService, ServiceWrapper<SchoolLocalService> {

	public SchoolLocalServiceWrapper(SchoolLocalService schoolLocalService) {
		_schoolLocalService = schoolLocalService;
	}

	@Override
	public com.gsb.school.management.model.School addSchool(
			long userId, String name, String city, String state,
			long totalStudents, int rating,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _schoolLocalService.addSchool(
			userId, name, city, state, totalStudents, rating, serviceContext);
	}

	/**
	 * Adds the school to the database. Also notifies the appropriate model listeners.
	 *
	 * @param school the school
	 * @return the school that was added
	 */
	@Override
	public com.gsb.school.management.model.School addSchool(
		com.gsb.school.management.model.School school) {

		return _schoolLocalService.addSchool(school);
	}

	/**
	 * Creates a new school with the primary key. Does not add the school to the database.
	 *
	 * @param schoolId the primary key for the new school
	 * @return the new school
	 */
	@Override
	public com.gsb.school.management.model.School createSchool(long schoolId) {
		return _schoolLocalService.createSchool(schoolId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _schoolLocalService.deletePersistedModel(persistedModel);
	}

	/**
	 * Deletes the school with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param schoolId the primary key of the school
	 * @return the school that was removed
	 * @throws PortalException if a school with the primary key could not be found
	 */
	@Override
	public com.gsb.school.management.model.School deleteSchool(long schoolId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _schoolLocalService.deleteSchool(schoolId);
	}

	@Override
	public com.gsb.school.management.model.School deleteSchool(
			long schoolId,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _schoolLocalService.deleteSchool(schoolId, serviceContext);
	}

	/**
	 * Deletes the school from the database. Also notifies the appropriate model listeners.
	 *
	 * @param school the school
	 * @return the school that was removed
	 */
	@Override
	public com.gsb.school.management.model.School deleteSchool(
		com.gsb.school.management.model.School school) {

		return _schoolLocalService.deleteSchool(school);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _schoolLocalService.dynamicQuery();
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _schoolLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>com.gsb.school.management.model.impl.SchoolModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @return the range of matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return _schoolLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>com.gsb.school.management.model.impl.SchoolModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return _schoolLocalService.dynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _schoolLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {

		return _schoolLocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	@Override
	public com.gsb.school.management.model.School fetchSchool(long schoolId) {
		return _schoolLocalService.fetchSchool(schoolId);
	}

	/**
	 * Returns the school matching the UUID and group.
	 *
	 * @param uuid the school's UUID
	 * @param groupId the primary key of the group
	 * @return the matching school, or <code>null</code> if a matching school could not be found
	 */
	@Override
	public com.gsb.school.management.model.School fetchSchoolByUuidAndGroupId(
		String uuid, long groupId) {

		return _schoolLocalService.fetchSchoolByUuidAndGroupId(uuid, groupId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _schoolLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return _schoolLocalService.getExportActionableDynamicQuery(
			portletDataContext);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _schoolLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _schoolLocalService.getOSGiServiceIdentifier();
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _schoolLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Returns the school with the primary key.
	 *
	 * @param schoolId the primary key of the school
	 * @return the school
	 * @throws PortalException if a school with the primary key could not be found
	 */
	@Override
	public com.gsb.school.management.model.School getSchool(long schoolId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _schoolLocalService.getSchool(schoolId);
	}

	/**
	 * Returns the school matching the UUID and group.
	 *
	 * @param uuid the school's UUID
	 * @param groupId the primary key of the group
	 * @return the matching school
	 * @throws PortalException if a matching school could not be found
	 */
	@Override
	public com.gsb.school.management.model.School getSchoolByUuidAndGroupId(
			String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _schoolLocalService.getSchoolByUuidAndGroupId(uuid, groupId);
	}

	/**
	 * Returns a range of all the schools.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>com.gsb.school.management.model.impl.SchoolModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of schools
	 * @param end the upper bound of the range of schools (not inclusive)
	 * @return the range of schools
	 */
	@Override
	public java.util.List<com.gsb.school.management.model.School> getSchools(
		int start, int end) {

		return _schoolLocalService.getSchools(start, end);
	}

	/**
	 * Returns all the schools matching the UUID and company.
	 *
	 * @param uuid the UUID of the schools
	 * @param companyId the primary key of the company
	 * @return the matching schools, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<com.gsb.school.management.model.School>
		getSchoolsByUuidAndCompanyId(String uuid, long companyId) {

		return _schoolLocalService.getSchoolsByUuidAndCompanyId(
			uuid, companyId);
	}

	/**
	 * Returns a range of schools matching the UUID and company.
	 *
	 * @param uuid the UUID of the schools
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of schools
	 * @param end the upper bound of the range of schools (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching schools, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<com.gsb.school.management.model.School>
		getSchoolsByUuidAndCompanyId(
			String uuid, long companyId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<com.gsb.school.management.model.School> orderByComparator) {

		return _schoolLocalService.getSchoolsByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of schools.
	 *
	 * @return the number of schools
	 */
	@Override
	public int getSchoolsCount() {
		return _schoolLocalService.getSchoolsCount();
	}

	@Override
	public com.gsb.school.management.model.School updateSchool(
			long userId, long schoolId, String name, String city, String state,
			long totalStudents, int rating,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _schoolLocalService.updateSchool(
			userId, schoolId, name, city, state, totalStudents, rating,
			serviceContext);
	}

	/**
	 * Updates the school in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param school the school
	 * @return the school that was updated
	 */
	@Override
	public com.gsb.school.management.model.School updateSchool(
		com.gsb.school.management.model.School school) {

		return _schoolLocalService.updateSchool(school);
	}

	@Override
	public SchoolLocalService getWrappedService() {
		return _schoolLocalService;
	}

	@Override
	public void setWrappedService(SchoolLocalService schoolLocalService) {
		_schoolLocalService = schoolLocalService;
	}

	private SchoolLocalService _schoolLocalService;

}