package mzw.service.impl;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import mzw.dao.AdminDAO;
import mzw.entity.Admin;
import mzw.service.AdminService;
import mzw.util.MybatisUtil;

public class AdminServiceImpl implements AdminService {

	@Override
	public void login(Admin admin) {
		AdminDAO adminDAO=(AdminDAO)MybatisUtil.getMapper(AdminDAO.class);
		Admin a = adminDAO.login(admin.getUsername());
		if(a==null)throw new RuntimeException("用户名错误或该用户还不是管理员");
		if(!admin.getPassword().equals(a.getPassword()))throw new RuntimeException("密码错误");
		HttpSession session = ServletActionContext.getRequest().getSession();
		session.setAttribute("admin", a);
		MybatisUtil.closeSqlSession();
	}

}
