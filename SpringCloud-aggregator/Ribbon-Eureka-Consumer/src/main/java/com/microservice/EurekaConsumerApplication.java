package com.microservice;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableEurekaClient
@RestController
public class EurekaConsumerApplication {
	
	@Autowired
	private RestTemplate restTemplate;

	public static void main(String[] args) {
		SpringApplication.run(EurekaConsumerApplication.class, args);
	}

	// 实例化restTemplate,纳入spring bean管理
	@Bean
	@LoadBalanced
	public RestTemplate rest() {
		return new RestTemplate();
	}

	
	@SuppressWarnings("unchecked")
	// Rest服务端使用RestTemplate发起http请求,然后得到数据返回给前端
	// 使用getForEntity方法发送请求调用服务生产者资源
	// 传入的参数为URL地址和返回值类型
	@GetMapping("/getTouser")
	public Object getTouser(Integer id) {
		Map<String , Object> map=new HashMap<String, Object>();
		// String str=restTemplate.getForEntity("http://service-provider/client",String.class).getBody();
		
		//map.put("id",4);
	    //map=restTemplate.getForObject("http://service-provider/getuser?id={id}", Map.class,map);
		
		//完整的URL地址为"http://service-provider/getuser?id=?"
		map=restTemplate.getForObject("http://service-provider/getuser?id="+id, Map.class);
		return map;
	}

}
