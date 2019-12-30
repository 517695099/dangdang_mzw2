package mzw.service.impl;

import java.util.List;
import java.util.UUID;

import mzw.dao.BookDAO;
import mzw.entity.Book;
import mzw.service.BookService;
import mzw.util.MybatisUtil;

public class BookServiceImpl implements BookService {
	//查询所有图书信息
	@Override
	public List<Book> queryAllBook(Book book) {
		BookDAO bookDAO=(BookDAO)MybatisUtil.getMapper(BookDAO.class);
		List<Book> list = bookDAO.queryAllBook(book);
		MybatisUtil.closeSqlSession();
		return list;
	}
	
	
	//修改图书信息
	@Override
	public void updateBook(Book book) {
		BookDAO bookDAO=(BookDAO)MybatisUtil.getMapper(BookDAO.class);
		bookDAO.updateBook(book);
		try {
			MybatisUtil.commit();
		} catch (Exception e) {
			MybatisUtil.rollback();
		}
	}

	//添加图书
	@Override
	public void addBook(Book book) {
		BookDAO bookDAO=(BookDAO)MybatisUtil.getMapper(BookDAO.class);
		book.setId(UUID.randomUUID().toString());
		bookDAO.addBook(book);
		try {
			MybatisUtil.commit();
		} catch (Exception e) {
			MybatisUtil.rollback();
		}	
	}

	//删除图书
	@Override
	public void removeBook(Book book) {//根据Id删除图书
		BookDAO bookDAO=(BookDAO)MybatisUtil.getMapper(BookDAO.class);
		bookDAO.removeBook(book.getId());
		try {
			MybatisUtil.commit();
		} catch (Exception e) {
			MybatisUtil.rollback();
		}	
	}

	
	//下拉列表搜索图书
	@Override
	public List<Book> search(String key, String val) {//key=列名  val=值
		BookDAO bookDAO=(BookDAO)MybatisUtil.getMapper(BookDAO.class);
		List<Book> list = bookDAO.search(key, val);
		MybatisUtil.closeSqlSession();
		return list;
	}

	//前台编辑推荐(随机展示Number条数据)
	@Override
	public List<Book> randomShow(Integer number) {
		BookDAO bookDAO=(BookDAO)MybatisUtil.getMapper(BookDAO.class);
		List<Book> list = bookDAO.randomShow(number);
		MybatisUtil.closeSqlSession();
		return list;
	}

	//热卖榜/最新上架榜
	@Override
	public List<Book> newShow(String term, Integer newNumber) {
		BookDAO bookDAO=(BookDAO)MybatisUtil.getMapper(BookDAO.class);
		List<Book> list = bookDAO.newShow(term, newNumber);
		MybatisUtil.closeSqlSession();
		return list;
	}

	//新书热卖榜
	@Override
	public List<Book> newTwoShow(Integer newNumber) {
		BookDAO bookDAO=(BookDAO)MybatisUtil.getMapper(BookDAO.class);
		List<Book> list = bookDAO.newTwoShow("create_date","sale", newNumber);
		MybatisUtil.closeSqlSession();
		return list;
	}

	//查询当前一级类别下所有的图书
	@Override
	public List<Book> queryFirstBook(String parent_id) {
		BookDAO bookDAO=(BookDAO)MybatisUtil.getMapper(BookDAO.class);
		List<Book> list = bookDAO.queryFirstBook(parent_id);
		MybatisUtil.closeSqlSession();
		return list;
	}


	@Override
	public List<Book> queryFirstBookFY(String fid,String sid, Integer currentPage,
			Integer showSize) {
		BookDAO bookDAO=(BookDAO)MybatisUtil.getMapper(BookDAO.class);
		Integer begin=(currentPage-1)*showSize;
		Integer end =currentPage*showSize;
		List<Book> list = bookDAO.selectSecond(fid, sid, begin, end);
		MybatisUtil.closeSqlSession();
		return list;
	}


	@Override
	public Integer totalPage(String fid,String sid, Integer showSize) {
		BookDAO bookDAO=(BookDAO)MybatisUtil.getMapper(BookDAO.class);
		Integer totalPage = null;
		Integer count = bookDAO.count(fid, sid);
		if(count%showSize==0){
				totalPage=count/showSize;
		}else{
				totalPage=count/showSize+1;
		}
		MybatisUtil.closeSqlSession();
		return totalPage;
	}


	@Override
	public Integer count(String fid,String sid) {
		BookDAO bookDAO=(BookDAO)MybatisUtil.getMapper(BookDAO.class);
		Integer count = bookDAO.count(fid, sid);
		return count;
	}


	@Override
	public Book queryOneBook(String id) {
		BookDAO bookDAO=(BookDAO)MybatisUtil.getMapper(BookDAO.class);
		Book book = bookDAO.queryOneBook(id);
		MybatisUtil.closeSqlSession();
		return book;
	}
}
