package com.rsp.myserver.persistence.second.repository;

import com.rsp.myserver.persistence.second.entity.TestEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TestRepository extends JpaRepository<TestEntity, Long>, TestRepositoryCustom {

}
