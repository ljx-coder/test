package com.microservice;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableDiscoveryClient 
@RestController
public class EurekaProviderApplication {

	public static void main(String[] args) {
		SpringApplication.run(EurekaProviderApplication.class, args);
	}

	@Value("${server.port}")
	private String port;

	//服务消费者使用RestTemplate实现负载均衡远程调用
	/*@RequestMapping("/getuser")
	public Object getuser(Integer id) {
		Map<String, Object> map=new HashMap<String, Object>();
		map.put("id",id);
		map.put("name", "admin");
		map.put("from", "provider-B");
		return map;
	}*/
	
	//服务消费者使用Feign通过API接口实现负载均衡远程调用
	@RequestMapping("/getuser/{id}")
	public Object getuser(@PathVariable("id")Integer id) {
	    
		Map<String, Object> map=new HashMap<String, Object>();
		map.put("id",id);
		map.put("name", "admin");
		map.put("from", "provider-B");
		return map;
	}
}
