package mzw.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import mzw.entity.User;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;

public class UserLoginInterceptor implements Interceptor {

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void init() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String intercept(ActionInvocation ai) throws Exception {
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		User queryUser = (User) session.getAttribute("login");
		if(queryUser!=null){
			if(queryUser.getCode()==null||"".equals(queryUser.getCode())){
				
				return "active";
			}
			ai.invoke();
		}else{
			return "login";
		}
		return null;
	}
}
