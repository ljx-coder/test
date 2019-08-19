package com.microservice.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name="service-provider",fallback=HystrixClientFallback.class)
public interface FeignConsumerClient {
	
	//采用Feign使用SpringMVC的注解来对服务进行绑定！
	//@RequestMapping(value="/hello",method=RequestMethod.GET)
	@GetMapping("hello")
	public String hello();
	
	/*@RequestMapping(value="/getuser/{id}",method=RequestMethod.POST)
	public Object getuser(@PathVariable("id") Integer id);*/

}
