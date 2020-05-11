package com.dost12.phls.phlsbackend.dao;

import java.util.List;

import com.dost12.phls.phlsbackend.dto.Category;
import com.dost12.phls.phlsbackend.dto.Shipment;

public interface LocationDAO {
	Shipment get(int id);
	List<Shipment> list();
	boolean add(Shipment location);
	boolean update(Shipment location);
	boolean delete(Shipment location);	
}
