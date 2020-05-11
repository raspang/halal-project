package com.dost12.phls.phlsbackend.dao;

import java.util.List;

import com.dost12.phls.phlsbackend.dto.Address;
import com.dost12.phls.phlsbackend.dto.Cart;
import com.dost12.phls.phlsbackend.dto.User;
import com.dost12.phls.phlsbackend.dto.Userlab;

public interface UserlabDAO {

	// user related operation
	Userlab getByEmail(String email);
	Userlab get(int id);

	boolean add(Userlab user);
	boolean update(Userlab user);
	
	// adding and updating a new address
	Address getAddress(int addressId);
	boolean addAddress(Address address);
	boolean updateAddress(Address address);
	Address getBillingAddress(int userId);
	List<Address> listShippingAddresses(int userId);
	

	
}
