package mzw.service.impl;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import mzw.entity.Book;
import mzw.entity.Cart;
import mzw.entity.OrderItem;
import mzw.service.CartService;

public class CartServiceImpl implements CartService {

	@Override
	public void addCart(Book book) {//添加购物车
		HttpSession session = ServletActionContext.getRequest().getSession();
		Cart cart= (Cart)session.getAttribute("cart");
		if(cart==null) cart = new Cart();
		Map<String,OrderItem> map = cart.getMap();
		if(map==null) map=new HashMap<String,OrderItem>();
		if(map.containsKey(book.getId())){
			OrderItem ci = map.get(book.getId());
			cart.addCart(ci);
		}else{
			OrderItem ci2=new OrderItem();
			ci2.setBook(book);
			ci2.setCount(1);
			cart.addCart(ci2);
		}
		cart.setMap(map);
		session.setAttribute("cart", cart);
	}

	@Override
	public void removeCartItem(String id) {//删除商品项
		HttpSession session = ServletActionContext.getRequest().getSession();
		Cart cart=(Cart) session.getAttribute("cart");
		Map<String,OrderItem> map=cart.getMap();
		map.remove(id);
		if(map.size()==0) session.removeAttribute("cart");
	}

	@Override
	public void change1(Integer changeCount,String id) {//变更
		HttpSession session = ServletActionContext.getRequest().getSession();
		Cart cart=(Cart) session.getAttribute("cart");
		Map<String,OrderItem> map=cart.getMap();
		OrderItem orderItem = map.get(id);
		Integer stock=orderItem.getBook().getStock();
		if(changeCount>stock) throw new RuntimeException("库存不足!");
		if(changeCount<=0)throw new RuntimeException("购买数量不得小于0!");
		orderItem.setCount(changeCount);
		cart.setMap(map);
		session.setAttribute("cart", cart);
	}
}
