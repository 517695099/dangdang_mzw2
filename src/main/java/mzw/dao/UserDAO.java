package mzw.dao;

import java.util.List;

import mzw.entity.User;

import org.apache.ibatis.annotations.Param;

public interface UserDAO {
	/**
	 * @param email 用户登录方法及查询方法
	 * @return
	 */
	List<User> query(User user);
	/**
	 * @param user  根据用户id 修改用户状态
	 */
	void updateUser(User user);
	

	/**
	 * @param user   根据用户Id修改用户激活码
	 */
	void updateCode(User user);
	
	/**
	 * @param user  用户注册
	 */
	void register(User user);
}
