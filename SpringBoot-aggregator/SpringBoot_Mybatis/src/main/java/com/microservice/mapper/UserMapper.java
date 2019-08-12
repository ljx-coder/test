package com.microservice.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.microservice.entity.User;

@Mapper // 代替注解扫描映射文件的需求
public interface UserMapper {

	// sql语句写法遵循数据库书写规则
	@Insert("INSERT INTO userss(name,pwd)VALUES(#{name},#{pwd})")
	public int add(User user);

	@Delete("DELETE FROM userss WHERE uid=#{uid}")
	public int delete(int id);

	@Update("UPDATE userss SET name=#{name},pwd=#{pwd} WHERE uid=#{uid}")
	public int update(User user);

	@Select("SELECT * FROM userss")
	public List<User> selectAll();

	@Select("SELECT * FROM userss WHERE name=#{name}")
	public User regist(String name);

	@Select("SELECT * FROM userss WHERE name=#{name} AND pwd=#{pwd}")
	public User login(String name, String pwd);

}
