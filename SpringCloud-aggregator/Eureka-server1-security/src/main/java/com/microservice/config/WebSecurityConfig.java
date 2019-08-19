package com.microservice.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * ����spring boot2.0���Spring security ��Ĭ�Ͽ�����csrf����
 * ���е����󶼱���Я��crsf�������,�ر�csrf
 * �½�һ�������ࣨ��һ�������Ļ���ע�����������������Ƿ����޷�ע������ģ�
 */


@EnableWebSecurity
@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		//�ر�csrf
        http.csrf().disable(); 
        //������֤
        http.authorizeRequests().anyRequest().authenticated().and().httpBasic(); 
	}
}
