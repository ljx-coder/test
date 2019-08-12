package com.microservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.microservice.entity.User;
import com.microservice.service.UsersService;

// @RestController 同时包含responsebody和controller注解
@Controller
public class UserController {
	@Autowired
	private UsersService usersService;

	// 直接返回json对象格式,同理集合也可
	@RequestMapping("hello")
	@ResponseBody
	public String hello() {
		return "hello SpringBoot!";
	}

	@RequestMapping("selectAll")
	public String selectAll(Model model) {
		List<User> list = usersService.selectAll();
		model.addAttribute("users", list);
		model.addAttribute("name", "Tom");
		return "index";
	}

}
