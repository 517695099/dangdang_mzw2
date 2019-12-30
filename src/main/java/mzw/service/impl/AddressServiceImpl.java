package mzw.service.impl;

import java.util.List;

import javax.servlet.http.HttpSession;

import mzw.dao.AddressDAO;
import mzw.entity.Address;
import mzw.entity.User;
import mzw.service.AddressService;
import mzw.util.MybatisUtil;

import org.apache.struts2.ServletActionContext;

public class AddressServiceImpl implements AddressService {

	@Override
	public List<Address> queryAllAddressByUserId() {
		HttpSession session = ServletActionContext.getRequest().getSession();
		AddressDAO addressDAO=(AddressDAO)MybatisUtil.getMapper(AddressDAO.class);
		User user=(User)session.getAttribute("login");
	    List<Address> list = addressDAO.selectAllAddresses(user.getId());
	    System.out.println("AddressService中:"+list);
	    MybatisUtil.closeSqlSession();
		return list;
	}

	@Override
	public Address queryOneAddressById(String id) {
		AddressDAO addressDAO=(AddressDAO)MybatisUtil.getMapper(AddressDAO.class);
		Address address = addressDAO.queryOne(id);
		return address;
	}

}
