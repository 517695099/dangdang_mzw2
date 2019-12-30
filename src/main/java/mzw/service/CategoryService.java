package mzw.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import mzw.entity.Category;

public interface CategoryService {
	/**
	 * @return  展示所有分类
	 */
	List<Category> queryAll();
	/**
	 * @return  查询所有二级分类
	 */
	List<Category> queryAllSecond();
	/**
	 * @return  查询所有一级分类
	 */
	List<Category> queryAllFirst();
	/**
	 * @param category 添加一级类别
	 */
	void addFirst(Category category);
	
	/**
	 * @param category  添加二级类别
	 */
	void addSecond(Category category);
	
	/**
	 * @param category  删除类别
	 */
	void deleteCategory(Category category);
	/**
	 * @return 查询所有一级类别及其所有二级类别
	 */
	List<Category>  queryClass();
	

	/**
	 * @param fid   一级分类下所有的二级分类
	 * @return
	 */
	Category querySecond(String fid);
	/**
	 * @param id
	 * @return    获取当前二级类别下所有的图书
	 */
	Category getAllSecondBooks(String id);
	
	/**
	 * @param id
	 * @param currentPage
	 * @param showSize   分页获取当前二级类别下所有的图书
	 * @return
	 */
	Category getAllSecondBooksFY(String id,Integer currentPage,Integer showSize);
	
	 /**
	 * @param id
	 * @param showSize    获取当前二级类别下图书的总页数
	 * @return
	 */
	Integer totalPage(String id,Integer showSize);
}
