package demoApplication;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
// Spring Boot项目的核心注解，主要目的是开启自动配置
// @MapperScan的作用是扫描dao层文件，也可以直接在dao层加@Mapper注解
public class MySpringBootApp {
	// 创建项目入口
	public static void main(String[] args) {
		SpringApplication.run(MySpringBootApp.class, args);
	}

}
