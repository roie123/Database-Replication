package com.System_Design._Alex_Xu.Database.Replication.DbConfig;

import com.System_Design._Alex_Xu.Database.Replication.CONFIG.DataSourceContextHolder;
import org.springframework.stereotype.Component;

@Component
public class DataSourceSwitcher {

    public static void useMaster() {
        DataSourceContextHolder.setDataSourceType("master");
    }

    public static void useSlave() {
        DataSourceContextHolder.setDataSourceType("slave");
    }
}

