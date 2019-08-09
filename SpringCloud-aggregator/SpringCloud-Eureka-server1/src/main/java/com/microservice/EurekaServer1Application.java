package com.microservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer // 表明是一个eureka server，即启动一个服务注册中心
public class EurekaServer1Application {

	public static void main(String[] args) {
		SpringApplication.run(EurekaServer1Application.class, args);
	}

}
