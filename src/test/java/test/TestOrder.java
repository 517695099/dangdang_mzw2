package test;

import java.util.List;

import mzw.dao.OrderDAO;
import mzw.entity.Order;
import mzw.entity.OrderItem;
import mzw.util.MybatisUtil;

import org.junit.Test;

public class TestOrder {
	@Test
	public void test1(){
		OrderDAO orderDAO = (OrderDAO)MybatisUtil.getMapper(OrderDAO.class);
		Order order = orderDAO.queryOrderDetail("a7fab990-8263-4fc2-bcd4-55a5b366547e");
		List<OrderItem> items = order.getItems();
		
			System.out.println("订单项个数为:"+items.size());
	
		MybatisUtil.closeSqlSession();
	}
}
