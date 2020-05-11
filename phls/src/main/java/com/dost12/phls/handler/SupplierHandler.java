package com.dost12.phls.handler;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.binding.message.MessageBuilder;
import org.springframework.binding.message.MessageContext;
import org.springframework.stereotype.Component;
import com.dost12.phls.model.SupplierModel;
import com.dost12.phls.model.UserModel;
import com.dost12.phls.phlsbackend.dao.OnsiteAddressDAO;
import com.dost12.phls.phlsbackend.dao.SupplierDAO;
import com.dost12.phls.phlsbackend.dao.UserDAO;
import com.dost12.phls.phlsbackend.dao.UserlabDAO;
import com.dost12.phls.phlsbackend.dto.OnsiteAddress;
import com.dost12.phls.phlsbackend.dto.Supplier;
import com.dost12.phls.phlsbackend.dto.User;

@Component
public class SupplierHandler {

	private static final Logger logger = LoggerFactory.getLogger(SupplierHandler.class);

	@Autowired
	private HttpSession session;

	@Autowired
	private SupplierDAO supplierDAO;

	@Autowired
	private OnsiteAddressDAO onsiteAddressDAO;
	
	@Autowired
	private UserlabDAO userlabDAO;
	
	@Autowired
	private UserDAO userDAO;	

	public SupplierModel init() {
		return new SupplierModel();
	}

	public void addSupplier(SupplierModel supplierModel, Supplier supplier) {
		supplierModel.setSupplier(supplier);
	}

	public void addAddress(SupplierModel supplierModel, OnsiteAddress onsite) {
		supplierModel.setAddress(onsite);
	}

	 public String validateSupplier(Supplier supplier, MessageContext error) {
		  String transitionValue = "success";

		   if(supplierDAO.list(supplier.getEmail()).size() > 0) {
			    error.addMessage(new MessageBuilder().error()
			    		.source("email")
			    			.defaultText("Email address is already taken!").build());
			    transitionValue = "failure";
			}
		   
/*		   if(userDAO.getByEmail(supplier.getEmail())!=null) {
		    error.addMessage(new MessageBuilder().error()
		    		.source("email")
		    			.defaultText("Email address is already taken!").build());
		    transitionValue = "failure";
		   }*/
		  return transitionValue;
		 }
	public String saveAll(SupplierModel supplierModel) {
		String transitionValue = "success";
		
		Supplier supplier = supplierModel.getSupplier();
		if(session.getAttribute("userModel") != null) {
			UserModel userModel = (UserModel) session.getAttribute("userModel");
			supplier.setCreatedBy(userlabDAO.get(userModel.getId()));
		}
		Integer supplierId = supplierDAO.add(supplier);
		OnsiteAddress adress = supplierModel.getAddress();
		adress.setSupplierId(supplierId);
		onsiteAddressDAO.add(adress);
		return transitionValue;

	}

}
