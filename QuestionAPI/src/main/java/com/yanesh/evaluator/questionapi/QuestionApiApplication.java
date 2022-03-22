package com.yanesh.evaluator.questionapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@EnableDiscoveryClient
@SpringBootApplication(scanBasePackages = "com.yanesh.evaluator")
@EnableMongoRepositories
public class QuestionApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(QuestionApiApplication.class, args);
    }

}
