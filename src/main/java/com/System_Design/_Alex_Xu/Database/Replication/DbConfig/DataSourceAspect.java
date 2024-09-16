package com.System_Design._Alex_Xu.Database.Replication.DbConfig;

import com.System_Design._Alex_Xu.Database.Replication.CONFIG.DataSourceContextHolder;
import com.System_Design._Alex_Xu.Database.Replication.CONFIG.DatasourceType;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.aspectj.lang.JoinPoint;

@Aspect
@Component
public class DataSourceAspect {

    @Pointcut("@annotation(ReadOnly)")
    public void readOnlyMethods() {}


    @Before("readOnlyMethods()")
    public void beforeReadOnlyMethod(JoinPoint joinPoint) {
        DataSourceContextHolder.setDataSourceType(DatasourceType.SLAVE.getType());
    }

    @After("readOnlyMethods()")
    public void afterReadOnlyMethod(JoinPoint joinPoint) {
        DataSourceContextHolder.clearDataSourceType();
    }

    @Pointcut("!@annotation(ReadOnly)")
    public void writeMethods() {}

    @Before("writeMethods()")
    public void beforeWriteMethod(JoinPoint joinPoint) {
        DataSourceContextHolder.setDataSourceType(DatasourceType.MASTER.getType());
    }

    @After("writeMethods()")
    public void afterWriteMethod(JoinPoint joinPoint) {
        DataSourceContextHolder.clearDataSourceType();
    }


}
