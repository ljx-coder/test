package com.microservice.controller;


import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microservice.entity.User;
import com.microservice.reponsitory.UserRepository;

@RestController
public class UserController {
	@Autowired
	private UserRepository userRepository;
 
	@RequestMapping("/save")
	public Object save(){
		 /*Date data = new Date();
	     SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	     String formattedDate = dateFormat.format(data);*/
		User person=userRepository.save(new User("遂宁市", 33, new Date(), "说的就"));
		return person;
	}
	
	//通过save方法实现update操作
	@RequestMapping("/saveUpdate")
	public Object saveUpdate(){
		return userRepository.save(new User((long) 3,"卡萨达", 22, new Date(), "安静的"));
	}
	
	//自定义删除
	@RequestMapping("/delete")
	public Object delete(){
		return "成功删除"+userRepository.delete(1)+"条数据";
	}
	
	//自定义查询
	@RequestMapping("/findByName")
	public User findByName(){
		return userRepository.findByName("家得福");
	}
	
	//自定义修改
	@RequestMapping("/update")
	public Object update(){
		return "成功修改"+userRepository.update("阿开发费","咖啡",(long)4)+"条数据";
	}
	
	@RequestMapping("/findAll")
	public Object findAll(){
		List<User> list=userRepository.findAll();
		return list;
	}
	
	
	
	
	
	
	
}
