package mzw.action;

import java.util.List;

import mzw.entity.Order;
import mzw.service.OrderService;
import mzw.service.impl.OrderServiceImpl;

import com.opensymphony.xwork2.ActionSupport;

public class OrderAction extends ActionSupport {
	private List<Order> list;
	private Order order;
	//查询所有订单
	public String queryAllOrder(){
		OrderService os = new OrderServiceImpl();
		list = os.queryAllOrder(order);
		return "queryAllOrderSuccess";	
	}
	//查询订单详情
	public String queryOrderDetail(){
		OrderService os = new OrderServiceImpl();
		order=os.quertOrderDetail(order.getId());
		return "queryOrderDetailSuccess";
	}
	public List<Order> getList() {
		return list;
	}
	public void setList(List<Order> list) {
		this.list = list;
	}
	public Order getOrder() {
		return order;
	}
	public void setOrder(Order order) {
		this.order = order;
	}

}
