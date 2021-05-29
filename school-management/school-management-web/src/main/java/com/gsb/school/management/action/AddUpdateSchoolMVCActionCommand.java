package com.gsb.school.management.action;

import com.gsb.school.management.constants.SchoolManagementPortletKeys;
import com.gsb.school.management.model.School;
import com.gsb.school.management.service.SchoolLocalService;
import com.liferay.portal.kernel.exception.PortalException;
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
			"mvc.command.name=" + "/school/addUpdateSchool" 
		}, 
	service = MVCActionCommand.class
)
public class AddUpdateSchoolMVCActionCommand extends BaseMVCActionCommand {

	@Override
	protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {

		ServiceContext serviceContext = ServiceContextFactory.getInstance(School.class.getName(), actionRequest);

		long schoolId = ParamUtil.getLong(actionRequest, "schoolId");
		String name = ParamUtil.getString(actionRequest, "name");
		String city = ParamUtil.getString(actionRequest, "city");
		String state = ParamUtil.getString(actionRequest, "state");
		long totalStudents = ParamUtil.getLong(actionRequest, "totalStudents");
		int rating = ParamUtil.getInteger(actionRequest, "rating");

		if (_log.isDebugEnabled()) {
			_log.debug("School Id : " + schoolId + " Name : " + name + " City : " + city + " State : " + state + " Total Students : " + totalStudents + " Rating : " + rating);
		}

		if (schoolId <= 0) {
			try {
				_schoolLocalService.addSchool(serviceContext.getUserId(), name, city, state, totalStudents, rating, serviceContext);
				SessionMessages.add(actionRequest, "success-adding-school");
			} catch (PortalException e) {
				_log.error("Error while adding school ", e);
				SessionErrors.add(actionRequest, "error-adding-school");
			}
		} else {
			try {
				_schoolLocalService.updateSchool(serviceContext.getUserId(), schoolId, name, city, state, totalStudents, rating, serviceContext);
			} catch (PortalException e) {
				_log.error("Error while updating school ", e);
				SessionErrors.add(actionRequest, "error-updating-school");
			}
		}

	}

	@Reference
	private SchoolLocalService _schoolLocalService;

	private static final Log _log = LogFactoryUtil.getLog(AddUpdateSchoolMVCActionCommand.class);

}
