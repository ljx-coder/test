package com.microservice.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
	
	@Value("${env}")
	private String env;
	
	@RequestMapping("/env")
	public String hello(){
		return env;
	}
	

}
