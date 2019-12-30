package mzw.dao;


import java.util.List;

import mzw.entity.Book;

import org.apache.ibatis.annotations.Param;

public interface BookDAO {

	/**
	 * @param book
	 * @return     查询所有图书
	 */
	List<Book> queryAllBook(Book book);
	/**
	 * @param book
	 * @return   修改图书信息
	 */
	void updateBook(Book book);
	/**
	 * @param book  添加图书
	 */
	void addBook(Book book);
	/**
	 * @param id  根据id删除图书
	 */
	void removeBook(@Param("id")String id);
	/**
	 * @param key
	 * @param val  下拉列表搜索图书
	 * @return
	 */
	List<Book> search(@Param("key")String key,@Param("val")String val);
	/**
	 * @param number  随机查询number条数据
	 * @return
	 */
	List<Book> randomShow(@Param("number")Integer  number);

	/**
	 * @param term
	 * @param newNumber  根据单个条件展示newNumber条数据
	 * @return
	 */
	List<Book> newShow(@Param("term")String term,@Param("newNumber")Integer newNumber);
	List<Book> newTwoShow(@Param("create_date")String create_date,@Param("sale")String sale,@Param("newNumber")Integer newNumber);
	
	/**
	 * @param parent_id  一级类别下所有的图书
	 * @return
	 */
	List<Book>  queryFirstBook(@Param("parent_id")String parent_id);

	/**
	 * @param parent_id
	 * @param begin
	 * @param end  分页展示一级类别下所有的图书
	 * @return
	 */
	List<Book>  queryFirstBookFY(@Param("parent_id")String parent_id,@Param("begin")Integer begin,@Param("end")Integer end);
	/**
	 * @param parent_id   查询当前一级类别下有几本图书
	 * @return
	 */
	Integer count(@Param("fid")String fid,@Param("sid")String sid);
	/**
	 * @param id   根据Id查询一本图书
	 * @return
	 */
	Book queryOneBook(@Param("id")String id);
	
	List<Book>  selectSecond(@Param("fid")String fid,@Param("sid")String sid,@Param("begin")Integer begin,@Param("end")Integer end);
	
	/**
	 * @param list    批量修改图书信息
	 * @return
	 */
	int updateList(List<Book> list);
}
