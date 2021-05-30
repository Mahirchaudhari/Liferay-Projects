package com.gsb.school.management.search;

import com.gsb.school.management.model.School;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.search.spi.model.index.contributor.ModelDocumentContributor;

import org.osgi.service.component.annotations.Component;

/**
 * @author Mahirali.Chaudhari
 * 
 * NOTE: ModelDocumentContributor classes specify which database fields are indexed in the model entity’s search engine documents. 
 * This class’s contribute method is called each time the add and update methods in the entity’s service layer are called.
 *
 */
@Component(
    immediate = true,
    property = "indexer.class.name=com.gsb.school.management.model.School",
    service = ModelDocumentContributor.class
)
public class SchoolModelDocumentContributor implements ModelDocumentContributor<School> {

	@Override
	public void contribute(Document document, School school) {

		try {
			document.addText("schoolName", school.getName());
			document.addText("city", school.getCity());
			document.addText("state", school.getState());
		} catch (Exception pe) {
			if (_log.isWarnEnabled()) {
				_log.warn("Unable to index school " + school.getSchoolId(), pe);
			}
		}
	}

	private static final Log _log = LogFactoryUtil.getLog(SchoolModelDocumentContributor.class);

}
