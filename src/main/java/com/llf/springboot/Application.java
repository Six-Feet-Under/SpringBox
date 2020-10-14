package com.llf.springboot;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement    //开启事务注解
@MapperScan("com.llf.springboot.dao")
@EnableScheduling
public class Application {
    public static void main(String[] args) throws Exception {
        SpringApplication.run(Application.class, args);
        System.out.println("加载完成");
    }
}
