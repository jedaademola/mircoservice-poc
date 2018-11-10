package com.microservice.poc.dao;

import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class ApiMonitorDao {
    protected static final String RETURN_VALUE = "Return Value";

    public HashMap<String, String> getLookupValues() {
        //SqlParameterSource in = new MapSqlParameterSource();
        //TODO(Connect to temp db and do select of “select * from dual”
        Map<String, Object> m = null;// getLookUpValues.execute(in);
        HashMap<String, String> lookupValues =
                m.containsKey(RETURN_VALUE) ? ((List<HashMap<String, String>>)
                        m.get(RETURN_VALUE)).get(0) : null;
        return lookupValues;

    }

}
