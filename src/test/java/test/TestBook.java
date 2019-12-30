package test;

import java.util.ArrayList;
import java.util.List;

import mzw.dao.BookDAO;
import mzw.entity.Book;
import mzw.util.MybatisUtil;

import org.junit.Test;

public class TestBook {
	@Test
	public void test1(){
		BookDAO bookDAO = (BookDAO)MybatisUtil.getMapper(BookDAO.class);
		List<Book> list = bookDAO.search("name","金瓶梅");
		MybatisUtil.closeSqlSession();
		for (Book book : list) {
			System.out.println(book);
		}	
	}
	@Test
	public void test2(){//随机展示Number条数据
		BookDAO bookDAO = (BookDAO)MybatisUtil.getMapper(BookDAO.class);
		List<Book> list = bookDAO.randomShow(3);
		for (Book book : list) {
			System.out.println(book.getName());
		}
		MybatisUtil.closeSqlSession();
	}
	@Test
	public void test3(){
		BookDAO bookDAO = (BookDAO)MybatisUtil.getMapper(BookDAO.class);
		List<Book> list = bookDAO.newShow("create_date",2);
		for (Book book : list) {
			System.out.println(book.getName());
		}
		MybatisUtil.closeSqlSession();
	}
	public void sys(String...str){
		for (String string : str) {
			System.out.println(string);
		}
	}
	@Test
	public void test4(){
		BookDAO bookDAO = (BookDAO)MybatisUtil.getMapper(BookDAO.class);
		List<Book> list = bookDAO.newTwoShow("create_date", "sale", 2);
		for (Book book : list) {
			System.out.println(book.getName());
		}
		MybatisUtil.closeSqlSession();
	}
	@Test
	public void test5(){
		BookDAO bookDAO = (BookDAO)MybatisUtil.getMapper(BookDAO.class);
		List<Book> list = bookDAO.queryFirstBook("e3a61c36-ab29-4e92-aeeb-dd67a48d38d1");
		for (Book book : list) {
			System.out.println(book.getName());
		}
		MybatisUtil.closeSqlSession();
		
	}
	@Test
	public void test6(){
		BookDAO bookDAO = (BookDAO)MybatisUtil.getMapper(BookDAO.class);
		List<Book> list = bookDAO.queryFirstBookFY("e3a61c36-ab29-4e92-aeeb-dd67a48d38d1",2,3);
		for (Book book : list) {
			System.out.println(book.getName());
		}
		MybatisUtil.closeSqlSession();
		
	}
	@Test
	public void test7(){
		BookDAO bookDAO = (BookDAO)MybatisUtil.getMapper(BookDAO.class);
		List<Book> list = bookDAO.selectSecond("e3a61c36-ab29-4e92-aeeb-dd67a48d38d1", "f0dbdcb6-1857-4063-8759-090265c217c3", 2, 3);
		for (Book book : list) {
			System.out.println(book.getName());
		}
		MybatisUtil.closeSqlSession();
	}
	@Test
	public void test8(){
		BookDAO bookDAO = (BookDAO)MybatisUtil.getMapper(BookDAO.class);
		List<Book> list = new ArrayList<Book>();
		Book b1 = new Book();
		b1.setId("1");
		b1.setSale(10);
		b1.setStock(10000);
		Book b2 = new Book();
		b2.setId("4");
		b2.setSale(10);
		b2.setStock(10000);
		list.add(b1);
		list.add(b2);
		int i = bookDAO.updateList(list);
		MybatisUtil.commit();
		System.out.println(i);
	}
}
