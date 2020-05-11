package com.dost12.phls.phlsbackend.dao;

import java.util.List;

import com.dost12.phls.phlsbackend.dto.NutritionFactsResult;
import com.dost12.phls.phlsbackend.dto.Product;

public interface NutritionFactsResultDAO {
	NutritionFactsResult get(int id);
	List<NutritionFactsResult> list();
	boolean add(NutritionFactsResult nutiritionFactsResult);
	boolean update(NutritionFactsResult nutiritionFactsResult);
	boolean delete(NutritionFactsResult nutiritionFactsResult);	
	
	List<NutritionFactsResult> listOfProduct(Product product);
}
