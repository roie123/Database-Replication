package com.System_Design._Alex_Xu.Database.Replication.CONFIG;

public enum DatasourceType {

    MASTER("masterdb"),
    SLAVE("slavedb");

    private final String type;

    DatasourceType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }


}
