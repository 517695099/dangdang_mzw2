package mzw.service;

import mzw.entity.Book;

public interface CartService {
	void addCart(Book book);
	void removeCartItem(String id);
	void change1(Integer changeCount,String id);

}
