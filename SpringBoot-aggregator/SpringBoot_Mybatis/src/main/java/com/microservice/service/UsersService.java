package com.microservice.service;

import java.util.List;

import com.microservice.entity.User;

public interface UsersService {
	public int add(User user);

	public int delete(int id);

	public int update(User user);

	public List<User> selectAll();

	public User regist(String name);

	public User login(String name, String pwd);

}
