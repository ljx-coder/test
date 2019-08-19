package com.microservice.feign;

import org.springframework.stereotype.Component;

@Component
public class HystrixClientFallback  implements FeignConsumerClient{
	
    @Override
	public String hello() {
		return "Feign客户端访问失败!";
	}

	/*public Object getuser(Integer id) {
		return "Feign客户端访问失败!";
	}*/

	
	
}
