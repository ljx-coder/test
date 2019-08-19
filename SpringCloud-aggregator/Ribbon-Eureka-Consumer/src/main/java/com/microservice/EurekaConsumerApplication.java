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

	// ʵ����restTemplate,����spring bean����
	@Bean
	@LoadBalanced
	public RestTemplate rest() {
		return new RestTemplate();
	}

	
	@SuppressWarnings("unchecked")
	// Rest�����ʹ��RestTemplate����http����,Ȼ��õ����ݷ��ظ�ǰ��
	// ʹ��getForEntity��������������÷�����������Դ
	// ����Ĳ���ΪURL��ַ�ͷ���ֵ����
	@GetMapping("/getTouser")
	public Object getTouser(Integer id) {
		Map<String , Object> map=new HashMap<String, Object>();
		// String str=restTemplate.getForEntity("http://service-provider/client",String.class).getBody();
		
		//map.put("id",4);
	    //map=restTemplate.getForObject("http://service-provider/getuser?id={id}", Map.class,map);
		
		//������URL��ַΪ"http://service-provider/getuser?id=?"
		map=restTemplate.getForObject("http://service-provider/getuser?id="+id, Map.class);
		return map;
	}

}
