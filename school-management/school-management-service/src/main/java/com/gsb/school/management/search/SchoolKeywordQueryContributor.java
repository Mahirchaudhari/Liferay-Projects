package com.gsb.school.management.search;

import com.liferay.portal.kernel.search.BooleanQuery;
import com.liferay.portal.kernel.search.SearchContext;
import com.liferay.portal.search.query.QueryHelper;
import com.liferay.portal.search.spi.model.query.contributor.KeywordQueryContributor;
import com.liferay.portal.search.spi.model.query.contributor.helper.KeywordQueryContributorHelper;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Mahirali.Chaudhari
 * 
 * Note: KeywordQueryContributor classes contribute clauses to the ongoing search query. 
 * 
 * This is called at search time, and ensures that all the fields you indexed are also the ones searched. 
 *
 */
@Component(
    immediate = true,
    property = "indexer.class.name=com.gsb.school.management.model.School",
    service = KeywordQueryContributor.class
)
public class SchoolKeywordQueryContributor implements KeywordQueryContributor {

	@Override
	public void contribute(String keywords, BooleanQuery booleanQuery, KeywordQueryContributorHelper keywordQueryContributorHelper) {

		SearchContext searchContext = keywordQueryContributorHelper.getSearchContext();

		queryHelper.addSearchTerm(booleanQuery, searchContext, "schoolName", false);
		queryHelper.addSearchTerm(booleanQuery, searchContext, "city", false);
		queryHelper.addSearchTerm(booleanQuery, searchContext, "state", false);
	}

	@Reference
	private QueryHelper queryHelper;

}
