package com.System_Design._Alex_Xu.Database.Replication;

import com.System_Design._Alex_Xu.Database.Replication.SERVICE.DatabaseInfoService;
import org.springframework.boot.CommandLineRunner;

public class StartupRunner implements CommandLineRunner {


    private final DatabaseInfoService databaseInfoService;

    public StartupRunner(DatabaseInfoService databaseInfoService) {
        this.databaseInfoService = databaseInfoService;
    }

    @Override
    public void run(String... args) {
        databaseInfoService.printDatabaseInfo();
    }


}
