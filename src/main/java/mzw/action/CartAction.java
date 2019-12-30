package mzw.action;

import java.util.List;

import javax.servlet.http.HttpSession;

import mzw.entity.Address;
import mzw.entity.Book;
import mzw.entity.Order;
import mzw.entity.User;
import mzw.service.AddressService;
import mzw.service.BookService;
import mzw.service.CartService;
import mzw.service.OrderService;
import mzw.service.impl.AddressServiceImpl;
import mzw.service.impl.BookServiceImpl;
import mzw.service.impl.CartServiceImpl;
import mzw.service.impl.OrderServiceImpl;
import mzw.util.MD5Utils;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

public class CartAction extends ActionSupport {
	private Book book;
	private Integer changeCount;//更改数量
	private String message;
	private List<Order> orders;
	private Order order;
	private List<Address> addresses;
	private Address address;
	//购买
	public String addCart(){
		BookService bs = new BookServiceImpl();
		book = bs.queryOneBook(book.getId());
		CartService cs = new CartServiceImpl();
		cs.addCart(book);
		return "addCartSuccess";
	}
	//删除商品项
	public String removeCartItem(){
		CartService cs = new CartServiceImpl();
		cs.removeCartItem(book.getId());
		return "removeCartItemSuccess";
	}
	//变更
	public String change1(){
		CartService cs = new CartServiceImpl();
		try {
			cs.change1(changeCount, book.getId());
		} catch (Exception e) {
			message=e.getMessage();
			return "changeError";
		}	
		return "changeSuccess";
	}
	//查出所有旧地址并填充
	public String oldAddress(){
		System.out.println("!!!!!!!address:"+address);
		AddressService as = new AddressServiceImpl();
		addresses = as.queryAllAddressByUserId();
		if(address!=null){
			System.out.println(address.getId());
			address=as.queryOneAddressById(address.getId());
		}
		return "oldAddressSuccess";
	}
	//下单成功 1.插入订单项 2.插入订单 3.插入地址
	public String  placeOrder(){
		OrderService os = new OrderServiceImpl();
		os.insertOrderAndOrderItemAndAddress(address);
		return "placeOrderSuccess";
	}
	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}
	public Integer getChangeCount() {
		return changeCount;
	}
	public void setChangeCount(Integer changeCount) {
		this.changeCount = changeCount;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public List<Order> getOrders() {
		return orders;
	}
	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}
	public Order getOrder() {
		return order;
	}
	public void setOrder(Order order) {
		this.order = order;
	}
	public List<Address> getAddresses() {
		return addresses;
	}
	public void setAddresses(List<Address> addresses) {
		this.addresses = addresses;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
}
