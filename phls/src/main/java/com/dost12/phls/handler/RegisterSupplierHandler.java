package com.dost12.phls.handler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.binding.message.MessageBuilder;
import org.springframework.binding.message.MessageContext;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.dost12.phls.model.RegisterSupplierModel;
import com.dost12.phls.phlsbackend.dao.SupplierDAO;
import com.dost12.phls.phlsbackend.dao.UserDAO;
import com.dost12.phls.phlsbackend.dto.Address;
import com.dost12.phls.phlsbackend.dto.Supplier;
import com.dost12.phls.phlsbackend.dto.User;

@Component
public class RegisterSupplierHandler {


 @Autowired
 private PasswordEncoder passwordEncoder;
	
	
 @Autowired
 private UserDAO userDAO;
 
 @Autowired
 private SupplierDAO supplierDAO;
 
 public RegisterSupplierModel init() { 
  return new RegisterSupplierModel();
 } 
 public void addUser(RegisterSupplierModel registerSupplierModel, User user) {
  user.setRole("SUPPLIER");
  registerSupplierModel.setUser(user);
  registerSupplierModel.setSupplier(supplierDAO.getByEmail(user.getEmail()) );
 } 
 public void addBilling(RegisterSupplierModel registerSupplierModel, Address billing) {
	 registerSupplierModel.setBilling(billing);
 }

 public String validateUser(User user, MessageContext error) {
  String transitionValue = "success";
   if(!user.getPassword().equals(user.getConfirmPassword())) {
    error.addMessage(new MessageBuilder().error().source("confirmPassword").defaultText("Password does not match confirm password!").build());
    transitionValue = "failure";    
   }
   if(userDAO.getByEmail(user.getEmail())!=null) {
    error.addMessage(new MessageBuilder().error().source("email").defaultText("Email address is already taken!").build());
    transitionValue = "failure";
   }
 
   if(supplierDAO.getByEmail(user.getEmail()) == null) {
	    error.addMessage(new MessageBuilder().error().source("email").defaultText("Email address is not Registered as Supplier!").build());
	    transitionValue = "failure";	  
   }
   
  return transitionValue;
 }
 
 public String saveAll(RegisterSupplierModel registerSupplierModel) {
  String transitionValue = "success";
  User user = registerSupplierModel.getUser();
   
  // encode the password
  user.setPassword(passwordEncoder.encode(user.getPassword()));
  
  // save the user
  userDAO.add(user);
  // save the billing address
  Address billing = registerSupplierModel.getBilling();
  billing.setUserId(user.getId());
  billing.setBilling(true);  
  userDAO.addAddress(billing);
  
  Supplier supplier = supplierDAO.getByEmail(user.getEmail()) ;
  supplier.setUser(userDAO.getByEmail(supplier.getEmail()));
  supplierDAO.update(supplier);
  
  return transitionValue ;
 } 
}
