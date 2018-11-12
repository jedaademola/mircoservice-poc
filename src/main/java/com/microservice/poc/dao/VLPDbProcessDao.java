package com.microservice.poc.dao;

import com.microservice.poc.domain.PersonLawfulDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;

@Repository
public class VLPDbProcessDao extends AbstractDao<PersonLawfulDetail> {

    @Autowired
    @Override
    public void setDataSource(@Qualifier(value = "h2DS") DataSource dataSource) {

    }


}
