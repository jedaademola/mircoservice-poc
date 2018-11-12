package com.microservice.poc.services;

import com.microservice.poc.dao.AbstractDao;
import com.microservice.poc.domain.AbstractModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class VLPDbProcessService extends AbstractService<AbstractModel> {

    @Autowired
    public VLPDbProcessService(@Qualifier("apiMonitorDao") AbstractDao<AbstractModel> dao) {
        super(dao);
    }


}
