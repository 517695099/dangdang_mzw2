package mzw.service.impl;

import java.util.List;
import java.util.UUID;

import mzw.dao.CategoryDAO;
import mzw.entity.Book;
import mzw.entity.Category;
import mzw.service.CategoryService;
import mzw.util.MybatisUtil;

public class CategoryServiceImpl implements CategoryService {

	/* (non-Javadoc)
	 * @see mzw.service.CategoryService#queryAll()  查询所有类别
	 */
	@Override
	public List<Category> queryAll() {
		CategoryDAO categoryDAO=(CategoryDAO)MybatisUtil.getMapper(CategoryDAO.class);
		List<Category> list = categoryDAO.queryAll();
		MybatisUtil.closeSqlSession();
		return list;
	}

	/* (non-Javadoc)
	 * @see mzw.service.CategoryService#queryAllSecond() 查询所有二级类别
	 */
	@Override
	public List<Category> queryAllSecond() {
		CategoryDAO categoryDAO=(CategoryDAO)MybatisUtil.getMapper(CategoryDAO.class);
		List<Category> list = categoryDAO.queryCategory(2);
		MybatisUtil.closeSqlSession();
		return list;
	}

	/* (non-Javadoc)
	 * @see mzw.service.CategoryService#addFirst(mzw.entity.Category)  添加一级类别
	 */  
	@Override
	public void addFirst(Category category) {
		CategoryDAO categoryDAO=(CategoryDAO)MybatisUtil.getMapper(CategoryDAO.class);
		Category first = categoryDAO.selectClass(1,category.getName());
		System.out.println("first:"+first);
		if(first!=null)throw new RuntimeException("该一级类别已存在");
		try {
			category.setLevels(1);
			category.setId(UUID.randomUUID().toString());
			categoryDAO.addFirst(category);
			MybatisUtil.commit();
		} catch (Exception e) {
			MybatisUtil.rollback();
		}	
	}
	/* (non-Javadoc)
	 * @see mzw.service.CategoryService#queryAllFirst()  查询所有一级分类
	 */
	@Override
	public List<Category> queryAllFirst() {
		CategoryDAO categoryDAO=(CategoryDAO)MybatisUtil.getMapper(CategoryDAO.class);
		List<Category> list = categoryDAO.queryCategory(1);
		MybatisUtil.closeSqlSession();
		return list;
	}

	@Override
	public void addSecond(Category category) {
		CategoryDAO categoryDAO=(CategoryDAO)MybatisUtil.getMapper(CategoryDAO.class);
		Category second = categoryDAO.selectClass(2,category.getName());
		if(second!=null)throw new RuntimeException("该二级类别已存在");
		try {
			category.setLevels(2);
			category.setId(UUID.randomUUID().toString());
			categoryDAO.addSecond(category);
			MybatisUtil.commit();
		} catch (Exception e) {
			MybatisUtil.rollback();
		}	
		
	}
	//删除类别
	@Override
	public void deleteCategory(Category category) {
		CategoryDAO categoryDAO=(CategoryDAO)MybatisUtil.getMapper(CategoryDAO.class);
		if(category.getLevels()==1){
			 Category sec = categoryDAO.queryFrontSec(category.getId());
			if(sec.getCategories().size()!=0)throw new RuntimeException("该一级分类下存在二级类别");
			else categoryDAO.deleteCategory(category.getId());
		}else{
			Category c = categoryDAO.selectSecond(2,category.getId());
			System.out.println("该二级分类:"+c);
			List<Book> books = c.getBooks();
			System.out.println("books:"+books);
			if(books!=null&&books.size()!=0)throw new RuntimeException("该二级分类下存在图书!");
			else categoryDAO.deleteCategory(category.getId());
		}
		try {
			MybatisUtil.commit();
		} catch (Exception e) {
			MybatisUtil.rollback();
		}	
	}
	//前台展示分类
	@Override
	public List<Category> queryClass() {
		CategoryDAO categoryDAO=(CategoryDAO)MybatisUtil.getMapper(CategoryDAO.class);
		List<Category> Firstlist = categoryDAO.queryFirAndSec();
		MybatisUtil.closeSqlSession();
		return Firstlist;
	}

	@Override
	public Category querySecond(String fid) {
		CategoryDAO categoryDAO=(CategoryDAO)MybatisUtil.getMapper(CategoryDAO.class);
		  Category category = categoryDAO.queryFrontSec(fid);
		return category;
	}
	/**
	 * @param id
	 * @return  获取当前二级类别下所有的图书
	 */
	public Category getAllSecondBooks(String id){
		CategoryDAO categoryDAO=(CategoryDAO)MybatisUtil.getMapper(CategoryDAO.class);
		Category category = categoryDAO.selectSecond(2, id);
		MybatisUtil.closeSqlSession();
		return category;
	}
	
	/**
	 * @param id
	 * @param currentPage   分页展示当前二级类别下所有的图书
	 * @param showSize
	 * @return
	 */
	public Category getAllSecondBooksFY(String id,Integer currentPage,Integer showSize){
		CategoryDAO categoryDAO=(CategoryDAO)MybatisUtil.getMapper(CategoryDAO.class);
		Integer begin =(currentPage-1)*showSize;
		Integer end = currentPage*showSize;
		Category category = categoryDAO.selectSecondFY(id, begin,end);
		MybatisUtil.closeSqlSession();
		return category;
	}
	
	public Integer totalPage(String id,Integer showSize){
		CategoryDAO categoryDAO=(CategoryDAO)MybatisUtil.getMapper(CategoryDAO.class);
		Integer totalPage=null;
		Integer count = categoryDAO.count(id);
		if(count%showSize==0){
			totalPage=count/showSize;
		}else{
			totalPage=count/showSize+1;	
		}
		MybatisUtil.closeSqlSession();
		return totalPage;	
	}
		
}
