package com.yanesh.evaluation.questionapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class QuestionApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(QuestionApiApplication.class, args);
    }

}
