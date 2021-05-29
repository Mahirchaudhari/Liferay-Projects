package com.gsb.school.management.permission;

import com.gsb.school.management.model.School;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.security.permission.PermissionChecker;
import com.liferay.portal.kernel.security.permission.resource.ModelResourcePermission;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Mahirali.Chaudhari
 *
 */
@Component (immediate=true)
public class SchoolModelResourcePermission {
	public static boolean contains(PermissionChecker permissionChecker, School entry, String actionId) throws PortalException {

		return _schoolEntryModelResourcePermission.contains(permissionChecker, entry, actionId);
	}

	public static boolean contains(PermissionChecker permissionChecker, long entryId, String actionId) throws PortalException {

		return _schoolEntryModelResourcePermission.contains(permissionChecker, entryId, actionId);
	}

	@Reference(target = "(model.class.name=com.gsb.school.management.model.School)", unbind = "-")
	protected void setEntryModelPermission(ModelResourcePermission<School> modelResourcePermission) {

		_schoolEntryModelResourcePermission = modelResourcePermission;
	}

	private static ModelResourcePermission<School> _schoolEntryModelResourcePermission;
}
