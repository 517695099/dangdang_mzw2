package mzw.entity;

import java.util.Date;
import java.util.List;

/*id                   varchar2(36)                    not null,
book_id              varchar2(36),
order_id             varchar2(36),
count                number(10),
create_date          date,
name                 varchar2(100),
price                number(10,2),
dprice               number(10,2),
cover                varchar2(600),*/
public class OrderItem {
	private String id;//订单编号
	private String book_id;//图书id
	private String order_id;//订单id
	private Integer count;//购买数量
	private Date create_date;//订单创建时间
	private String name;//图书名
	private Double price;//原价
	private Double dprice;//当当价
	private String cover;//图书封面
	private Double subTotal;
	private Double save;
	private Order order;
	private Book book;
	public OrderItem() {
		super();
		// TODO Auto-generated constructor stub
	}
	public OrderItem(String id, String book_id, String order_id, Integer count,
			Date create_date, String name, Double price, Double dprice,
			String cover, Double subTotal, Double save, Order order, Book book) {
		super();
		this.id = id;
		this.book_id = book_id;
		this.order_id = order_id;
		this.count = count;
		this.create_date = create_date;
		this.name = name;
		this.price = price;
		this.dprice = dprice;
		this.cover = cover;
		this.subTotal = subTotal;
		this.save = save;
		this.order = order;
		this.book = book;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getBook_id() {
		return book_id;
	}
	public void setBook_id(String book_id) {
		this.book_id = book_id;
	}
	public String getOrder_id() {
		return order_id;
	}
	public void setOrder_id(String order_id) {
		this.order_id = order_id;
	}
	public Integer getCount() {
		return count;
	}
	public void setCount(Integer count) {
		this.count = count;
	}
	public Date getCreate_date() {
		return create_date;
	}
	public void setCreate_date(Date create_date) {
		this.create_date = create_date;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public Double getDprice() {
		return dprice;
	}
	public void setDprice(Double dprice) {
		this.dprice = dprice;
	}
	public String getCover() {
		return cover;
	}
	public void setCover(String cover) {
		this.cover = cover;
	}
	public Double getSubTotal() {
		return count*book.getDprice();
	}
	public void setSubTotal(Double subTotal) {
		this.subTotal = subTotal;
	}
	public Double getSave() {
		return count*(book.getPrice()-book.getDprice());
	}
	public void setSave(Double save) {
		this.save = save;
	}
	public Order getOrder() {
		return order;
	}
	public void setOrder(Order order) {
		this.order = order;
	}
	public Book getBook() {
		return book;
	}
	public void setBook(Book book) {
		this.book = book;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((book == null) ? 0 : book.hashCode());
		result = prime * result + ((book_id == null) ? 0 : book_id.hashCode());
		result = prime * result + ((count == null) ? 0 : count.hashCode());
		result = prime * result + ((cover == null) ? 0 : cover.hashCode());
		result = prime * result
				+ ((create_date == null) ? 0 : create_date.hashCode());
		result = prime * result + ((dprice == null) ? 0 : dprice.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((order == null) ? 0 : order.hashCode());
		result = prime * result
				+ ((order_id == null) ? 0 : order_id.hashCode());
		result = prime * result + ((price == null) ? 0 : price.hashCode());
		result = prime * result + ((save == null) ? 0 : save.hashCode());
		result = prime * result
				+ ((subTotal == null) ? 0 : subTotal.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OrderItem other = (OrderItem) obj;
		if (book == null) {
			if (other.book != null)
				return false;
		} else if (!book.equals(other.book))
			return false;
		if (book_id == null) {
			if (other.book_id != null)
				return false;
		} else if (!book_id.equals(other.book_id))
			return false;
		if (count == null) {
			if (other.count != null)
				return false;
		} else if (!count.equals(other.count))
			return false;
		if (cover == null) {
			if (other.cover != null)
				return false;
		} else if (!cover.equals(other.cover))
			return false;
		if (create_date == null) {
			if (other.create_date != null)
				return false;
		} else if (!create_date.equals(other.create_date))
			return false;
		if (dprice == null) {
			if (other.dprice != null)
				return false;
		} else if (!dprice.equals(other.dprice))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (order == null) {
			if (other.order != null)
				return false;
		} else if (!order.equals(other.order))
			return false;
		if (order_id == null) {
			if (other.order_id != null)
				return false;
		} else if (!order_id.equals(other.order_id))
			return false;
		if (price == null) {
			if (other.price != null)
				return false;
		} else if (!price.equals(other.price))
			return false;
		if (save == null) {
			if (other.save != null)
				return false;
		} else if (!save.equals(other.save))
			return false;
		if (subTotal == null) {
			if (other.subTotal != null)
				return false;
		} else if (!subTotal.equals(other.subTotal))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "OrderItem [id=" + id + ", book_id=" + book_id + ", order_id="
				+ order_id + ", count=" + count + ", create_date="
				+ create_date + ", name=" + name + ", price=" + price
				+ ", dprice=" + dprice + ", cover=" + cover + ", subTotal="
				+ subTotal + ", save=" + save + ", order=" + order + ", book="
				+ book + "]";
	}
	
}
