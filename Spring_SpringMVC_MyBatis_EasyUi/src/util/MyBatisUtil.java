package util;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MyBatisUtil {
	private static SqlSessionFactory factory;
	
	/**
	 * 一般情况下,如果有些代码必须在项目启动的时候就执行的时候,需要使用静态代码块,这种代码是主动执行的;
	 * 需要在项目启动的时候就初始化,在不创建对象的情况下,其他程序来调用的时候,需要使用静态方法,这种代码是被动执行的.
	 * 静态方法在类加载的时候 就已经加载 可以用类名直接调用
	 */
	
	static{//在静态代码块下，factory只会被创建一次
		System.out.println("static factory===============");
		try {
			InputStream is = Resources.getResourceAsStream("mybatisConfig.xml");
			factory = new SqlSessionFactoryBuilder().build(is);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
	
	public static SqlSession createSqlSession(){
		return factory.openSession();//true 为自动提交事务
	}
	
	public static void closeSqlSession(SqlSession sqlSession){
		if(null != sqlSession) 
				sqlSession.close();
	}
}
