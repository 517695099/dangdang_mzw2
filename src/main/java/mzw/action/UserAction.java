package mzw.action;

import java.awt.image.BufferedImage;
import java.io.OutputStream;
import java.util.List;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpSession;

import mzw.entity.Cart;
import mzw.entity.User;
import mzw.service.CartService;
import mzw.service.UserService;
import mzw.service.impl.CartServiceImpl;
import mzw.service.impl.UserServiceImpl;
import mzw.util.MD5Utils;
import mzw.util.SecurityCode;
import mzw.util.SecurityImage;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

public class UserAction extends ActionSupport {
	private List<User> list;
	private User user;
	private String message;
	private String scode;
	private String num;
	//展示所有用户信息
	public String queryAll(){
		UserService us = new UserServiceImpl();
		list = us.query(user);
		return "queryAllSuccess";
	}
	//修改用户状态
	public String updateStatus(){
		UserService us = new UserServiceImpl();
		us.updateUser(user);
		return "updateStatusSuccess";
	}
	//用户登录方法
	public String login(){	
		UserService us = new UserServiceImpl();
		try {
			us.queryUserByEmail(user,scode);
		} catch (Exception e) {
			message = e.getMessage();
			return "loginError";
		}
		return "loginSuccess";
	}
	//登出
	public String exit(){
			HttpSession session = ServletActionContext.getRequest().getSession();
			session.removeAttribute("cart");
			session.invalidate();
			return "exitSuccess";
	}
//获取验证码
	public String getCode(){
		String code = SecurityCode.getSecurityCode();
		HttpSession session = ServletActionContext.getRequest().getSession();
		session.setAttribute("code", code);
		BufferedImage image = SecurityImage.createImage(code);
		OutputStream os = null;
		try {
			os = ServletActionContext.getResponse().getOutputStream();
			ImageIO.write(image, "png", os);
		} catch (Exception e) {
			
		}
		return null;
	}
	//修改用户激活码
	public String updateCode(){
		UserService us = new UserServiceImpl();
		us.updateCode(scode);
		return "updateCodeSuccess";
	}
	//注册
	public String register(){
		UserService us = new UserServiceImpl();	
			try {	
				us.register(user,scode);
			} catch (Exception e) {
				message=e.getMessage();
				return "registerError";
			}	             
		return "registerSuccess";
	}
	//发送激活码
	public String sendEmail(){
		num=MD5Utils.getNum(); 
		return "sendEmailSuccess";
	}
	public List<User> getList() {
		return list;
	}
	public void setList(List<User> list) {
		this.list = list;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getScode() {
		return scode;
	}
	public void setScode(String scode) {
		this.scode = scode;
	}
	public String getNum() {
		return num;
	}
	public void setNum(String num) {
		this.num = num;
	}
	
}
