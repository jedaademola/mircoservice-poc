package com.microservice.poc.services;

import com.microservice.poc.dao.ApiMonitorDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class ApiMonitorService {

    @Autowired
    private ApiMonitorDao apiMonitorDao;

    public HashMap<String, String> getLookupValues() {
        return apiMonitorDao.getLookupValues();
    }
}
