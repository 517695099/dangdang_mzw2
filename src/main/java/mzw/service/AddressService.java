package mzw.service;

import java.util.List;

import mzw.entity.Address;

public interface AddressService {
	
	/**
	 * @return   根据用户Id查询旧地址
	 */
	List<Address> queryAllAddressByUserId();
	Address queryOneAddressById(String id);
}
