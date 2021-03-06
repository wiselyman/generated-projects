/*
 * (c) Copyright 2005-2012 JAXIO, www.jaxio.com
 * Source code generated by Celerio, a Jaxio product
 * Want to use Celerio within your company? email us at info@jaxio.com
 * Follow us on twitter: @springfuse
 * Template pack-jsf2-primefaces:src/main/java/domain/LazyDataModel.e.vm.java
 */
package com.jaxio.web.domain;

import java.util.List;
import java.util.Map;
import javax.inject.Inject;

import org.primefaces.model.SortOrder;

import com.jaxio.dao.support.SearchParameters;
import com.jaxio.domain.Document;
import com.jaxio.repository.DocumentRepository;
import com.jaxio.web.domain.support.GenericLazyDataModel;

/**
 * Provides server-side pagination for search.
 *
 * @see http://jira.springframework.org/browse/SWF-1224 to avoid instanciate it as a var from your flow 
 */
public class DocumentLazyDataModel extends GenericLazyDataModel<Document> {
    private static final long serialVersionUID = 1L;

    @Inject
    transient private DocumentRepository documentRepository;
    @Inject
    transient private DocumentSearchForm documentSearchForm;

    /**
     * Prepare the search parameters and call the documentRepository finder.
     * Automatically called by PrimeFaces component.
     */
    @Override
    public List<Document> load(int first, int pageSize, String sortField, SortOrder sortOrder, Map<String, String> filters) {
        SearchParameters sp = documentSearchForm.getSearchParameters();

        // entity selectors
        sp.clearEntitySelectors();
        sp.addEntitySelector(documentSearchForm.getAccountSelector());

        Document document = documentSearchForm.getDocument();
        setRowCount(documentRepository.findCount(document, sp)); // total count so the paginator may display the total number of pages
        populateSearchParameters(sp, first, pageSize, sortField, sortOrder, filters); // load one page of data

        return documentRepository.find(document, sp);
    }
}