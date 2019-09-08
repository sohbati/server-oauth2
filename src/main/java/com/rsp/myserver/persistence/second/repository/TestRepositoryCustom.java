package com.rsp.myserver.persistence.second.repository;

import org.springframework.stereotype.Repository;

@Repository
public interface TestRepositoryCustom {
    public Object callStoredProcedure();
}
