package com.dost12.phls.phlsbackend.dao;

import java.util.List;

import com.dost12.phls.phlsbackend.dto.HalalAnalysisReport;
import com.dost12.phls.phlsbackend.dto.HalalParameter;

public interface HalalParameterDAO {

	HalalParameter get(int id);
	List<HalalParameter> list();
	boolean add(HalalParameter halalAnalysisReport);
	boolean update(HalalParameter halalAnalysisReport);
	boolean delete(HalalParameter halalAnalysisReport);
	
}
