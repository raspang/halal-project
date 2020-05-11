package com.dost12.phls.phlsbackend.dao;

import java.util.List;

import com.dost12.phls.phlsbackend.dto.IngredientDetail;
import com.dost12.phls.phlsbackend.dto.Product;

public interface IngredientDetailDAO {
	IngredientDetail get(int id);
	List<IngredientDetail> list();
	List<IngredientDetail> getList(Product product);
	Integer add(IngredientDetail ingredientDetail);
	boolean update(IngredientDetail ingredientDetail);
	boolean delete(IngredientDetail ingredientDetail);

}
