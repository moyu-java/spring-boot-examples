package com.junmoyu.example.logback;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

/**
 * 服务启动器
 *
 * @author 莫语
 */
@Slf4j
@EnableAsync
@SpringBootApplication
public class SpringBootLogbackApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringBootLogbackApplication.class, args);
    }
}
