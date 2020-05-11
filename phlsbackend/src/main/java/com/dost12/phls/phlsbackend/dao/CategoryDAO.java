package com.dost12.phls.phlsbackend.dao;

import java.util.List;

import com.dost12.phls.phlsbackend.dto.Category;

public interface CategoryDAO {

	Category get(int id);
	List<Category> list();
	boolean add(Category category);
	boolean update(Category category);
	boolean delete(Category category);
	
	
}
