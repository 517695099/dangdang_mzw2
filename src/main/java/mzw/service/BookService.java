package mzw.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import mzw.entity.Book;

public interface BookService {
	/**
	 * @param book  查询所有图书
	 * @return
	 */
	List<Book> queryAllBook(Book book);
	/**
	 * @param book  修改图书信息
	 */
	void updateBook(Book book);
	/**
	 * @param book  添加图书
	 */
	void addBook(Book book);
	
	/**
	 * @param book  删除图书(根据Id)
	 */
	void removeBook(Book book);
	/**
	 * @param key
	 * @param val	下拉列表搜索图书
	 * @return
	 */
	List<Book> search(String key,String val);
	
	/**
	 * @param number  随机展示number本书
	 * @return
	 */
	List<Book> randomShow(Integer number);
	/**
	 * @param term
	 * @param newNumber  根据销量/上架时间展示newNumber本书
	 * @return
	 */
	List<Book> newShow(String term,Integer newNumber);
	/**
	 * @param create_date
	 * @param sale
	 * @param newNumber  新书热卖榜
	 * @return
	 */
	List<Book> newTwoShow(Integer newNumber);
	
	/**
	 * @param parent_id   查询当前一级类别下所有图书
	 * @return
	 */
	List<Book>  queryFirstBook(String parent_id);
	
	/**
	 * @param parent_id
	 * @param currentPage    分页查询当前一级类别下所有图书
	 * @param showSize
	 * @return
	 */
	List<Book>  queryFirstBookFY(String fid,String sid,Integer currentPage,Integer showSize);
	/**
	 * @param parent_id
	 * @param showSize   计算当前一级类别下的图书共几页
	 * @return
	 */
	Integer totalPage(String fid,String sid,Integer showSize);
	/**
	 * @param parent_id    查询当前一级类别下有多少本图书
	 * @return
	 */
	Integer count(String fid,String sid);
	/**
	 * @param id
	 * @return   根据id查询一本图书
	 */
	Book queryOneBook(String id);
}
