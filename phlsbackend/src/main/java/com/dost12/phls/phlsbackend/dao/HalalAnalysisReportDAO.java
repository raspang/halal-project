package com.dost12.phls.phlsbackend.dao;

import java.util.List;

import com.dost12.phls.phlsbackend.dto.HalalAnalysisReport;
import com.dost12.phls.phlsbackend.dto.Product;

public interface HalalAnalysisReportDAO {

	HalalAnalysisReport get(int id);
	List<HalalAnalysisReport> list();
	boolean add(HalalAnalysisReport halalAnalysisReport);
	boolean update(HalalAnalysisReport halalAnalysisReport);
	boolean delete(HalalAnalysisReport halalAnalysisReport);
	
	List<HalalAnalysisReport> listOfProduct(Product product);
}
