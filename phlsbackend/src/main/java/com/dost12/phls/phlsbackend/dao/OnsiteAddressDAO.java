package com.dost12.phls.phlsbackend.dao;

import java.util.List;

import com.dost12.phls.phlsbackend.dto.OnsiteAddress;
import com.dost12.phls.phlsbackend.dto.Supplier;

public interface OnsiteAddressDAO {

	OnsiteAddress get(int id);
	List<OnsiteAddress> list();
	boolean add(OnsiteAddress onsiteAddress);
	boolean update(OnsiteAddress onsiteAddress);
	boolean delete(OnsiteAddress onsiteAddress);
	
	List<OnsiteAddress> list(int id);
	
}
