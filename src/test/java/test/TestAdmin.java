package test;

import mzw.dao.AdminDAO;
import mzw.entity.Admin;
import mzw.util.MybatisUtil;

import org.junit.Test;

public class TestAdmin {
	@Test
	public void testLogin(){
		AdminDAO adminDAO = (AdminDAO)MybatisUtil.getMapper(AdminDAO.class);
		Admin admin = adminDAO.login("admin");
		MybatisUtil.closeSqlSession();
		System.out.println(admin);
	}
}
