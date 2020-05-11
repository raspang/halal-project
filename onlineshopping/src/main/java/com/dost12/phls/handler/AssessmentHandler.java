package com.dost12.phls.handler;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;

import com.dost12.phls.model.AssessmentModel;
import com.dost12.phls.model.CheckoutModel;
import com.dost12.phls.phlsbackend.dao.CertificateDAO;
import com.dost12.phls.phlsbackend.dao.OnsiteAssessmentDAO;
import com.dost12.phls.phlsbackend.dao.SupplierDAO;
import com.dost12.phls.phlsbackend.dao.UserDAO;
import com.dost12.phls.phlsbackend.dto.Address;

public class AssessmentHandler {

	
	@Autowired
	private SupplierDAO supplierDAO;
	
	@Autowired
	private CertificateDAO certificateDAO;
	
	@Autowired
	private UserDAO userDAO;
	
	@Autowired
	private Address addressDAO;
	
	@Autowired
	private OnsiteAssessmentDAO onsiteAssessmentDAO;
	
	@Autowired
	private HttpSession session;
	
	public AssessmentModel init() throws Exception {
		
		return null;
		
	}
	

	
}
