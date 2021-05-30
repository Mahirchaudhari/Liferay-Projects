package com.gsb.school.management.asset;

import com.gsb.school.management.constants.SchoolManagementPortletKeys;
import com.gsb.school.management.model.School;
import com.liferay.asset.kernel.model.BaseJSPAssetRenderer;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.LiferayPortletRequest;
import com.liferay.portal.kernel.portlet.LiferayPortletResponse;
import com.liferay.portal.kernel.security.permission.ActionKeys;
import com.liferay.portal.kernel.security.permission.PermissionChecker;
import com.liferay.portal.kernel.security.permission.resource.ModelResourcePermission;

import java.util.Locale;

import javax.portlet.PortletRequest;
import javax.portlet.PortletResponse;
import javax.portlet.PortletURL;
import javax.portlet.WindowState;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SchoolAssetRenderer extends BaseJSPAssetRenderer<School> {

	public SchoolAssetRenderer(School school, ModelResourcePermission<School> modelResourcePermission) {
		_school = school;
		_schoolModelResourcePermission = modelResourcePermission;
	}

	@Override
	public boolean hasEditPermission(PermissionChecker permissionChecker) {
		try {
			return _schoolModelResourcePermission.contains(permissionChecker, _school, "UPDATE_SCHOOL");
		} catch (Exception e) {
		}

		return false;
	}

	@Override
	public boolean hasViewPermission(PermissionChecker permissionChecker) {
		try {
			return _schoolModelResourcePermission.contains(permissionChecker, _school, ActionKeys.VIEW);
		} catch (Exception e) {
		}

		return true;
	}

	@Override
	public School getAssetObject() {
		return _school;
	}

	@Override
	public long getGroupId() {
		return _school.getGroupId();
	}

	@Override
	public long getUserId() {

		return _school.getUserId();
	}

	@Override
	public String getUserName() {
		return _school.getUserName();
	}

	@Override
	public String getUuid() {
		return _school.getUuid();
	}

	@Override
	public String getClassName() {
		return School.class.getName();
	}

	@Override
	public long getClassPK() {
		return _school.getSchoolId();
	}

	@Override
	public String getSummary(PortletRequest portletRequest, PortletResponse portletResponse) {
		return "Name: " + _school.getName();
	}

	@Override
	public String getTitle(Locale locale) {
		return _school.getName();
	}

	@Override
	public boolean include(HttpServletRequest request, HttpServletResponse response, String template) throws Exception {
		request.setAttribute("school", _school);
		return super.include(request, response, template);
	}

	@Override
	public String getJspPath(HttpServletRequest request, String template) {

		if (template.equals(TEMPLATE_FULL_CONTENT)) {
			request.setAttribute("school", _school);

			return "/asset/" + template + ".jsp";
		} else {
			return null;
		}
	}

	@SuppressWarnings("deprecation")
	@Override
	public PortletURL getURLEdit(LiferayPortletRequest liferayPortletRequest, LiferayPortletResponse liferayPortletResponse) throws Exception {

		PortletURL portletURL = liferayPortletResponse.createLiferayPortletURL(getControlPanelPlid(liferayPortletRequest), SchoolManagementPortletKeys.SCHOOLMANAGEMENT, PortletRequest.RENDER_PHASE);
		portletURL.setParameter("schoolId", String.valueOf(_school.getSchoolId()));
		portletURL.setParameter("mvcRenderCommandName", "/school/updateSchool");
		portletURL.setParameter("mvcPath", "/school/add_update_school.jsp");
		portletURL.setParameter("showback", Boolean.FALSE.toString());

		return portletURL;
	}

	@Override
	public String getURLViewInContext(LiferayPortletRequest liferayPortletRequest, LiferayPortletResponse liferayPortletResponse, String noSuchEntryRedirect) throws Exception {
		return StringPool.BLANK;
	}

	@Override
	public String getURLView(LiferayPortletResponse liferayPortletResponse, WindowState windowState) throws Exception {
		return super.getURLView(liferayPortletResponse, windowState);
	}

	private School _school;

	private final ModelResourcePermission<School> _schoolModelResourcePermission;

	private static final Log _log = LogFactoryUtil.getLog(SchoolAssetRenderer.class);

}
