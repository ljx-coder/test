package demoApplication.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import demoApplication.entity.User;
import demoApplication.mapper.UserMapper;
import demoApplication.service.UsersService;

@Service
@Transactional
public class UsersServiceImpl implements UsersService {
	@Autowired
	private UserMapper mapper;

	public int add(User user) {
		return mapper.add(user);
	}

	public int delete(int id) {
		return mapper.delete(id);
	}

	public int update(User user) {
		return mapper.update(user);
	}

	public List<User> selectAll() {
		return mapper.selectAll();
	}

	public User regist(String name) {
		return mapper.regist(name);
	}

	public User login(String name, String pwd) {
		return mapper.login(name, pwd);
	}

}
