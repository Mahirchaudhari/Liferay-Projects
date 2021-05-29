package com.gsb.school.management.portlet;

import com.gsb.school.management.constants.SchoolManagementPortletKeys;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;

import javax.portlet.Portlet;

import org.osgi.service.component.annotations.Component;

/**
 * @author Mahirali.Chaudhari
 */
@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=category.school",
		"com.liferay.portlet.header-portlet-css=/css/main.css",
		"com.liferay.portlet.instanceable=false",
		"javax.portlet.display-name=School Management",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/school/view.jsp",
		"javax.portlet.name=" + SchoolManagementPortletKeys.SCHOOLMANAGEMENT,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class SchoolManagementPortlet extends MVCPortlet {
}