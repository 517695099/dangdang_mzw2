package mzw.service;

import java.util.List;

import mzw.entity.Address;
import mzw.entity.Order;

public interface OrderService {
	/**
	 * @param order 查询所有订单
	 * @return
	 */
	List<Order> queryAllOrder(Order order);
	/**
	 * @param address   下单
	 */
	void insertOrderAndOrderItemAndAddress(Address address );
	
	/**
	 * @param id        根据订单id查询订单详情
	 * @return
	 */
	Order quertOrderDetail(String id);
}
