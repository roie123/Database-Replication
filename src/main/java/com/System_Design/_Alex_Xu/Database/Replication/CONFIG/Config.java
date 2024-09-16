package com.System_Design._Alex_Xu.Database.Replication.CONFIG;

import com.System_Design._Alex_Xu.Database.Replication.OBJECTS.DynamicDataSource;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.datasource.LazyConnectionDataSourceProxy;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

@Configuration
@EnableTransactionManagement
public class Config {


    @Value("${spring.slave.datasource.url}")
    private String thingy;


    @Bean
    @Qualifier("masterDataSource")
    public DataSource masterDataSource() {
        return DataSourceBuilder.create()
                .url("jdbc:mysql://localhost:3306/masterdb")
                .username("root")
                .password("adiell123")
                .build();
    }


    @Bean
    @Qualifier("slaveDataSource")
    public DataSource slaveDataSource() {
        return DataSourceBuilder.create()
                .url("jdbc:mysql://localhost:3306/slavedb")
                .username("root")
                .password("adiell123")
                .build();
    }

    @Bean
    public DataSource routingDataSource(@Qualifier("masterDataSource") DataSource masterDataSource,
                                        @Qualifier("slaveDataSource") DataSource slaveDataSource) {

        DynamicDataSource dataSource = new DynamicDataSource();
        Map<Object, Object> targetDataSources = new HashMap<>();
        targetDataSources.put(DatasourceType.MASTER, masterDataSource);
        targetDataSources.put(DatasourceType.SLAVE, slaveDataSource);
        dataSource.setTargetDataSources(targetDataSources);
        dataSource.setDefaultTargetDataSource(masterDataSource);  // Set default
        return dataSource;
    }

    @Primary
    @Bean
    public DataSource dataSource(@Qualifier("routingDataSource") DataSource routingDataSource) {
        return new LazyConnectionDataSourceProxy(routingDataSource);
    }

}
