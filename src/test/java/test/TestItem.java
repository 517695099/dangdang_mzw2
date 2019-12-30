package test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import mzw.dao.OrderItemDAO;
import mzw.entity.OrderItem;
import mzw.util.MybatisUtil;

import org.junit.Test;

public class TestItem {
	@Test
	public void test1(){
		//(id,book_id,order_id,count,create_date,name,price,dprice,cover)
		OrderItemDAO orderItemDAO=(OrderItemDAO)MybatisUtil.getMapper(OrderItemDAO.class);
		List<OrderItem> list = new ArrayList<OrderItem>();
		OrderItem o1=new OrderItem();
		o1.setId("1");
		o1.setBook_id("1");
		o1.setCount(2);
		o1.setCover("1.png");
		o1.setOrder_id("d74e4bb4-5af4-4526-8dfc-400da8dc39ba");
		o1.setCreate_date(new Date());
		o1.setPrice(20.0);
		o1.setDprice(19.0);
		o1.setName("碍事法师");
		
		OrderItem o2=new OrderItem();
		o2.setId("2");
		o2.setBook_id("4");
		o2.setCount(3);
		o2.setCover("2.png");
		o2.setOrder_id("d74e4bb4-5af4-4526-8dfc-400da8dc39ba");
		o2.setCreate_date(new Date());
		o2.setPrice(30.0);
		o2.setDprice(29.0);
		o2.setName("碍事法师2");
		list.add(o1);
		list.add(o2);
		Integer a = orderItemDAO.insertOrderItems(list);
		MybatisUtil.commit();
		System.out.println(a);
	}
}
