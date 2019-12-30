package mzw.dao;

import java.util.List;

import mzw.entity.OrderItem;

import org.apache.ibatis.annotations.Param;

public interface OrderItemDAO {
	/** 
	 * @param list
	 * @return     批量插入订单项
	 */
	Integer insertOrderItems(List<OrderItem> list);
}
