package com.microservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients//开启feign功能
//@EnableCircuitBreaker//开启断路器功能
@EnableHystrixDashboard//开启hystrix仪表盘
public class EurekaConsumerApplication {
   
	public static void main(String[] args) {
		SpringApplication.run(EurekaConsumerApplication.class, args);
	}
    
}
