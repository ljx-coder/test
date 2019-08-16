package com.microservice.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data//lombok注解自动生成getter,setter一系列方法，简化代码
@Entity
public class User {

	@Id
	@GeneratedValue
	private Long id;

	@Column(nullable = false, unique = true)
	private String name;

	@Column(nullable = false)
	private Integer age;

	@JsonFormat(pattern="yyyy年MM月dd日 HH时",timezone = "GMT+8")
	private Date birthday;

	@Column(nullable = false)
	private String address;

	public User() {
		super();
	}
	
	public User(String name, Integer age, Date birthday, String address) {
		super();
		this.name = name;
		this.age = age;
		this.birthday = birthday;
		this.address = address;
	}

	public User(Long id, String name, Integer age, Date birthday, String address) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.birthday = birthday;
		this.address = address;
	}

	


}
