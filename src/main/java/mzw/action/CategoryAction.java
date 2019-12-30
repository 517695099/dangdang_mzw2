package mzw.action;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import mzw.entity.Book;
import mzw.entity.Category;
import mzw.service.BookService;
import mzw.service.CategoryService;
import mzw.service.impl.BookServiceImpl;
import mzw.service.impl.CategoryServiceImpl;

import com.opensymphony.xwork2.ActionSupport;

public class CategoryAction extends ActionSupport {
	private List<Category> list;
	private Category category;
	private String message;
	private List<Book> listFirstBooks;
	//分页相关
	private String fid;
	private String sid;
	private Integer totalPage;
	private Integer showSize;
	private Integer currentPage;
	//查询所有类别
	public String queryAll(){
		CategoryService cs = new CategoryServiceImpl();
		list = cs.queryAll();
		return "queryAllSuccess";
	}
	//添加一级类别
	public String addFirst(){
		CategoryService cs = new CategoryServiceImpl();
		try {
			cs.addFirst(category);
		} catch (Exception e) {
			message=e.getMessage();
			System.out.println(e.getMessage());
			return "addFirstError";
		}
		return "addFirstSuccess";
	}
	//获取所有一级类别
	public String catchFirst(){
		CategoryService cs = new CategoryServiceImpl();
		list = cs.queryAllFirst();
		return "catchFirstSuccess";
	}
	//添加二级类别
	public String addSecond(){
		CategoryService cs = new CategoryServiceImpl();
		try {
			cs.addSecond(category);
		} catch (Exception e) {
			message=e.getMessage();
			return "addSecondError";
		}
		return "addSecondSuccess";
	}
	//删除类别
	public String deleteCategory(){
		CategoryService cs = new CategoryServiceImpl();
		try {
			cs.deleteCategory(category);
		} catch (Exception e) {
			message = e.getMessage();
			return "deleteCategoryError";
		}
		return "deleteCategorySuccess";
	}
	//~~~~~~~~~~~~~~~~~~~~~~~~~~前台~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	//前台点击二级页面
	public String selectSecond(){
		System.out.println("fid"+fid);
		System.out.println("sid:"+sid);
		CategoryService cs = new CategoryServiceImpl();
		BookService bs = new BookServiceImpl();
		category = cs.querySecond(fid);
		System.out.println("一级分类下的所有二级类别"+category);
		totalPage=bs.totalPage(fid, sid, showSize);
		
		listFirstBooks=bs.queryFirstBookFY(fid, sid, currentPage, showSize);
		System.out.println("分页查询成功");
		HttpSession session = ServletActionContext.getRequest().getSession();
		if(sid==null){
			Integer size=bs.count(fid, sid);
			session.setAttribute("size", size);	
		}
		return "selectSecondSuccess";
	}

	public List<Category> getList() {
		return list;
	}
	public void setList(List<Category> list) {
		this.list = list;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public List<Book> getListFirstBooks() {
		return listFirstBooks;
	}
	public void setListFirstBooks(List<Book> listFirstBooks) {
		this.listFirstBooks = listFirstBooks;
	}
	public Integer getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(Integer totalPage) {
		this.totalPage = totalPage;
	}
	public Integer getShowSize() {
		return showSize;
	}
	public void setShowSize(Integer showSize) {
		this.showSize = showSize;
	}
	public Integer getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}
	public String getFid() {
		return fid;
	}
	public void setFid(String fid) {
		this.fid = fid;
	}
	public String getSid() {
		return sid;
	}
	public void setSid(String sid) {
		this.sid = sid;
	}
}
