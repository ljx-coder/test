package com.microservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microservice.feign.FeignConsumerClient;

@RestController
public class EurekaConsumerController {
	
	   @Autowired  //像调用本地方法一样调用远程服务
	   private FeignConsumerClient feignConsumerClient;
	   
		//简单远程调用
	   	@RequestMapping(value="/sayhello")
	   	public String sayhello(){
	   		return feignConsumerClient.hello();
	   	}
	   
	   /*	//实现传递参数远程调用,Feign默认实现了负载均衡
	   	@RequestMapping(value="/feign/{id}")
	   	public Object getuser(@PathVariable("id") Integer id){
	   		return feignConsumerClient.getuser(id);
	   	}*/
         
	   	
	   	//config client测试
	   	@Value("${env}")
	   	private String env;
	   	
	   	@RequestMapping("/env")
	   	public String getenv(){
			return env;
	   	}
	   	
	   	
	   	
	   	
	   	

}
