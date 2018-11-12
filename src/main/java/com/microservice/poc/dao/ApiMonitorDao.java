package com.microservice.poc.dao;

import com.microservice.poc.domain.AbstractModel;
import com.microservice.poc.domain.TwoParam;
import com.microservice.poc.utility.H2PocUtil;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.HashMap;

@Repository
public class ApiMonitorDao extends AbstractDao<AbstractModel> {

    @Override
    public void setDataSource(DataSource dataSource) {

    }

    public HashMap<String, String> getLookupValues() throws SQLException, ClassNotFoundException {
        //TODO(Connect to temp db and do select of “select * from dual”
        HashMap<String, String> lookupValues = new HashMap<>();
        TwoParam readFromDB = H2PocUtil.read();
        lookupValues.put(readFromDB.getId().toString(), readFromDB.getContent());
        return lookupValues;

    }
}
