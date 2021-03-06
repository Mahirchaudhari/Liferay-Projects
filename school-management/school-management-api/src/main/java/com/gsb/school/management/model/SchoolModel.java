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

package com.gsb.school.management.model;

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.model.BaseModel;
import com.liferay.portal.kernel.model.GroupedModel;
import com.liferay.portal.kernel.model.ShardedModel;
import com.liferay.portal.kernel.model.StagedAuditedModel;

import java.util.Date;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The base model interface for the School service. Represents a row in the &quot;School&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation <code>com.gsb.school.management.model.impl.SchoolModelImpl</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in <code>com.gsb.school.management.model.impl.SchoolImpl</code>.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see School
 * @generated
 */
@ProviderType
public interface SchoolModel
	extends BaseModel<School>, GroupedModel, ShardedModel, StagedAuditedModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a school model instance should use the {@link School} interface instead.
	 */

	/**
	 * Returns the primary key of this school.
	 *
	 * @return the primary key of this school
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this school.
	 *
	 * @param primaryKey the primary key of this school
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the uuid of this school.
	 *
	 * @return the uuid of this school
	 */
	@AutoEscape
	@Override
	public String getUuid();

	/**
	 * Sets the uuid of this school.
	 *
	 * @param uuid the uuid of this school
	 */
	@Override
	public void setUuid(String uuid);

	/**
	 * Returns the school ID of this school.
	 *
	 * @return the school ID of this school
	 */
	public long getSchoolId();

	/**
	 * Sets the school ID of this school.
	 *
	 * @param schoolId the school ID of this school
	 */
	public void setSchoolId(long schoolId);

	/**
	 * Returns the group ID of this school.
	 *
	 * @return the group ID of this school
	 */
	@Override
	public long getGroupId();

	/**
	 * Sets the group ID of this school.
	 *
	 * @param groupId the group ID of this school
	 */
	@Override
	public void setGroupId(long groupId);

	/**
	 * Returns the company ID of this school.
	 *
	 * @return the company ID of this school
	 */
	@Override
	public long getCompanyId();

	/**
	 * Sets the company ID of this school.
	 *
	 * @param companyId the company ID of this school
	 */
	@Override
	public void setCompanyId(long companyId);

	/**
	 * Returns the user ID of this school.
	 *
	 * @return the user ID of this school
	 */
	@Override
	public long getUserId();

	/**
	 * Sets the user ID of this school.
	 *
	 * @param userId the user ID of this school
	 */
	@Override
	public void setUserId(long userId);

	/**
	 * Returns the user uuid of this school.
	 *
	 * @return the user uuid of this school
	 */
	@Override
	public String getUserUuid();

	/**
	 * Sets the user uuid of this school.
	 *
	 * @param userUuid the user uuid of this school
	 */
	@Override
	public void setUserUuid(String userUuid);

	/**
	 * Returns the user name of this school.
	 *
	 * @return the user name of this school
	 */
	@AutoEscape
	@Override
	public String getUserName();

	/**
	 * Sets the user name of this school.
	 *
	 * @param userName the user name of this school
	 */
	@Override
	public void setUserName(String userName);

	/**
	 * Returns the create date of this school.
	 *
	 * @return the create date of this school
	 */
	@Override
	public Date getCreateDate();

	/**
	 * Sets the create date of this school.
	 *
	 * @param createDate the create date of this school
	 */
	@Override
	public void setCreateDate(Date createDate);

	/**
	 * Returns the modified date of this school.
	 *
	 * @return the modified date of this school
	 */
	@Override
	public Date getModifiedDate();

	/**
	 * Sets the modified date of this school.
	 *
	 * @param modifiedDate the modified date of this school
	 */
	@Override
	public void setModifiedDate(Date modifiedDate);

	/**
	 * Returns the name of this school.
	 *
	 * @return the name of this school
	 */
	@AutoEscape
	public String getName();

	/**
	 * Sets the name of this school.
	 *
	 * @param name the name of this school
	 */
	public void setName(String name);

	/**
	 * Returns the city of this school.
	 *
	 * @return the city of this school
	 */
	@AutoEscape
	public String getCity();

	/**
	 * Sets the city of this school.
	 *
	 * @param city the city of this school
	 */
	public void setCity(String city);

	/**
	 * Returns the state of this school.
	 *
	 * @return the state of this school
	 */
	@AutoEscape
	public String getState();

	/**
	 * Sets the state of this school.
	 *
	 * @param state the state of this school
	 */
	public void setState(String state);

	/**
	 * Returns the total students of this school.
	 *
	 * @return the total students of this school
	 */
	public long getTotalStudents();

	/**
	 * Sets the total students of this school.
	 *
	 * @param totalStudents the total students of this school
	 */
	public void setTotalStudents(long totalStudents);

	/**
	 * Returns the rating of this school.
	 *
	 * @return the rating of this school
	 */
	public int getRating();

	/**
	 * Sets the rating of this school.
	 *
	 * @param rating the rating of this school
	 */
	public void setRating(int rating);

}