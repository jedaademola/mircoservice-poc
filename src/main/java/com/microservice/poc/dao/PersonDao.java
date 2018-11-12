package com.microservice.poc.dao;

import com.microservice.poc.domain.Person;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;

@Repository
public class PersonDao extends AbstractDao<Person> {
    @Override
    public void setDataSource(DataSource dataSource) {

    }
}
