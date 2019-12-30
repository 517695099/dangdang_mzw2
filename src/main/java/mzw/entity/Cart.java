package mzw.entity;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Cart {
	//Map集合 用图书的id作为Map的key(键),购物项作为Map的value(值)
	private Map<String,OrderItem> map = new HashMap<String,OrderItem>();
	//总计
	private Double totalPrice=0d;
	//总节省
	private Double  totalSave=0d;
	public Cart() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Cart(Map<String, OrderItem> map, Double totalPrice, Double totalSave) {
		super();
		this.map = map;
		this.totalPrice = totalPrice;
		this.totalSave = totalSave;
	}
	public void addCart(OrderItem orderItem){
		String bid = orderItem.getBook().getId();
		//如果该商品已存在
		if(map.containsKey(bid)){
			orderItem.setCount(orderItem.getCount()+1);
			map.put(bid, orderItem);
		}else{
			map.put(bid, orderItem);
		}
	}
	public Map<String, OrderItem> getMap() {
		return map;
	}
	public void setMap(Map<String, OrderItem> map) {
		this.map = map;
	}
	public void setTotalPrice(Double totalPrice) {
		this.totalPrice = totalPrice;
	}
	public void setTotalSave(Double totalSave) {
		this.totalSave = totalSave;
	}
	//获取总价
	public Double getTotalPrice(){
		Double d=0d;
		if(map!=null){
			Collection<OrderItem> values = map.values();
			for (OrderItem orderItem : values) {
				d+=orderItem.getSubTotal();
			}	
		}	
		return d;			
	}
	//获取总节省
	public Double getTotalSave(){
		Double ds = 0d;
		if(map!=null){
			Collection<OrderItem> values = map.values();
			for (OrderItem orderItem : values) {
				ds+=orderItem.getSave();
			}	
		}
		return ds;			
	}
	public void clearCart(){
		//清空map(清空购物车)
		map.clear();
	}
}