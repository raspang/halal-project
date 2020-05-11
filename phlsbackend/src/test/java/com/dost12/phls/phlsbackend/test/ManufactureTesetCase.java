package com.dost12.phls.phlsbackend.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.dost12.phls.phlsbackend.dao.SupplierDAO;
import com.dost12.phls.phlsbackend.dto.Supplier;

public class ManufactureTesetCase {

	private static AnnotationConfigApplicationContext context;
	
	private static SupplierDAO supplierDAO;
	
	private Supplier manufacture;
	
	@BeforeClass
	public static void init() {
		context = new AnnotationConfigApplicationContext();
		context.scan("com.dost12.phls.phlsbackend");
		context.refresh();
		supplierDAO = (SupplierDAO)context.getBean("supplierDAO");
	}
	
	@Test
	public void testGetCategory() {
		
		manufacture = supplierDAO.get(15);
		
		
		assertEquals("Successfully fetched manufacture!","honey",manufacture.getNameOfEstablishment());
		
		
	}
	
}
