package mzw.service;

import java.util.List;

import mzw.entity.User;


public interface UserService {

	/**
	 * @param user  所有查询方法
	 * @return
	 */
	List<User> query(User user);
	/**
	 * @param user  根据用户id修改用户状态
	 */
	void updateUser(User user);
	/**
	 * @param user  用户登录方法
	 */
	void queryUserByEmail(User user,String scode);
	
	/**
	 * @param id    根据用户Id修改用户激活码
	 * @param code
	 */
	void updateCode(String code);
	
	/**
	 * @param user  用户注册
	 */
	void register(User user,String scode);
}
