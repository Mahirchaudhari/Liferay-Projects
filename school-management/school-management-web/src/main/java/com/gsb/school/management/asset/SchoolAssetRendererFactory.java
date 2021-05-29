package com.gsb.school.management.asset;

import com.gsb.school.management.constants.SchoolManagementPortletKeys;
import com.gsb.school.management.model.School;
import com.gsb.school.management.service.SchoolLocalService;
import com.liferay.asset.kernel.model.AssetRenderer;
import com.liferay.asset.kernel.model.AssetRendererFactory;
import com.liferay.asset.kernel.model.BaseAssetRendererFactory;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.LiferayPortletRequest;
import com.liferay.portal.kernel.portlet.LiferayPortletResponse;
import com.liferay.portal.kernel.security.permission.resource.ModelResourcePermission;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.WebKeys;

import javax.portlet.PortletRequest;
import javax.portlet.PortletURL;
import javax.servlet.ServletContext;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(
    immediate = true,
    property = {"javax.portlet.name=" + SchoolManagementPortletKeys.SCHOOLMANAGEMENT},
    service = AssetRendererFactory.class
    )
public class SchoolAssetRendererFactory extends BaseAssetRendererFactory<School> {

	public SchoolAssetRendererFactory() {
		setClassName(CLASS_NAME);
		setLinkable(_LINKABLE);
		setPortletId(SchoolManagementPortletKeys.SCHOOLMANAGEMENT);
		setSearchable(true);
	}

	@Override
	public AssetRenderer<School> getAssetRenderer(long classPK, int type) throws PortalException {

		School _school = _schoolLocalService.getSchool(classPK);

		SchoolAssetRenderer guestbookAssetRenderer = new SchoolAssetRenderer(_school, _schoolModelResourcePermission);

		guestbookAssetRenderer.setAssetRendererType(type);
		guestbookAssetRenderer.setServletContext(_servletContext);

		return guestbookAssetRenderer;
	}

	@Override
	public String getClassName() {
		return CLASS_NAME;
	}

	@Override
	public String getType() {
		return TYPE;
	}

	@SuppressWarnings("deprecation")
	@Override
	public PortletURL getURLAdd(LiferayPortletRequest liferayPortletRequest, LiferayPortletResponse liferayPortletResponse, long classTypeId) {
		PortletURL portletURL = null;

		try {
			ThemeDisplay themeDisplay = (ThemeDisplay) liferayPortletRequest.getAttribute(WebKeys.THEME_DISPLAY);

			portletURL = liferayPortletResponse.createLiferayPortletURL(getControlPanelPlid(themeDisplay), SchoolManagementPortletKeys.SCHOOLMANAGEMENT, PortletRequest.RENDER_PHASE);
			portletURL.setParameter("mvcPath", "/school/add_update_school.jsp");
			portletURL.setParameter("showback", Boolean.FALSE.toString());

		} catch (PortalException e) {
			_log.error("Error while creating add school URL in asset renderer : ", e);
		}

		return portletURL;
	}

	@Override
	public boolean isLinkable() {
		return _LINKABLE;
	}

	@Override
	public String getIconCssClass() {
		return "bookmarks";
	}

	@Reference(target = "(osgi.web.symbolicname=com.gsb.school.management)", unbind = "-")
	public void setServletContext(ServletContext servletContext) {
		_servletContext = servletContext;
	}

	@Reference(target = "(model.class.name=com.gsb.school.management.model.School)", unbind = "-")
	protected void setEntryModelPermission(ModelResourcePermission<School> modelResourcePermission) {
		_schoolModelResourcePermission = modelResourcePermission;
	}

	@Reference
	private SchoolLocalService _schoolLocalService;

	private ServletContext _servletContext;
	private static final boolean _LINKABLE = true;
	public static final String CLASS_NAME = School.class.getName();
	public static final String TYPE = "school";

	private ModelResourcePermission<School> _schoolModelResourcePermission;

	private static final Log _log = LogFactoryUtil.getLog(SchoolAssetRendererFactory.class);
}
