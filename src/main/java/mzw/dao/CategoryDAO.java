package mzw.dao;

import java.util.List;

import mzw.entity.Category;

import org.apache.ibatis.annotations.Param;

public interface CategoryDAO {	
	/**
	 * @return 查找所有分类
	 */
	List<Category> queryAll();	
	/**
	 * @param levels  查询所有该类
	 * @return
	 */
	List<Category> queryCategory(Integer levels);

	/**
	 * @param category  添加一级类别
	 */
	void addFirst(Category category);
	/**
	 * @param category   添加二级类别
	 */
	void addSecond(Category category);

	/**
	 * @param levels
	 * @param name   查询是否存在一级或二级类别
	 * @return
	 */
	Category selectClass(@Param("levels")Integer levels,@Param("name")String name);

	/**
	 * @param levels
	 * @param id    查询当前二级类别下所有图书
	 * @return
	 */
	Category selectSecond(@Param("levels")Integer levels,@Param("id")String id);
	

	/**
	 * @param id
	 * @param begin
	 * @param end   分页查询当前二级类别下所有图书
	 * @return
	 */
	Category selectSecondFY(@Param("id")String id,@Param("begin")Integer begin,@Param("end")Integer end);
	/**
	 * @param id   查询当前二级类别下有多少本图书
	 * @return
	 */
	Integer count(@Param("id")String id);
	/**
	 * @param id   根据id删除类别
	 */
	void deleteCategory(String id);
	
	/**
	 * @return   前台展示分类
	 */
	List<Category> queryFirAndSec();
	
	/**
	 * @return  <!-- 查询当前一级分类下所有二级分类 -->
	 */
	Category queryFrontSec(@Param("fid")String fid);
}