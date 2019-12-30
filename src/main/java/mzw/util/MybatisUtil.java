package mzw.util;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MybatisUtil{
	private static SqlSessionFactory sqlSessionFactory;
	private static final ThreadLocal<SqlSession> tl = new ThreadLocal<SqlSession>();
	private static InputStream is;
	static{
		try {
			 is = Resources.getResourceAsStream("mybatis-config.xml");
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
		} catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException("读取配置文件错误");
		}finally{
			if(is!=null)try{is.close();}catch(Exception e){e.printStackTrace();}
		}
	}
	
	public static SqlSession openSqlSession(){ 
		SqlSession sqlSession = tl.get();
		if(sqlSession==null){
			sqlSession = sqlSessionFactory.openSession();
			tl.set(sqlSession);
		} 
		return sqlSession;
	}
	public static Object getMapper(Class clz){
		SqlSession sqlSession = openSqlSession();
		return sqlSession.getMapper(clz);
	}
	
	public static void closeSqlSession(){
		SqlSession sqlSession = openSqlSession();
		sqlSession.close();
		tl.remove();
	}
	
	public static void commit(){
		SqlSession sqlSession = openSqlSession();
		sqlSession.commit();
		closeSqlSession();
	}
	
	public static void rollback(){
		SqlSession sqlSession = openSqlSession();
		sqlSession.rollback();
		closeSqlSession();
	}
}
