package com.fanta.newspriborzhavalyceum;

import com.fanta.newspriborzhavalyceum.database.repository.UserRepository;
import com.fanta.newspriborzhavalyceum.database.service.UserService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration

@SpringBootApplication
@EnableTransactionManagement
@EnableJpaRepositories
public class NewsPriborzhavaLyceumApplication {

    public static void main(String[] args) {

        SpringApplication.run(NewsPriborzhavaLyceumApplication.class, args);
    }




}
