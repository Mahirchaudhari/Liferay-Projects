package com.gsb.school.management.action;

import com.gsb.school.management.constants.SchoolManagementPortletKeys;
import com.gsb.school.management.model.School;
import com.gsb.school.management.service.SchoolLocalService;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.kernel.search.Hits;
import com.liferay.portal.kernel.search.Indexer;
import com.liferay.portal.kernel.search.IndexerRegistryUtil;
import com.liferay.portal.kernel.search.SearchContext;
import com.liferay.portal.kernel.search.SearchContextFactory;
import com.liferay.portal.kernel.search.SearchException;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.Validator;

import java.util.ArrayList;
import java.util.List;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.servlet.http.HttpServletRequest;

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
			"mvc.command.name=/" 
		}, 
	service = MVCRenderCommand.class
)
public class GenerateSchoolListMVCRenderCommand implements MVCRenderCommand {

	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {

		String keyword = ParamUtil.getString(renderRequest, "keywords").trim();
		HttpServletRequest httpServletRequest = PortalUtil.getHttpServletRequest(renderRequest);
		List<School> entries = new ArrayList<School>();

		if (_log.isDebugEnabled()) {
			_log.debug("User searching with keyword  : " + keyword);
		}

		if (Validator.isNotNull(keyword)) {
			SearchContext searchContext = SearchContextFactory.getInstance(httpServletRequest);
			searchContext.setKeywords(keyword);
			searchContext.setAttribute("paginationType", "more");
			searchContext.setStart(0);
			searchContext.setEnd(10);
			Indexer<School> indexer = IndexerRegistryUtil.getIndexer(School.class);

			try {
				Hits hits = indexer.search(searchContext);

				for (int i = 0; i < hits.getDocs().length; i++) {
					Document doc = hits.doc(i);
					long entryId = GetterUtil.getLong(doc.get(Field.ENTRY_CLASS_PK));
					School entry = _schoolLocalService.fetchSchool(entryId);
					if (Validator.isNotNull(entry)) {
						entries.add(entry);
					}
				}
			} catch (SearchException e) {
				_log.error("Search Exception : ", e);
				SessionErrors.add(renderRequest, "error-while-searching-school");
			}
		} else {
			entries.addAll(_schoolLocalService.getSchools(QueryUtil.ALL_POS, QueryUtil.ALL_POS));
		}

		if (_log.isDebugEnabled()) {
			_log.debug("Total School List Size : " + entries.size());
		}

		renderRequest.setAttribute("totalSchools", entries.size());
		renderRequest.setAttribute("totalSchoolsList", entries);

		return "/school/view.jsp";
	}
	
	@Reference
	private SchoolLocalService _schoolLocalService;

	private static final Log _log = LogFactoryUtil.getLog(AddUpdateSchoolMVCActionCommand.class);
}
