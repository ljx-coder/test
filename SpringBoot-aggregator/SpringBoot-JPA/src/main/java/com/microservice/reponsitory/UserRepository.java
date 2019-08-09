package com.microservice.reponsitory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.microservice.entity.User;

public interface UserRepository extends JpaRepository<User, Long>{
	//添加自定义的方法
	User findByName(String name);
	
	User findByNameOrAddress(String name,String address);
	
	@Transactional
	@Modifying
	@Query("delete from User where id=?1")
	int delete(long id);//返回值只能是void或者int（受影响记录条数）类型

	@Transactional
	@Modifying
	@Query("update User set name=?1,address=?2 where id=?3")
	int update(String name,String address,Long id);

}
