package com.microservice.feign;

import org.springframework.stereotype.Component;

@Component
public class HystrixClientFallback  implements FeignConsumerClient{
	
    @Override
	public String hello() {
		return "Feign�ͻ��˷���ʧ��!";
	}

	/*public Object getuser(Integer id) {
		return "Feign�ͻ��˷���ʧ��!";
	}*/

	
	
}
