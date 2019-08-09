package com.microservice.feign;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name="service-provider",fallback=HystrixClientFallback.class)
public interface FeignConsumerClient {
	
	//采用Feign我们可以使用SpringMVC的注解来对服务进行绑定！
	@RequestMapping(value="/hello",method=RequestMethod.GET)
	public String hello();
	
	/*@RequestMapping(value="/getuser/{id}",method=RequestMethod.POST)
	public Object getuser(@PathVariable("id") Integer id);*/

}
