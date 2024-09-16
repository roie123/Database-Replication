package com.System_Design._Alex_Xu.Database.Replication.SERVICE;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.SQLException;

@Service
public class DatabaseInfoService {

    @Autowired
    @Qualifier("slaveDataSource") // Ensure this is your dynamic datasource
    private DataSource slaveDataSource;



    @Autowired
    @Qualifier("masterDataSource") // Ensure this is your dynamic datasource
    private DataSource masterDataSource;





    public void printDatabaseInfo() {


        System.out.println("============================== DATABASE =====================================");
        try (Connection connection = slaveDataSource.getConnection()) {
            DatabaseMetaData metaData = connection.getMetaData();

            System.out.println("Database Product Name: " + metaData.getDatabaseProductName());
            System.out.println("Database Product Version: " + metaData.getDatabaseProductVersion());
            if (metaData.getURL().equals("jdbc:mysql://localhost:3306/slavedb")){

                System.out.println("SLAVE DATABASE CONNECTED ");

            }


        } catch (SQLException e) {
            System.err.println("Error getting database information: " + e.getMessage());
        }



        try (Connection connection = masterDataSource.getConnection()) {
            DatabaseMetaData metaData = connection.getMetaData();

            System.out.println("Database Product Name: " + metaData.getDatabaseProductName());
            System.out.println("Database Product Version: " + metaData.getDatabaseProductVersion());
            if (metaData.getURL().equals("jdbc:mysql://localhost:3306/masterdb")){

                System.out.println("MASTER DATABASE CONNECTED ");

            }


        } catch (SQLException e) {
            System.err.println("Error getting database information: " + e.getMessage());
        }




    }






}
