package com.gsb.school.management.action;

import com.gsb.school.management.constants.SchoolManagementPortletKeys;
import com.gsb.school.management.model.School;
import com.gsb.school.management.service.SchoolLocalService;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Mahirali.Chaudhari
 *
 */
@Component(
	immediate = true, 
	property = {
			"javax.portlet.name=" + SchoolManagementPortletKeys.SCHOOLMANAGEMENT, 
			"mvc.command.name=/school/updateSchool" 
		}, 
	service = MVCRenderCommand.class
)
public class UpdateSchoolMVCRenderCommand implements MVCRenderCommand {

	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {

		long schoolId = ParamUtil.getLong(renderRequest, "schoolId");

		School school = _schoolLocalService.fetchSchool(schoolId);
		if (Validator.isNotNull(school)) {
			renderRequest.setAttribute("editSchool", school);
		}
		
		return "/school/add_update_school.jsp";
	}

	@Reference
	private SchoolLocalService _schoolLocalService;
}
