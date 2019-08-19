package com.microservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microservice.feign.FeignConsumerClient;

@RestController
public class EurekaConsumerController {
	
	   @Autowired  //����ñ��ط���һ������Զ�̷���
	   private FeignConsumerClient feignConsumerClient;
	   
		//��Զ�̵���
	   	@RequestMapping(value="/sayhello")
	   	public String sayhello(){
	   		return feignConsumerClient.hello();
	   	}
	   
	   /*	//ʵ�ִ��ݲ���Զ�̵���,FeignĬ��ʵ���˸��ؾ���
	   	@RequestMapping(value="/feign/{id}")
	   	public Object getuser(@PathVariable("id") Integer id){
	   		return feignConsumerClient.getuser(id);
	   	}*/
         
	   	
	   	//config client����
	   	@Value("${env}")
	   	private String env;
	   	
	   	@RequestMapping("/env")
	   	public String getenv(){
			return env;
	   	}
	   	
	   	
	   	
	   	
	   	

}
