package com.microservice.poc.services;

import com.microservice.poc.dao.AbstractDao;
import com.microservice.poc.dao.ApiMonitorDao;
import com.microservice.poc.domain.AbstractModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.HashMap;

@Service
public class ApiMonitorService extends AbstractService<AbstractModel> {

    @Autowired
    public ApiMonitorService(@Qualifier("apiMonitorDao") AbstractDao<AbstractModel> dao) {
        super(dao);
    }

    public HashMap<String, String> getLookupValues() throws SQLException, ClassNotFoundException {
        ApiMonitorDao apiMonitorDao = (ApiMonitorDao) dao;
        return apiMonitorDao.getLookupValues();
    }
}
