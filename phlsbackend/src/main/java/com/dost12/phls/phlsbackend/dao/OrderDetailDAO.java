package com.dost12.phls.phlsbackend.dao;

import java.util.List;

import com.dost12.phls.phlsbackend.dto.OrderDetail;
import com.dost12.phls.phlsbackend.dto.User;

public interface OrderDetailDAO {

	OrderDetail get(int id);
	List<OrderDetail> list();
	boolean add(OrderDetail orderDetail);
	boolean update(OrderDetail orderDetail);
	boolean delete(OrderDetail orderDetail);
	
	List<OrderDetail> list(User user);
	
	
}
