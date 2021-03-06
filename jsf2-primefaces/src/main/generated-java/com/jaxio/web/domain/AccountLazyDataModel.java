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
import com.jaxio.domain.Account;
import com.jaxio.repository.AccountRepository;
import com.jaxio.web.domain.support.GenericLazyDataModel;

/**
 * Provides server-side pagination for search.
 *
 * @see http://jira.springframework.org/browse/SWF-1224 to avoid instanciate it as a var from your flow 
 */
public class AccountLazyDataModel extends GenericLazyDataModel<Account> {
    private static final long serialVersionUID = 1L;

    @Inject
    transient private AccountRepository accountRepository;
    @Inject
    transient private AccountSearchForm accountSearchForm;

    /**
     * Prepare the search parameters and call the accountRepository finder.
     * Automatically called by PrimeFaces component.
     */
    @Override
    public List<Account> load(int first, int pageSize, String sortField, SortOrder sortOrder, Map<String, String> filters) {
        SearchParameters sp = accountSearchForm.getSearchParameters();

        // ranges
        sp.clearRanges();
        sp.addRange(accountSearchForm.getBirthDateRange());

        // property selectors
        sp.clearPropertySelectors();
        sp.addPropertySelector(accountSearchForm.getIsEnabledSelector());
        sp.addPropertySelector(accountSearchForm.getCivilitySelector());

        // entity selectors
        sp.clearEntitySelectors();
        sp.addEntitySelector(accountSearchForm.getHomeAddressSelector());

        Account account = accountSearchForm.getAccount();
        setRowCount(accountRepository.findCount(account, sp)); // total count so the paginator may display the total number of pages
        populateSearchParameters(sp, first, pageSize, sortField, sortOrder, filters); // load one page of data

        return accountRepository.find(account, sp);
    }
}