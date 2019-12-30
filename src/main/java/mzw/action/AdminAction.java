package mzw.action;

import java.awt.image.BufferedImage;
import java.io.OutputStream;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpSession;

import mzw.entity.Admin;
import mzw.service.AdminService;
import mzw.service.impl.AdminServiceImpl;
import mzw.util.SecurityCode;
import mzw.util.SecurityImage;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

public class AdminAction extends ActionSupport {
	private Admin admin;
	private String message;
	private String scode;
	public String login(){
		AdminService as = new AdminServiceImpl();
		HttpSession session = ServletActionContext.getRequest().getSession();
		String code = (String)session.getAttribute("code");	
			try {
				as.login(admin);
				if(code.equals(scode)){	
					return "loginSuccess";
				}else{
					message = "验证码错误";
					return "loginError";
				}
			} catch (Exception e) {
				message = e.getMessage();
				return "loginError";
			}
	}
	//安全退出
	public String exit(){
		HttpSession session = ServletActionContext.getRequest().getSession();
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
	
	public Admin getAdmin() {
		return admin;
	}
	public void setAdmin(Admin admin) {
		this.admin = admin;
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
}
