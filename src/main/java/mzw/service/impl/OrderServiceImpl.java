package mzw.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

import javax.servlet.http.HttpSession;

import mzw.dao.AddressDAO;
import mzw.dao.BookDAO;
import mzw.dao.OrderDAO;
import mzw.dao.OrderItemDAO;
import mzw.entity.Address;
import mzw.entity.Book;
import mzw.entity.Cart;
import mzw.entity.Order;
import mzw.entity.OrderItem;
import mzw.entity.User;
import mzw.service.OrderService;
import mzw.util.MybatisUtil;

import org.apache.struts2.ServletActionContext;

public class OrderServiceImpl implements OrderService {

	@Override
	public List<Order> queryAllOrder(Order order) {
		OrderDAO orderDAO = (OrderDAO)MybatisUtil.getMapper(OrderDAO.class);
		List<Order> list = orderDAO.queryAllOrder(order);
		MybatisUtil.closeSqlSession();
		return list;
	}

	@Override
	public void insertOrderAndOrderItemAndAddress(Address address) {
		OrderDAO orderDAO = (OrderDAO)MybatisUtil.getMapper(OrderDAO.class);//订单
		OrderItemDAO orderItemDAO=(OrderItemDAO)MybatisUtil.getMapper(OrderItemDAO.class);//订单项
		AddressDAO addressDAO=(AddressDAO)MybatisUtil.getMapper(AddressDAO.class);//地址
		BookDAO bookDAO=(BookDAO)MybatisUtil.getMapper(BookDAO.class);//图书
		HttpSession session = ServletActionContext.getRequest().getSession();
		User user=(User)session.getAttribute("login");
		Cart cart=(Cart)session.getAttribute("cart");
		Order order = new Order();
		Boolean flag;
		System.out.println("下单address:"+address);
		try {
			//插入地址
			if(address.getId()==null||address.getId().equals("")){
				address.setId(UUID.randomUUID().toString());
				address.setUser_id(user.getId());
				addressDAO.insertAddress(address);
			}else{
				Address ad=addressDAO.queryOne(address.getId());
				if(ad!=null&&!address.equals(ad)) {
					addressDAO.updateAddress(address);
				}
			}
			//插入订单
			order.setId(UUID.randomUUID().toString());//订单id
			order.setOrder_no(new Date().getTime()+"");//订单编号
			order.setTotal(cart.getTotalPrice());//订单总价
			order.setCreate_date(new Date());//下单时间
			order.setUser_id(user.getId());//用户Id
			order.setName(address.getName());//收件人
			order.setAddress(address.getLocal());//收货地址
			order.setStatus("未付款");
			orderDAO.insertOrder(order);//插入订单
			
			//批量插入订单项
			Map<String, OrderItem> map = cart.getMap();
			List<OrderItem> list = new ArrayList<OrderItem>();
			List<Book> books=new ArrayList<Book>();
			Set<String> set = map.keySet();
			for (String string : set) {
				OrderItem item = map.get(string);
				Book book=item.getBook();
				item.setId(UUID.randomUUID().toString());//订单项id
				item.setBook_id(book.getId());//图书id
				item.setCover(book.getCover());//图书封面
				item.setCreate_date(book.getCreate_date());//下单时间
				item.setDprice(book.getDprice());//当当价
				item.setName(book.getName());//书名
				item.setPrice(book.getPrice());//原价
				item.setOrder_id(order.getId());//订单id
				list.add(item);
				book.setSale(book.getSale()+item.getCount());
				book.setStock(book.getStock()-item.getCount());
				books.add(book);
			}	
			bookDAO.updateList(books);//批量修改图书
			orderItemDAO.insertOrderItems(list);//批量插入订单项
			MybatisUtil.commit();
			flag=true;
		} catch (Exception e1) {
			e1.printStackTrace();
			MybatisUtil.rollback();
			flag=false;
		}
		if(flag){
			session.setAttribute("order_no", order.getOrder_no());
			session.setAttribute("totalPrice", cart.getTotalPrice());
			session.removeAttribute("cart");
		}
	}

	@Override
	public Order quertOrderDetail(String id) {
		OrderDAO orderDAO = (OrderDAO)MybatisUtil.getMapper(OrderDAO.class);
		Order order = orderDAO.queryOrderDetail(id);
		return order;
	}
}