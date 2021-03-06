/*
 * (c) Copyright 2005-2012 JAXIO, www.jaxio.com
 * Source code generated by Celerio, a Jaxio product
 * Want to use Celerio within your company? email us at info@jaxio.com
 * Follow us on twitter: @springfuse
 * Template pack-backend-jpa:src/main/java/project/repository/RepositoryImpl.e.vm.java
 */
package com.jaxio.repository;

import javax.inject.Inject;

import org.apache.log4j.Logger;

import javax.inject.Named;
import javax.inject.Singleton;

import com.jaxio.dao.support.GenericDao;
import com.jaxio.repository.support.RepositoryImpl;
import com.jaxio.domain.Legacy;
import com.jaxio.domain.LegacyPk;
import com.jaxio.dao.LegacyDao;

/**
 * Default implementation of the {@link LegacyRepository} interface.
 * Note: you may use multiple DAO from this layer.
 * @see LegacyRepository
 */
@Named("legacyRepository")
@Singleton
public class LegacyRepositoryImpl extends RepositoryImpl<Legacy, LegacyPk> implements LegacyRepository {

    @SuppressWarnings("unused")
    private static final Logger log = Logger.getLogger(LegacyRepositoryImpl.class);

    protected LegacyDao legacyDao;

    @Inject
    public void setLegacyDao(LegacyDao legacyDao) {
        this.legacyDao = legacyDao;
    }

    /**
     * Dao getter used by the {@link RepositoryImpl}.
     */
    @Override
    public GenericDao<Legacy, LegacyPk> getDao() {
        return legacyDao;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Legacy getNew() {
        return new Legacy();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Legacy getNewWithDefaults() {
        Legacy result = getNew();
        result.initDefaultValues();
        return result;
    }

}