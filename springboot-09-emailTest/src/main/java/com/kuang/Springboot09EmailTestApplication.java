package com.kuang;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableAsync //开启异步注解功能
@EnableScheduling  //开启定时功能的注解
@SpringBootApplication
public class Springboot09EmailTestApplication {

    public static void main(String[] args) {
        SpringApplication.run(Springboot09EmailTestApplication.class, args);
    }

}
