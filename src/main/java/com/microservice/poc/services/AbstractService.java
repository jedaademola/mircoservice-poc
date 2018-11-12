package com.microservice.poc.services;


import com.microservice.poc.dao.AbstractDao;
import com.microservice.poc.domain.AbstractModel;
import com.microservice.poc.domain.Page;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


public abstract class AbstractService<T extends AbstractModel> {


    protected AbstractDao<T> dao;

    public AbstractService(AbstractDao<T> dao) {
        this.dao = dao;
    }

    @Transactional
    public T create(T model) {
        return dao.create(model);
    }

    @Transactional
    public void update(T model) {
        dao.update(model);
    }


    @Transactional
    public void delete(Long id) {
        dao.delete(id);
    }

    public T find(Long id) {
        return dao.find(id);
    }

    public List<T> findAll() {
        return dao.findAll();
    }

    public Page<T> findAll(Integer pageNum, Integer pageSize) {
        return dao.findAll(pageNum, pageSize);
    }


}
