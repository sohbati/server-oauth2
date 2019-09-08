package com.rsp.myserver.persistence.second.repository;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;

@Repository
public class TestRepositoryImpl implements TestRepositoryCustom {

    @PersistenceContext(unitName = "second")
    private EntityManager em;

    @Override
    public Object callStoredProcedure() {
        StoredProcedureQuery procedure =
                em.createNamedStoredProcedureQuery("addTestEntry");
        return procedure.getResultList();
    }

}
