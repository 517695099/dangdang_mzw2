package mzw.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpSession;

import mzw.dao.UserDAO;
import mzw.entity.User;
import mzw.service.UserService;
import mzw.util.MD5Utils;
import mzw.util.MybatisUtil;

import org.apache.struts2.ServletActionContext;

public class UserServiceImpl implements UserService {

	@Override
	public List<User> query(User user) {//查询所有用户
		UserDAO userDAO = (UserDAO)MybatisUtil.getMapper(UserDAO.class);
		List<User> list = userDAO.query(user);
		MybatisUtil.closeSqlSession();
		return list;
	}

	@Override
	public void updateUser(User user) {//修改用户状态
		UserDAO userDAO = (UserDAO)MybatisUtil.getMapper(UserDAO.class);
		if(user.getStatus().equals("冻结")){
			 user.setStatus("激活");
		}else{
			user.setStatus("冻结");
		}
		userDAO.updateUser(user);
		try {
			MybatisUtil.commit();
		} catch (Exception e) {
			MybatisUtil.rollback();
		}
	}

	@Override
	public void queryUserByEmail(User user,String scode) {//登陆相关验证
		HttpSession session = ServletActionContext.getRequest().getSession();
		UserDAO userDAO = (UserDAO)MybatisUtil.getMapper(UserDAO.class);
		User us = new User();
		us.setEmail(user.getEmail());
		List<User> query = userDAO.query(us);
		if(query==null||query.size()==0)throw new RuntimeException("邮箱输入错误");
		String salt=query.get(0).getSalt();
		String password=MD5Utils.getPassword(user.getPassword()+salt);
		if(!password.equals(query.get(0).getPassword())) throw new RuntimeException("密码错误");
		if((query.get(0).getStatus()).equals("冻结"))throw new RuntimeException("该用户已冻结");
		session.setAttribute("login", query.get(0));
		MybatisUtil.closeSqlSession();
	}

	@Override
	public void updateCode(String code) {//注册成功后进行邮箱验证
		System.out.println("进入修改激活码");
		UserDAO userDAO = (UserDAO)MybatisUtil.getMapper(UserDAO.class);
		HttpSession session = ServletActionContext.getRequest().getSession();
		User user =(User)session.getAttribute("register");
		if(user==null){
			user=(User)session.getAttribute("login");
		}
		System.out.println("注册过的用户"+user);
		List<User> list = new ArrayList<User>();
		System.out.println("tryCatch之前");
		try {
			user.setCode(code);
			userDAO.updateCode(user);
			User u = new User();
			u.setId(user.getId());
			System.out.println("查询前夕");
			list = userDAO.query(u);
			System.out.println("list:"+list);
			MybatisUtil.commit();
			if(list!=null){
				session.removeAttribute("login");
				session.setAttribute("login", list.get(0));	
			}
		} catch (Exception e) {
			MybatisUtil.rollback();
		}
	}

	@Override
	public void register(User user,String scode) {//用户注册及相关验证
		System.out.println("进入注册service");
		UserDAO userDAO = (UserDAO)MybatisUtil.getMapper(UserDAO.class);
		HttpSession session = ServletActionContext.getRequest().getSession();
		String code=(String)session.getAttribute("code");
		System.out.println("scode:"+scode);
		System.out.println("code"+code);
		if(!scode.equals(code))throw new RuntimeException("验证码输入错误!");
		User u = new User();
		u.setEmail(user.getEmail());
		List<User> query = userDAO.query(u);
		if(query!=null&&query.size()!=0) throw new RuntimeException("此邮箱已注册!");
		System.out.println("注册前夕");
		try {
			user.setId(UUID.randomUUID().toString());
			user.setCreate_date(new Date());
			user.setSalt(MD5Utils.getSalt());
			String password = MD5Utils.getPassword(user.getPassword()+user.getSalt());
			user.setPassword(password);
			user.setStatus("正常");
			userDAO.register(user);
			MybatisUtil.commit();
			session.setAttribute("register", user);
			User us =(User)session.getAttribute("register");
			System.out.println("注册后:"+us);
			System.out.println("注册成功");
		} catch (Exception e) {
			MybatisUtil.rollback();
		}	
	}	
}
