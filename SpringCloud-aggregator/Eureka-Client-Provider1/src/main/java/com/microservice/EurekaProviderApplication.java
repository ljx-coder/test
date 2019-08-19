package com.microservice;

import java.util.HashMap;
import java.util.Map;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableDiscoveryClient // 开启eureka客户端功能
@RestController
public class EurekaProviderApplication {

	public static void main(String[] args) {
		SpringApplication.run(EurekaProviderApplication.class, args);
	}

	@RequestMapping("/hello")
	public String hello(){
		return "Hello SpringCloud!";
	}
	
	/*@Value("${server.port}")
	private String port;*/
    //服务消费者通过负载均衡调用服务提供者
	@RequestMapping("/getuser/{id}")
	public Object getuser(@PathVariable("id")Integer id) {
	    
		Map<String, Object> map=new HashMap<String, Object>();
		map.put("id",id);
		map.put("name", "admin");
		map.put("from", "provider-A");
		return map;
	}
}
