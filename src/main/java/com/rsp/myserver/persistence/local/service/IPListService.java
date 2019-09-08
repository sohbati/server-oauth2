package com.rsp.myserver.persistence.local.service;

import com.rsp.myserver.persistence.local.repository.IPListRepository;
import com.rsp.myserver.persistence.local.entity.IPListEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IPListService {

    @Autowired
    IPListRepository ipListRepository;

    public boolean isIpExistsInLocalDB(String ip) {
        List<IPListEntity> list = ipListRepository.findByIp(ip);
        return list != null && list.size() > 0;
    }
}
