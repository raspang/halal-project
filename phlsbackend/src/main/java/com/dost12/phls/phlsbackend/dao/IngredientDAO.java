package com.dost12.phls.phlsbackend.dao;

import java.util.List;

import com.dost12.phls.phlsbackend.dto.Category;
import com.dost12.phls.phlsbackend.dto.Ingredient;

public interface IngredientDAO {

	Ingredient get(int id);
	List<Ingredient> list();
	boolean add(Ingredient category);
	boolean update(Ingredient category);
	boolean delete(Ingredient category);
	
	
}
