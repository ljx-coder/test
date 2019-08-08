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
	 * һ�������,�����Щ�����������Ŀ������ʱ���ִ�е�ʱ��,��Ҫʹ�þ�̬�����,���ִ���������ִ�е�;
	 * ��Ҫ����Ŀ������ʱ��ͳ�ʼ��,�ڲ���������������,�������������õ�ʱ��,��Ҫʹ�þ�̬����,���ִ����Ǳ���ִ�е�.
	 * ��̬����������ص�ʱ�� ���Ѿ����� ����������ֱ�ӵ���
	 */
	
	static{//�ھ�̬������£�factoryֻ�ᱻ����һ��
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
		return factory.openSession();//true Ϊ�Զ��ύ����
	}
	
	public static void closeSqlSession(SqlSession sqlSession){
		if(null != sqlSession) 
				sqlSession.close();
	}
}
