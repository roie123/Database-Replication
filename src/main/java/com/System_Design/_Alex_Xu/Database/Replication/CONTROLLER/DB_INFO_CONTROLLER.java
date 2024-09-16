package com.System_Design._Alex_Xu.Database.Replication.CONTROLLER;

import com.System_Design._Alex_Xu.Database.Replication.SERVICE.DatabaseInfoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/db-info")
public class DB_INFO_CONTROLLER {



    private final DatabaseInfoService databaseInfoService;

    @GetMapping
    public String getDatabaseInfo() {
        // Print info to the console
        databaseInfoService.printDatabaseInfo();
        return "Database info printed to console.";
    }

}
