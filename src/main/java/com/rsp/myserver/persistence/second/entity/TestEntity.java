package com.rsp.myserver.persistence.second.entity;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;


@Table(name = "test")
@Data
@ToString
@NamedStoredProcedureQueries(value= {
        @NamedStoredProcedureQuery(name= "addTestEntry", procedureName= "addTestEntry"
    , parameters= {@StoredProcedureParameter(mode= ParameterMode.IN, name= "tt", type= String.class)}
    , resultClasses = TestEntity.class)
})
@Entity
public class TestEntity {

    @Id
    @GeneratedValue
    private long id;

    @Column(name = "text")
    private String text;
}
