package com.rsp.myserver.persistence.local.entity;

import lombok.Data;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "iplist")
@Data
@ToString
public class IPListEntity {

    @Id
    @GeneratedValue
    private long id;

    private String clientName;
    private String ip;
}
