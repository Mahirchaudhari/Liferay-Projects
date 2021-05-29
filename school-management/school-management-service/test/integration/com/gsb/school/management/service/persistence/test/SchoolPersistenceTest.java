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

package com.gsb.school.management.service.persistence.test;

import com.gsb.school.management.exception.NoSuchSchoolException;
import com.gsb.school.management.model.School;
import com.gsb.school.management.service.SchoolLocalServiceUtil;
import com.gsb.school.management.service.persistence.SchoolPersistence;
import com.gsb.school.management.service.persistence.SchoolUtil;

import com.liferay.arquillian.extension.junit.bridge.junit.Arquillian;
import com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.ProjectionFactoryUtil;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.test.ReflectionTestUtil;
import com.liferay.portal.kernel.test.rule.AggregateTestRule;
import com.liferay.portal.kernel.test.util.RandomTestUtil;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.util.IntegerWrapper;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.OrderByComparatorFactoryUtil;
import com.liferay.portal.kernel.util.Time;
import com.liferay.portal.test.rule.LiferayIntegrationTestRule;
import com.liferay.portal.test.rule.PersistenceTestRule;
import com.liferay.portal.test.rule.TransactionalTestRule;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.ClassRule;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * @generated
 */
@RunWith(Arquillian.class)
public class SchoolPersistenceTest {

	@ClassRule
	@Rule
	public static final AggregateTestRule aggregateTestRule =
		new AggregateTestRule(
			new LiferayIntegrationTestRule(), PersistenceTestRule.INSTANCE,
			new TransactionalTestRule(
				Propagation.REQUIRED, "com.gsb.school.management.service"));

	@Before
	public void setUp() {
		_persistence = SchoolUtil.getPersistence();

		Class<?> clazz = _persistence.getClass();

		_dynamicQueryClassLoader = clazz.getClassLoader();
	}

	@After
	public void tearDown() throws Exception {
		Iterator<School> iterator = _schools.iterator();

		while (iterator.hasNext()) {
			_persistence.remove(iterator.next());

			iterator.remove();
		}
	}

	@Test
	public void testCreate() throws Exception {
		long pk = RandomTestUtil.nextLong();

		School school = _persistence.create(pk);

		Assert.assertNotNull(school);

		Assert.assertEquals(school.getPrimaryKey(), pk);
	}

	@Test
	public void testRemove() throws Exception {
		School newSchool = addSchool();

		_persistence.remove(newSchool);

		School existingSchool = _persistence.fetchByPrimaryKey(
			newSchool.getPrimaryKey());

		Assert.assertNull(existingSchool);
	}

	@Test
	public void testUpdateNew() throws Exception {
		addSchool();
	}

	@Test
	public void testUpdateExisting() throws Exception {
		long pk = RandomTestUtil.nextLong();

		School newSchool = _persistence.create(pk);

		newSchool.setUuid(RandomTestUtil.randomString());

		newSchool.setGroupId(RandomTestUtil.nextLong());

		newSchool.setCompanyId(RandomTestUtil.nextLong());

		newSchool.setUserId(RandomTestUtil.nextLong());

		newSchool.setUserName(RandomTestUtil.randomString());

		newSchool.setCreateDate(RandomTestUtil.nextDate());

		newSchool.setModifiedDate(RandomTestUtil.nextDate());

		newSchool.setName(RandomTestUtil.randomString());

		newSchool.setCity(RandomTestUtil.randomString());

		newSchool.setState(RandomTestUtil.randomString());

		newSchool.setTotalStudents(RandomTestUtil.nextLong());

		newSchool.setRating(RandomTestUtil.nextInt());

		_schools.add(_persistence.update(newSchool));

		School existingSchool = _persistence.findByPrimaryKey(
			newSchool.getPrimaryKey());

		Assert.assertEquals(existingSchool.getUuid(), newSchool.getUuid());
		Assert.assertEquals(
			existingSchool.getSchoolId(), newSchool.getSchoolId());
		Assert.assertEquals(
			existingSchool.getGroupId(), newSchool.getGroupId());
		Assert.assertEquals(
			existingSchool.getCompanyId(), newSchool.getCompanyId());
		Assert.assertEquals(existingSchool.getUserId(), newSchool.getUserId());
		Assert.assertEquals(
			existingSchool.getUserName(), newSchool.getUserName());
		Assert.assertEquals(
			Time.getShortTimestamp(existingSchool.getCreateDate()),
			Time.getShortTimestamp(newSchool.getCreateDate()));
		Assert.assertEquals(
			Time.getShortTimestamp(existingSchool.getModifiedDate()),
			Time.getShortTimestamp(newSchool.getModifiedDate()));
		Assert.assertEquals(existingSchool.getName(), newSchool.getName());
		Assert.assertEquals(existingSchool.getCity(), newSchool.getCity());
		Assert.assertEquals(existingSchool.getState(), newSchool.getState());
		Assert.assertEquals(
			existingSchool.getTotalStudents(), newSchool.getTotalStudents());
		Assert.assertEquals(existingSchool.getRating(), newSchool.getRating());
	}

