package mzw.dao;

import java.util.List;

import mzw.entity.Order;

import org.apache.ibatis.annotations.Param;

public interface OrderDAO {
	/**
	 * @param order 查询所有订单
	 * @return
	 */
	List<Order> queryAllOrder(Order order);
	/**
	 * @param order   插入订单
	 */
	void insertOrder(Order order);
	Order queryOrderDetail(@Param("id")String id);
}
