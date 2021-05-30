package com.gsb.school.management.search;

import com.gsb.school.management.model.School;
import com.gsb.school.management.service.SchoolLocalService;
import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.search.batch.BatchIndexingActionable;
import com.liferay.portal.search.batch.DynamicQueryBatchIndexingActionableFactory;
import com.liferay.portal.search.spi.model.index.contributor.ModelIndexerWriterContributor;
import com.liferay.portal.search.spi.model.index.contributor.helper.ModelIndexerWriterDocumentHelper;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Mahirali.Chaudhari
 *
 *NOTE: ModelIndexerWriterContributor classes configure the re-indexing and batch re-indexing behavior for the model entity. 
 *
 *This class’s method is called when a re-index is triggered from the Search administrative application found in Control Panel → Configuration → Search.
 *
 */
@Component(
    immediate = true,
    property = "indexer.class.name=com.gsb.school.management.model.School",
    service = ModelIndexerWriterContributor.class
)
public class SchoolModelIndexerWriterContributor implements ModelIndexerWriterContributor<School> {

	@Override
	public void customize(BatchIndexingActionable batchIndexingActionable, ModelIndexerWriterDocumentHelper modelIndexerWriterDocumentHelper) {

		batchIndexingActionable.setPerformActionMethod((School school) -> {
			Document document = modelIndexerWriterDocumentHelper.getDocument(school);
			batchIndexingActionable.addDocuments(document);
		});
	}

	@Override
	public BatchIndexingActionable getBatchIndexingActionable() {
		return dynamicQueryBatchIndexingActionableFactory.getBatchIndexingActionable(_schoolLocalService.getIndexableActionableDynamicQuery());
	}

	@Override
	public long getCompanyId(School school) {
		return school.getCompanyId();
	}

	@Reference
	private DynamicQueryBatchIndexingActionableFactory dynamicQueryBatchIndexingActionableFactory;

	@Reference
	private SchoolLocalService _schoolLocalService;

}
