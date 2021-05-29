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

package com.gsb.school.management.model.impl;

import com.gsb.school.management.model.School;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The cache model class for representing School in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@ProviderType
public class SchoolCacheModel implements CacheModel<School>, Externalizable {

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof SchoolCacheModel)) {
			return false;
		}

		SchoolCacheModel schoolCacheModel = (SchoolCacheModel)obj;

		if (schoolId == schoolCacheModel.schoolId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, schoolId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(27);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", schoolId=");
		sb.append(schoolId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", userName=");
		sb.append(userName);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", name=");
		sb.append(name);
		sb.append(", city=");
		sb.append(city);
		sb.append(", state=");
		sb.append(state);
		sb.append(", totalStudents=");
		sb.append(totalStudents);
		sb.append(", rating=");
		sb.append(rating);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public School toEntityModel() {
		SchoolImpl schoolImpl = new SchoolImpl();

		if (uuid == null) {
			schoolImpl.setUuid("");
		}
		else {
			schoolImpl.setUuid(uuid);
		}

		schoolImpl.setSchoolId(schoolId);
		schoolImpl.setGroupId(groupId);
		schoolImpl.setCompanyId(companyId);
		schoolImpl.setUserId(userId);

		if (userName == null) {
			schoolImpl.setUserName("");
		}
		else {
			schoolImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			schoolImpl.setCreateDate(null);
		}
		else {
			schoolImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			schoolImpl.setModifiedDate(null);
		}
		else {
			schoolImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (name == null) {
			schoolImpl.setName("");
		}
		else {
			schoolImpl.setName(name);
		}

		if (city == null) {
			schoolImpl.setCity("");
		}
		else {
			schoolImpl.setCity(city);
		}

		if (state == null) {
			schoolImpl.setState("");
		}
		else {
			schoolImpl.setState(state);
		}

		schoolImpl.setTotalStudents(totalStudents);
		schoolImpl.setRating(rating);

		schoolImpl.resetOriginalValues();

		return schoolImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		schoolId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		name = objectInput.readUTF();
		city = objectInput.readUTF();
		state = objectInput.readUTF();

		totalStudents = objectInput.readLong();

		rating = objectInput.readInt();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(schoolId);

		objectOutput.writeLong(groupId);

		objectOutput.writeLong(companyId);

		objectOutput.writeLong(userId);

		if (userName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(userName);
		}

		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);

		if (name == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(name);
		}

		if (city == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(city);
		}

		if (state == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(state);
		}

		objectOutput.writeLong(totalStudents);

		objectOutput.writeInt(rating);
	}

	public String uuid;
	public long schoolId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public String name;
	public String city;
	public String state;
	public long totalStudents;
	public int rating;

}