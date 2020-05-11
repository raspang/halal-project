
package com.dost12.phls.phlsbackend.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.dost12.phls.phlsbackend.dao.OnsiteAddressDAO;
import com.dost12.phls.phlsbackend.dao.OnsiteAssessmentDAO;
import com.dost12.phls.phlsbackend.dao.SupplierDAO;
import com.dost12.phls.phlsbackend.dto.OnsiteAddress;
import com.dost12.phls.phlsbackend.dto.OnsiteAssessment;
import com.dost12.phls.phlsbackend.dto.Supplier;

public class OnsiteAssessmentTestCase {

	private static AnnotationConfigApplicationContext context;
	
	private static OnsiteAssessmentDAO onsiteAssessmentDAO;
	
	private OnsiteAssessment onsiteAssessment;
	
	private static OnsiteAddressDAO onsiteAddressDAO;
	
	private OnsiteAddress onsiteAddress;
	
	@BeforeClass
	public static void init() {
		context = new AnnotationConfigApplicationContext();
		context.scan("com.dost12.phls.phlsbackend");
		context.refresh();
		onsiteAssessmentDAO = (OnsiteAssessmentDAO)context.getBean("onsiteAssessmentDAO");
		onsiteAddressDAO = (OnsiteAddressDAO)context.getBean("onsiteAddressDAO");
	}
	
	@Test
	public void testGetCategory() {
		
		onsiteAssessment = onsiteAssessmentDAO.get(1);
		
		
		assertEquals("Successfully fetched manufacture!","my honey",onsiteAssessment.getSupplier().getNameOfEstablishment());
		
		
	}
	
	@Test
	public void testGetCategory2() {
	
		onsiteAddress = onsiteAddressDAO.get(1);
		
		assertEquals("Successfully fetched manufacture!","XX", onsiteAddress.getId() );
		
		
	}
	
	
}
