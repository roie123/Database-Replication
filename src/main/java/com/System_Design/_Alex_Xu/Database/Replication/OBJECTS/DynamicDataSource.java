package com.System_Design._Alex_Xu.Database.Replication.OBJECTS;

import com.System_Design._Alex_Xu.Database.Replication.CONFIG.DataSourceContextHolder;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

public class DynamicDataSource extends AbstractRoutingDataSource {



    @Override
    protected Object determineCurrentLookupKey() {


        return DataSourceContextHolder.getDataSourceType();
    }



}
