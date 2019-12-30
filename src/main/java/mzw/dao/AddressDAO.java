package mzw.dao;

import java.util.List;

import mzw.entity.Address;

import org.apache.ibatis.annotations.Param;

public interface AddressDAO {
	/**
	 * @param id
	 * @return
	 */
	List<Address> selectAllAddresses(@Param("user_id")String user_id);
	/**
	 * @param address  插入地址
	 */
	void insertAddress(Address address);
	/**
	 * @param address   修改地址
	 */
	void updateAddress(Address address);
	
	Address queryOne(@Param("id")String id);
}
