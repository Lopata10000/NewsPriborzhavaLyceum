package com.fanta.newspriborzhavalyceum;

import com.fanta.newspriborzhavalyceum.database.service.UserService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages={"com.fanta.newspriborzhavalyceum.database.entity"})
@EntityScan(basePackages="entity")
@SpringBootApplication
public class NewsPriborzhavaLyceumApplication {

    public static void main(String[] args) {
        SpringApplication.run(NewsPriborzhavaLyceumApplication.class, args);
    }




}
