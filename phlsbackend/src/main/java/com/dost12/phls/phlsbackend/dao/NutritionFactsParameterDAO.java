package com.dost12.phls.phlsbackend.dao;

import java.util.List;

import com.dost12.phls.phlsbackend.dto.HalalAnalysisReport;
import com.dost12.phls.phlsbackend.dto.HalalParameter;
import com.dost12.phls.phlsbackend.dto.NutritionFactsParameter;

public interface NutritionFactsParameterDAO {

	NutritionFactsParameter get(int id);
	List<NutritionFactsParameter> list();
	//boolean add(NutritionFactsParameter nutritionFactsParameter);
	boolean update(NutritionFactsParameter nutritionFactsParameter);
	boolean delete(NutritionFactsParameter nutritionFactsParameter);
	 Integer add(NutritionFactsParameter nutritionFactsParameter);
}
