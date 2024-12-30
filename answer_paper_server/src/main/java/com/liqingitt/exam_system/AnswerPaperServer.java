package com.liqingitt.exam_system;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.liqingitt.exam_system.mapper")
public class AnswerPaperServer {
    public static void main(String[] args) {
        SpringApplication.run(AnswerPaperServer.class, args);
    }
}