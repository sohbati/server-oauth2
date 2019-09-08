package com.rsp.myserver.persistence.local.repository;

import com.rsp.myserver.persistence.local.entity.IPListEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IPListRepository extends JpaRepository<IPListEntity, Long> {
    List<IPListEntity> findByIp(String ip);
}
