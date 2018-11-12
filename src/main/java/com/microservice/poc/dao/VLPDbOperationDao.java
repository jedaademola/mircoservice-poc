package com.microservice.poc.dao;

import com.microservice.poc.domain.PersonLawfulDetail;
import com.microservice.poc.utility.H2PocUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.SQLException;


@Repository
public class VLPDbOperationDao extends AbstractDao<PersonLawfulDetail> {

    @Autowired
    @Override
    public void setDataSource(@Qualifier(value = "h2DS") DataSource dataSource) {

    }

    @Override
    public PersonLawfulDetail create(PersonLawfulDetail personLawfulDetail) {
        {
            try {
                H2PocUtil.insertIntoPersonLawfulDetail(personLawfulDetail);
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }

            return personLawfulDetail;
        }
    }
}
