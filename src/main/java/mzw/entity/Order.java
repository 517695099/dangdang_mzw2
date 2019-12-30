package mzw.entity;

import java.util.Date;
import java.util.List;
/*id                   varchar2(36)                    not null,//订单id
order_no             varchar2(40),//订单编号
total                number(10,2),//总价
create_date          date,//创建时间
user_id              varchar2(36),//用户Id
address              varchar2(100),//收货地址
name                 varchar2(100),  //收件人
status               varchar2(20),*///订单状态

public class Order {
	private String id;
	private String order_no;
	private Double total;
	private Date create_date;
	private String user_id;//外键列对应属性
	private String address;
	private String name;
	private String status;
	private List<OrderItem> items;
	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Order(String id, String order_no, Double total, Date create_date,
			String user_id, String address, String name, String status,
			List<OrderItem> items) {
		super();
		this.id = id;
		this.order_no = order_no;
		this.total = total;
		this.create_date = create_date;
		this.user_id = user_id;
		this.address = address;
		this.name = name;
		this.status = status;
		this.items = items;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getOrder_no() {
		return order_no;
	}
	public void setOrder_no(String order_no) {
		this.order_no = order_no;
	}
	public Double getTotal() {
		return total;
	}
	public void setTotal(Double total) {
		this.total = total;
	}
	public Date getCreate_date() {
		return create_date;
	}
	public void setCreate_date(Date create_date) {
		this.create_date = create_date;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public List<OrderItem> getItems() {
		return items;
	}
	public void setItems(List<OrderItem> items) {
		this.items = items;
	}
	@Override
	public String toString() {
		return "Order [id=" + id + ", order_no=" + order_no + ", total="
				+ total + ", create_date=" + create_date + ", user_id="
				+ user_id + ", address=" + address + ", name=" + name
				+ ", status=" + status + ", items=" + items + "]";
	}
	
}
