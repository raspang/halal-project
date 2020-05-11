package com.dost12.phls.phlsbackend.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.dost12.phls.phlsbackend.dao.HalalAnalysisReportDAO;
import com.dost12.phls.phlsbackend.dao.HalalParameterDAO;
import com.dost12.phls.phlsbackend.dao.NutritionFactsParameterDAO;
import com.dost12.phls.phlsbackend.dao.NutritionFactsResultDAO;
import com.dost12.phls.phlsbackend.dao.ProductDAO;
import com.dost12.phls.phlsbackend.dao.SupplierDAO;
import com.dost12.phls.phlsbackend.dto.HalalAnalysisReport;
import com.dost12.phls.phlsbackend.dto.HalalParameter;
import com.dost12.phls.phlsbackend.dto.NutritionFactsParameter;
import com.dost12.phls.phlsbackend.dto.NutritionFactsResult;
import com.dost12.phls.phlsbackend.dto.Product;
import com.dost12.phls.phlsbackend.dto.Supplier;

public class ParameterTestCase {

	private static AnnotationConfigApplicationContext context;
	
	private static NutritionFactsParameterDAO nutritionFactsParameterDAO;
	
	private NutritionFactsParameter nutritionFactsParameter;
	
	private static NutritionFactsResultDAO nutritionFactsResultDAO;
	
	private NutritionFactsResult nutritionFactsResult;
	
	private static HalalParameterDAO halalParameterDAO;
	
	private HalalParameter halalParameter;
	
	private static HalalAnalysisReportDAO halalAnalysisReportDAO;
	
	private HalalAnalysisReport halalAnalysisReport;
	
	private static ProductDAO productDAO;
	
	private Product product;
	
	@BeforeClass
	public static void init() {
		context = new AnnotationConfigApplicationContext();
		context.scan("com.dost12.phls.phlsbackend");
		context.refresh();
		nutritionFactsParameterDAO = (NutritionFactsParameterDAO)context.getBean("nutritionFactsParameterDAO");
		nutritionFactsResultDAO = (NutritionFactsResultDAO)context.getBean("nutritionFactsResultDAO");
		halalParameterDAO = (HalalParameterDAO)context.getBean("halalParameterDAO");
		halalAnalysisReportDAO = (HalalAnalysisReportDAO)context.getBean("halalAnalysisReportDAO");
		productDAO = (ProductDAO)context.getBean("productDAO");
	}
	
	@Test
	public void testGetCategory() {
		nutritionFactsParameter = nutritionFactsParameterDAO.get(1);
		
		assertEquals("Successfully fetched manufacture!",
				"my mai",nutritionFactsParameter.getName());
		
	}
	
	@Test
	public void testGetCategory1() {
		nutritionFactsResult = nutritionFactsResultDAO.get(1);
		
		assertEquals("Successfully fetched manufacture!",
				"my mai","");
		
	}
	
	@Test
	public void testGetCategory2() {
		halalParameter = halalParameterDAO.get(1);
		
		assertEquals("Successfully fetched manufacture!",
				"my mai",halalParameter.getName());
		
	}

	@Test
	public void testGetCategory3() {
		halalAnalysisReport = halalAnalysisReportDAO.get(1);
		
		assertEquals("Successfully fetched manufacture!",
				"my mai",halalAnalysisReport.getHalalParameter().getName());
		
	}
	
	@Test
	public void testGetProductListHalalAnalysis() {
		product = productDAO.get(40);
		assertEquals("Successfully fetched manufacture!",
				"my mai",halalAnalysisReportDAO.listOfProduct(product));
		
	}
}
