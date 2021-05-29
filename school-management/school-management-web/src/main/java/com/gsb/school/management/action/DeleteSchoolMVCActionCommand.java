package com.gsb.school.management.action;

import com.gsb.school.management.constants.SchoolManagementPortletKeys;
import com.gsb.school.management.model.School;
import com.gsb.school.management.service.SchoolLocalService;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.ParamUtil;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

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
			"mvc.command.name=/school/deleteSchool" 
		}, 
	service = MVCActionCommand.class
)
public class DeleteSchoolMVCActionCommand extends BaseMVCActionCommand {

	@Override
	protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {

		ServiceContext serviceContext = ServiceContextFactory.getInstance(School.class.getName(), actionRequest);

		long schoolId = ParamUtil.getLong(actionRequest, "schoolId");

		try {
			_schoolLocalService.deleteSchool(schoolId, serviceContext);
			SessionMessages.add(actionRequest, "success-deleted-school");
		} catch (Exception e) {
			_log.error("Error while deleting school ", e);
			SessionErrors.add(actionRequest, "error-deleting-school");
		}
	}

	@Reference
	private SchoolLocalService _schoolLocalService;

	private static final Log _log = LogFactoryUtil.getLog(DeleteSchoolMVCActionCommand.class);
}
