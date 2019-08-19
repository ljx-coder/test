package com.microservice.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * 由于spring boot2.0版的Spring security 会默认开启防csrf攻击
 * 所有的请求都必须携带crsf这个参数,关闭csrf
 * 新建一个配置类（这一步不做的话，注册中心能启动，但是服务无法注册进来的）
 */


@EnableWebSecurity
@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		//关闭csrf
        http.csrf().disable(); 
        //开启认证
        http.authorizeRequests().anyRequest().authenticated().and().httpBasic(); 
	}
}
