package com.dost12.phls.phlsbackend.dao;

import java.util.List;

import com.dost12.phls.phlsbackend.dto.Supplier;

public interface SupplierDAO {
	Supplier get(int id);
	List<Supplier> list();
	List<Supplier> list(String email);
	Integer add(Supplier manufacture);
	boolean update(Supplier manufacture);
	boolean delete(Supplier manufacture);
	public Supplier getByEmail(String email);
	public Supplier getByEmailEnable(String email);
}
