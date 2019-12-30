package mzw.action;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpSession;

import mzw.entity.Book;
import mzw.entity.Category;
import mzw.service.BookService;
import mzw.service.CategoryService;
import mzw.service.impl.BookServiceImpl;
import mzw.service.impl.CategoryServiceImpl;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

public class BookAction extends ActionSupport {
	private List<Book> list;
	private List<Category> listcat;
	private Book book;
	private File upload;//文件上传
	private String uploadFileName;
	private String uploadContentType;
	private String directory;
	private String key;
	private String val;
	private Integer number;//编辑推荐本数
	private Integer newNumber;
	private List<Book> listSug;//编辑推荐
	private List<Book> listHotBorad;//新书热卖
	private List<Book> listNew;//最新上架
	private List<Book> listHotSale;//热销
	private List<Category> listCategory;//类别

	//查询所有图书
	public String queryAllBook(){
		BookService bs = new BookServiceImpl();
		list = bs.queryAllBook(book);				
		return "queryAllBookSuccess";
	}
	//下拉列表搜索图书
	public String searchBook(){
		BookService bs = new BookServiceImpl();
		list = bs.search(key, val);
		return "searchBookSuccess";
	}
	//查询所有二级类别
	public String queryAllSecond(){
		BookService bs = new BookServiceImpl();
		CategoryService cs = new CategoryServiceImpl();
		list = bs.queryAllBook(book);
		if(list!=null)book=list.get(0);
		listcat = cs.queryAllSecond();
		return "queryAllSecondSuccess";
	}
	//修改图书信息
	public String updateBook() throws Exception{
		BookService bs = new BookServiceImpl();
		if(upload!=null){	
			String realPath = ServletActionContext.getServletContext().getRealPath(directory);
			FileUtils.copyFile(upload, new File(realPath+"/"+uploadFileName));
			if(book.getCover()==null){
				book.setCover(uploadFileName);
			}
		}
		bs.updateBook(book);
		return "updateBookSuccess";
	}
	//先查询出所有的二级分类
	public String selectSecond(){
		CategoryService cs = new CategoryServiceImpl();
		listcat = cs.queryAllSecond();
		return "selectSecondSuccess";
	}
	//再添加图书
	public String addBook() throws Exception{
		String realPath = ServletActionContext.getServletContext().getRealPath(directory);
		FileUtils.copyFile(upload, new File(realPath+"/"+uploadFileName));
		book.setCover(uploadFileName);
		BookService bs = new BookServiceImpl();
		bs.addBook(book);
		return "addBookSuccess";
	}	
	//删除图书
	public String deleteBook(){
		BookService bs = new BookServiceImpl();
		bs.removeBook(book);
		return "deleteBookSuccess";
		
	}
	//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~前台~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	//展示该书的详细信息
	public String showDetail(){
		BookService bs = new BookServiceImpl();
		list = bs.queryAllBook(book);
		if(list!=null)book=list.get(0);
		return "showDetailSuccess";
	}
	//首页
	public String main(){
		BookService bs = new BookServiceImpl();
		CategoryService cs = new CategoryServiceImpl();
		listSug = bs.randomShow(number);
		listNew=bs.newShow("create_date", newNumber);
		listHotSale = bs.newShow("sale", newNumber);
		listHotBorad = bs.newTwoShow(newNumber);
		listCategory = cs.queryClass();
		return "mainSuccess";
	}
	public List<Book> getList() {
		return list;
	}

	public void setList(List<Book> list) {
		this.list = list;
	}
	public List<Category> getListcat() {
		return listcat;
	}
	public void setListcat(List<Category> listcat) {
		this.listcat = listcat;
	}
	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public File getUpload() {
		return upload;
	}

	public void setUpload(File upload) {
		this.upload = upload;
	}

	public String getUploadFileName() {
		return uploadFileName;
	}

	public void setUploadFileName(String uploadFileName) {
		this.uploadFileName = uploadFileName;
	}
	public String getUploadContentType() {
		return uploadContentType;
	}
	public void setUploadContentType(String uploadContentType) {
		this.uploadContentType = uploadContentType;
	}
	public String getDirectory() {
		return directory;
	}
	public void setDirectory(String directory) {
		this.directory = directory;
	}
	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getVal() {
		return val;
	}

	public void setVal(String val) {
		this.val = val;
	}
	public Integer getNumber() {
		return number;
	}
	public void setNumber(Integer number) {
		this.number = number;
	}
	public Integer getNewNumber() {
		return newNumber;
	}
	public void setNewNumber(Integer newNumber) {
		this.newNumber = newNumber;
	}
	public List<Book> getListSug() {
		return listSug;
	}
	public void setListSug(List<Book> listSug) {
		this.listSug = listSug;
	}
	public List<Book> getListHotBorad() {
		return listHotBorad;
	}
	public void setListHotBorad(List<Book> listHotBorad) {
		this.listHotBorad = listHotBorad;
	}
	public List<Book> getListNew() {
		return listNew;
	}
	public void setListNew(List<Book> listNew) {
		this.listNew = listNew;
	}
	public List<Book> getListHotSale() {
		return listHotSale;
	}
	public void setListHotSale(List<Book> listHotSale) {
		this.listHotSale = listHotSale;
	}
	
	public List<Category> getListCategory() {
		return listCategory;
	}
	public void setListCategory(List<Category> listCategory) {
		this.listCategory = listCategory;
	}
}
