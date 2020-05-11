package com.dost12.phls.handler;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.binding.message.MessageBuilder;
import org.springframework.binding.message.MessageContext;
import org.springframework.stereotype.Component;

import com.dost12.phls.model.HalalRegisterModel;
import com.dost12.phls.model.SupplierModel;
import com.dost12.phls.phlsbackend.dao.OnsiteAddressDAO;
import com.dost12.phls.phlsbackend.dao.SupplierDAO;
import com.dost12.phls.phlsbackend.dao.UserDAO;
import com.dost12.phls.phlsbackend.dto.OnsiteAddress;
import com.dost12.phls.phlsbackend.dto.Supplier;
import com.dost12.phls.phlsbackend.dto.User;

@Component
public class HalalRegisterHandler {

	private static final Logger logger = LoggerFactory.getLogger(HalalRegisterHandler.class);

	@Autowired
	private HttpSession session;

	@Autowired
	private SupplierDAO supplierDAO;

	@Autowired
	private OnsiteAddressDAO onsiteAddressDAO;

	@Autowired
	private UserDAO userDAO;

	public HalalRegisterModel init() {
		return new HalalRegisterModel();
	}

	public void addSupplier(HalalRegisterModel halalRegistrationModel, Supplier supplier) {
		halalRegistrationModel.setSupplier(supplier);
	}

	public void addAddress(HalalRegisterModel halalRegistrationModel, OnsiteAddress onsite) {
		halalRegistrationModel.setAddress(onsite);
	}

	public String validateSupplier(Supplier supplier, MessageContext error) {
		String transitionValue = "success";

		if (userDAO.getByEmail(supplier.getEmail()) != null) {
			error.addMessage(new MessageBuilder().error().source("email").defaultText("Email address is already taken!")
					.build());
			transitionValue = "failure";
		}
		return transitionValue;
	}

	public String saveAll(HalalRegisterModel halalRegistrationModel) {
		String transitionValue = "success";
		Integer supplierId = supplierDAO.add(halalRegistrationModel.getSupplier());
		OnsiteAddress adress = halalRegistrationModel.getAddress();
		adress.setSupplierId(supplierId);
		onsiteAddressDAO.add(adress);
		return transitionValue;

	}

}