	@Test
	public void testCountByUuid() throws Exception {
		_persistence.countByUuid("");

		_persistence.countByUuid("null");

		_persistence.countByUuid((String)null);
	}

	@Test
	public void testCountByUUID_G() throws Exception {
		_persistence.countByUUID_G("", RandomTestUtil.nextLong());

		_persistence.countByUUID_G("null", 0L);

		_persistence.countByUUID_G((String)null, 0L);
	}

	@Test
	public void testCountByUuid_C() throws Exception {
		_persistence.countByUuid_C("", RandomTestUtil.nextLong());

		_persistence.countByUuid_C("null", 0L);

		_persistence.countByUuid_C((String)null, 0L);
	}

	@Test
	public void testFindByPrimaryKeyExisting() throws Exception {
		School newSchool = addSchool();

		School existingSchool = _persistence.findByPrimaryKey(
			newSchool.getPrimaryKey());

		Assert.assertEquals(existingSchool, newSchool);
	}

	@Test(expected = NoSuchSchoolException.class)
	public void testFindByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		_persistence.findByPrimaryKey(pk);
	}

	@Test
	public void testFindAll() throws Exception {
		_persistence.findAll(
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, getOrderByComparator());
	}

	protected OrderByComparator<School> getOrderByComparator() {
		return OrderByComparatorFactoryUtil.create(
			"School", "uuid", true, "schoolId", true, "groupId", true,
			"companyId", true, "userId", true, "userName", true, "createDate",
			true, "modifiedDate", true, "name", true, "city", true, "state",
			true, "totalStudents", true, "rating", true);
	}

	@Test
	public void testFetchByPrimaryKeyExisting() throws Exception {
		School newSchool = addSchool();

		School existingSchool = _persistence.fetchByPrimaryKey(
			newSchool.getPrimaryKey());

		Assert.assertEquals(existingSchool, newSchool);
	}

	@Test
	public void testFetchByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		School missingSchool = _persistence.fetchByPrimaryKey(pk);

		Assert.assertNull(missingSchool);
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereAllPrimaryKeysExist()
		throws Exception {

		School newSchool1 = addSchool();
		School newSchool2 = addSchool();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newSchool1.getPrimaryKey());
		primaryKeys.add(newSchool2.getPrimaryKey());

		Map<Serializable, School> schools = _persistence.fetchByPrimaryKeys(
			primaryKeys);

		Assert.assertEquals(2, schools.size());
		Assert.assertEquals(
			newSchool1, schools.get(newSchool1.getPrimaryKey()));
		Assert.assertEquals(
			newSchool2, schools.get(newSchool2.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereNoPrimaryKeysExist()
		throws Exception {

		long pk1 = RandomTestUtil.nextLong();

		long pk2 = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(pk1);
		primaryKeys.add(pk2);

		Map<Serializable, School> schools = _persistence.fetchByPrimaryKeys(
			primaryKeys);

		Assert.assertTrue(schools.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereSomePrimaryKeysExist()
		throws Exception {

		School newSchool = addSchool();

		long pk = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newSchool.getPrimaryKey());
		primaryKeys.add(pk);

		Map<Serializable, School> schools = _persistence.fetchByPrimaryKeys(
			primaryKeys);

		Assert.assertEquals(1, schools.size());
		Assert.assertEquals(newSchool, schools.get(newSchool.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithNoPrimaryKeys() throws Exception {
		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		Map<Serializable, School> schools = _persistence.fetchByPrimaryKeys(
			primaryKeys);

		Assert.assertTrue(schools.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithOnePrimaryKey() throws Exception {
		School newSchool = addSchool();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newSchool.getPrimaryKey());

		Map<Serializable, School> schools = _persistence.fetchByPrimaryKeys(
			primaryKeys);

		Assert.assertEquals(1, schools.size());
		Assert.assertEquals(newSchool, schools.get(newSchool.getPrimaryKey()));
	}

	@Test
	public void testActionableDynamicQuery() throws Exception {
		final IntegerWrapper count = new IntegerWrapper();

		ActionableDynamicQuery actionableDynamicQuery =
			SchoolLocalServiceUtil.getActionableDynamicQuery();

		actionableDynamicQuery.setPerformActionMethod(
			new ActionableDynamicQuery.PerformActionMethod<School>() {

				@Override
				public void performAction(School school) {
					Assert.assertNotNull(school);

					count.increment();
				}

			});

		actionableDynamicQuery.performActions();

		Assert.assertEquals(count.getValue(), _persistence.countAll());
	}

	@Test
	public void testDynamicQueryByPrimaryKeyExisting() throws Exception {
		School newSchool = addSchool();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			School.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq("schoolId", newSchool.getSchoolId()));

		List<School> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(1, result.size());

		School existingSchool = result.get(0);

		Assert.assertEquals(existingSchool, newSchool);
	}

	@Test
	public void testDynamicQueryByPrimaryKeyMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			School.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq("schoolId", RandomTestUtil.nextLong()));

		List<School> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	@Test
	public void testDynamicQueryByProjectionExisting() throws Exception {
		School newSchool = addSchool();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			School.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(ProjectionFactoryUtil.property("schoolId"));

		Object newSchoolId = newSchool.getSchoolId();

		dynamicQuery.add(
			RestrictionsFactoryUtil.in("schoolId", new Object[] {newSchoolId}));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(1, result.size());

		Object existingSchoolId = result.get(0);

		Assert.assertEquals(existingSchoolId, newSchoolId);
	}

	@Test
	public void testDynamicQueryByProjectionMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			School.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(ProjectionFactoryUtil.property("schoolId"));

		dynamicQuery.add(
			RestrictionsFactoryUtil.in(
				"schoolId", new Object[] {RandomTestUtil.nextLong()}));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	@Test
	public void testResetOriginalValues() throws Exception {
		School newSchool = addSchool();

		_persistence.clearCache();

		School existingSchool = _persistence.findByPrimaryKey(
			newSchool.getPrimaryKey());

		Assert.assertTrue(
			Objects.equals(
				existingSchool.getUuid(),
				ReflectionTestUtil.invoke(
					existingSchool, "getOriginalUuid", new Class<?>[0])));
		Assert.assertEquals(
			Long.valueOf(existingSchool.getGroupId()),
			ReflectionTestUtil.<Long>invoke(
				existingSchool, "getOriginalGroupId", new Class<?>[0]));
	}

	protected School addSchool() throws Exception {
		long pk = RandomTestUtil.nextLong();

		School school = _persistence.create(pk);

		school.setUuid(RandomTestUtil.randomString());

		school.setGroupId(RandomTestUtil.nextLong());

		school.setCompanyId(RandomTestUtil.nextLong());

		school.setUserId(RandomTestUtil.nextLong());

		school.setUserName(RandomTestUtil.randomString());

		school.setCreateDate(RandomTestUtil.nextDate());

		school.setModifiedDate(RandomTestUtil.nextDate());

		school.setName(RandomTestUtil.randomString());

		school.setCity(RandomTestUtil.randomString());

		school.setState(RandomTestUtil.randomString());

		school.setTotalStudents(RandomTestUtil.nextLong());

		school.setRating(RandomTestUtil.nextInt());

		_schools.add(_persistence.update(school));

		return school;
	}

	private List<School> _schools = new ArrayList<School>();
	private SchoolPersistence _persistence;
	private ClassLoader _dynamicQueryClassLoader;

}