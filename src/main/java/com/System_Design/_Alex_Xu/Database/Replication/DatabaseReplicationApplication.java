package com.System_Design._Alex_Xu.Database.Replication;

import com.System_Design._Alex_Xu.Database.Replication.SERVICE.DatabaseInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableAspectJAutoProxy
public class DatabaseReplicationApplication {



	public static void main(String[] args) {

		SpringApplication.run(DatabaseReplicationApplication.class, args);



	}

}
