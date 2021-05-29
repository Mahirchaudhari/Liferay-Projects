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

import com.liferay.exportimport.kernel.lar.StagedModelType;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.osgi.annotation.versioning.ProviderType;

/**
 * <p>
 * This class is a wrapper for {@link School}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see School
 * @generated
 */
@ProviderType
public class SchoolWrapper
	extends BaseModelWrapper<School> implements School, ModelWrapper<School> {

	public SchoolWrapper(School school) {
		super(school);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("schoolId", getSchoolId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("name", getName());
		attributes.put("city", getCity());
		attributes.put("state", getState());
		attributes.put("totalStudents", getTotalStudents());
		attributes.put("rating", getRating());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long schoolId = (Long)attributes.get("schoolId");

		if (schoolId != null) {
			setSchoolId(schoolId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		String userName = (String)attributes.get("userName");

		if (userName != null) {
			setUserName(userName);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}

		String city = (String)attributes.get("city");

		if (city != null) {
			setCity(city);
		}

		String state = (String)attributes.get("state");

		if (state != null) {
			setState(state);
		}

		Long totalStudents = (Long)attributes.get("totalStudents");

		if (totalStudents != null) {
			setTotalStudents(totalStudents);
		}

		Integer rating = (Integer)attributes.get("rating");

		if (rating != null) {
			setRating(rating);
		}
	}

	/**
	 * Returns the city of this school.
	 *
	 * @return the city of this school
	 */
	@Override
	public String getCity() {
		return model.getCity();
	}

	/**
	 * Returns the company ID of this school.
	 *
	 * @return the company ID of this school
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this school.
	 *
	 * @return the create date of this school
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the group ID of this school.
	 *
	 * @return the group ID of this school
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the modified date of this school.
	 *
	 * @return the modified date of this school
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the name of this school.
	 *
	 * @return the name of this school
	 */
	@Override
	public String getName() {
		return model.getName();
	}

	/**
	 * Returns the primary key of this school.
	 *
	 * @return the primary key of this school
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the rating of this school.
	 *
	 * @return the rating of this school
	 */
	@Override
	public int getRating() {
		return model.getRating();
	}

	/**
	 * Returns the school ID of this school.
	 *
	 * @return the school ID of this school
	 */
	@Override
	public long getSchoolId() {
		return model.getSchoolId();
	}

	/**
	 * Returns the state of this school.
	 *
	 * @return the state of this school
	 */
	@Override
	public String getState() {
		return model.getState();
	}

	/**
	 * Returns the total students of this school.
	 *
	 * @return the total students of this school
	 */
	@Override
	public long getTotalStudents() {
		return model.getTotalStudents();
	}

	/**
	 * Returns the user ID of this school.
	 *
	 * @return the user ID of this school
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user name of this school.
	 *
	 * @return the user name of this school
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	/**
	 * Returns the user uuid of this school.
	 *
	 * @return the user uuid of this school
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	/**
	 * Returns the uuid of this school.
	 *
	 * @return the uuid of this school
	 */
	@Override
	public String getUuid() {
		return model.getUuid();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the city of this school.
	 *
	 * @param city the city of this school
	 */
	@Override
	public void setCity(String city) {
		model.setCity(city);
	}

	/**
	 * Sets the company ID of this school.
	 *
	 * @param companyId the company ID of this school
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this school.
	 *
	 * @param createDate the create date of this school
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the group ID of this school.
	 *
	 * @param groupId the group ID of this school
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the modified date of this school.
	 *
	 * @param modifiedDate the modified date of this school
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the name of this school.
	 *
	 * @param name the name of this school
	 */
	@Override
	public void setName(String name) {
		model.setName(name);
	}

	/**
	 * Sets the primary key of this school.
	 *
	 * @param primaryKey the primary key of this school
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the rating of this school.
	 *
	 * @param rating the rating of this school
	 */
	@Override
	public void setRating(int rating) {
		model.setRating(rating);
	}

	/**
	 * Sets the school ID of this school.
	 *
	 * @param schoolId the school ID of this school
	 */
	@Override
	public void setSchoolId(long schoolId) {
		model.setSchoolId(schoolId);
	}

	/**
	 * Sets the state of this school.
	 *
	 * @param state the state of this school
	 */
	@Override
	public void setState(String state) {
		model.setState(state);
	}

	/**
	 * Sets the total students of this school.
	 *
	 * @param totalStudents the total students of this school
	 */
	@Override
	public void setTotalStudents(long totalStudents) {
		model.setTotalStudents(totalStudents);
	}

	/**
	 * Sets the user ID of this school.
	 *
	 * @param userId the user ID of this school
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user name of this school.
	 *
	 * @param userName the user name of this school
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this school.
	 *
	 * @param userUuid the user uuid of this school
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	/**
	 * Sets the uuid of this school.
	 *
	 * @param uuid the uuid of this school
	 */
	@Override
	public void setUuid(String uuid) {
		model.setUuid(uuid);
	}

	@Override
	public StagedModelType getStagedModelType() {
		return model.getStagedModelType();
	}

	@Override
	protected SchoolWrapper wrap(School school) {
		return new SchoolWrapper(school);
	}

}