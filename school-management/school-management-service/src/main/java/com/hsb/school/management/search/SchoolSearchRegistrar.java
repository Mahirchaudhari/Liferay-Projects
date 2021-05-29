package com.hsb.school.management.search;

import com.gsb.school.management.model.School;
import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.search.spi.model.index.contributor.ModelIndexerWriterContributor;
import com.liferay.portal.search.spi.model.registrar.ModelSearchRegistrarHelper;

import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Mahirali.Chaudhari
 *
 */
@Component(immediate=true)
public class SchoolSearchRegistrar {

	@Activate
	protected void activate(BundleContext bundleContext) {

		_serviceRegistration = modelSearchRegistrarHelper.register(School.class, bundleContext, modelSearchDefinition -> {
			modelSearchDefinition.setDefaultSelectedFieldNames(
                Field.COMPANY_ID, Field.ENTRY_CLASS_NAME, 
                Field.ENTRY_CLASS_PK, Field.GROUP_ID, 
                Field.MODIFIED_DATE, Field.SCOPE_GROUP_ID);
			
			modelSearchDefinition.setSearchResultPermissionFilterSuppressed(false);
			modelSearchDefinition.setModelIndexWriteContributor(modelIndexWriterContributor);
			modelSearchDefinition.setSelectAllLocales(true);

		});
	}

	@Deactivate
	protected void deactivate() {
		_serviceRegistration.unregister();
	}

	@Reference(target = "(indexer.class.name=com.gsb.school.management.model.School)")
	protected ModelIndexerWriterContributor<School> modelIndexWriterContributor;

	@Reference
	protected ModelSearchRegistrarHelper modelSearchRegistrarHelper;

	private ServiceRegistration<?> _serviceRegistration;

}
