package test;

import java.util.List;

import mzw.dao.UserDAO;
import mzw.entity.User;
import mzw.util.MybatisUtil;

import org.junit.Test;

public class TestUser {
	@Test
	public void testLogin(){
		UserDAO userDAO = (UserDAO)MybatisUtil.getMapper(UserDAO.class);
		User u = new User();
		u.setEmail("123@qq.com");
		List<User> list = userDAO.query(u);
		MybatisUtil.closeSqlSession();
		System.out.println(list);
	}
}
