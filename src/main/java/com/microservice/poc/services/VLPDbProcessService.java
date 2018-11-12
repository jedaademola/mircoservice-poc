package com.microservice.poc.services;

import com.microservice.poc.dao.AbstractDao;
import com.microservice.poc.dao.VLPDbProcessDao;
import com.microservice.poc.domain.Page;
import com.microservice.poc.domain.PersonLawfulDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class VLPDbProcessService extends AbstractService<PersonLawfulDetail> {

    @Autowired
    public VLPDbProcessService(@Qualifier("VLPDbProcessDao") AbstractDao<PersonLawfulDetail> dao) {
        super(dao);
    }

    @Override
    public PersonLawfulDetail create(PersonLawfulDetail personLawfulDetail) {
        return super.create(personLawfulDetail);
    }

    @Override
    public void delete(Long id) {
        VLPDbProcessDao vLPDbProcessDao = (VLPDbProcessDao) dao;
        vLPDbProcessDao.delete(id);
    }

    @Override
    public void update(PersonLawfulDetail personLawfulDetail) {
        super.update(personLawfulDetail);

    }

    public PersonLawfulDetail find(Long userId) {

        VLPDbProcessDao vLPDbProcessDao = (VLPDbProcessDao) dao;
        return vLPDbProcessDao.find(userId);
    }

    public Page<PersonLawfulDetail> findAll(Integer pageNum, Integer pageSize) {
        VLPDbProcessDao vLPDbProcessDao = (VLPDbProcessDao) dao;
        return vLPDbProcessDao.findAll(pageNum, pageSize);
    }
}