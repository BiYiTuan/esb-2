package com.boohoo.esb.database.dao.procedures;

import java.util.Iterator;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.core.SqlReturnResultSet;
import org.springframework.jdbc.object.StoredProcedure;

public class BaseStoredProcedure extends StoredProcedure {

	public BaseStoredProcedure (DataSource ds, String spname, Map map, String sqlOutKey, Integer returnType, RowMapper rowmapper) {
        super();
        setDataSource(ds);

        /* resultset has to be declared first over other declare parameters */
        if (rowmapper != null) {
            declareParameter(new SqlReturnResultSet(sqlOutKey, rowmapper));
        }

        if (map != null) {
            Iterator itr = map.keySet().iterator();
            while (itr.hasNext()) {
                String key = (String) itr.next();
                Integer value = (Integer) map.get(key);
                declareParameter(new SqlParameter(key, value.intValue()));
            }
        }

        /*
         * sql out paramter has to be declared based on the order in stored
         * procedures, In all our stored procedures we have it after input
         * parameters
         */
        if (returnType != null) {
            declareParameter(new SqlOutParameter(sqlOutKey, returnType
                    .intValue()));
        }

        setSql(spname);
        compile();
    }
}