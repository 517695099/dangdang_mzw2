package test;

import java.util.List;

import mzw.dao.CategoryDAO;
import mzw.entity.Category;
import mzw.util.MybatisUtil;

import org.junit.Test;

public class TestCategory {
	@Test
	public void testQuery(){
		CategoryDAO categoryDAO=(CategoryDAO)MybatisUtil.getMapper(CategoryDAO.class);
		List<Category> list = categoryDAO.queryAll();
		for (Category category : list) {
			System.out.println(category);
		}
		MybatisUtil.closeSqlSession();
	}
	@Test
	public void test2(){
		CategoryDAO categoryDAO=(CategoryDAO)MybatisUtil.getMapper(CategoryDAO.class);
		Category c = categoryDAO.selectSecond(2,"eda814ee-d815-41ab-b3aa-4b9313dacaff");
		MybatisUtil.closeSqlSession();
		System.out.println(c);
	}
	@Test
	public void test3(){
		CategoryDAO categoryDAO=(CategoryDAO)MybatisUtil.getMapper(CategoryDAO.class);
		List<Category> list = categoryDAO.queryFirAndSec();
		System.out.println(list.get(0));
		MybatisUtil.closeSqlSession();	
	}
	/*@Test
	public void test4(){
		CategoryDAO categoryDAO=(CategoryDAO)MybatisUtil.getMapper(CategoryDAO.class);
		Category c = new Category();
		//c.setParent_id("e3a61c36-ab29-4e92-aeeb-dd67a48d38d1");
		c.setId("e3a61c36-ab29-4e92-aeeb-dd67a48d38d1");
		//c.setId("f0dbdcb6-1857-4063-8759-090265c217c1");
		List<Category> list = categoryDAO.queryFrontSecAndBook(c);
		for (Category category : list) {
			int i = category.getBooks().size();
			System.out.println(i);
			//System.out.println(category.getName());
		}
		MybatisUtil.closeSqlSession();
	}*/
	@Test
	public void test5(){
		CategoryDAO categoryDAO=(CategoryDAO)MybatisUtil.getMapper(CategoryDAO.class);
		
		MybatisUtil.closeSqlSession();
		
	}
}
