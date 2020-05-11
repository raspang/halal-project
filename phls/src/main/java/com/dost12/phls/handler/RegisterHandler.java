package com.dost12.phls.handler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.binding.message.MessageBuilder;
import org.springframework.binding.message.MessageContext;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.dost12.phls.model.RegisterModel;
import com.dost12.phls.phlsbackend.dao.UserDAO;
import com.dost12.phls.phlsbackend.dao.UserlabDAO;
import com.dost12.phls.phlsbackend.dto.Address;
import com.dost12.phls.phlsbackend.dto.Cart;
import com.dost12.phls.phlsbackend.dto.User;
import com.dost12.phls.phlsbackend.dto.Userlab;

@Component
public class RegisterHandler {


 @Autowired
 private PasswordEncoder passwordEncoder;
	
	
 @Autowired
 private UserlabDAO userlabDAO;
 public RegisterModel init() { 
  return new RegisterModel();
 } 
 public void addUser(RegisterModel registerModel, Userlab userlab) {
  registerModel.setUserlab(userlab);
 } 
 public void addBilling(RegisterModel registerModel, Address billing) {
  registerModel.setBilling(billing);
 }

 public String validateUser(Userlab user, MessageContext error) {
  String transitionValue = "success";
   if(!user.getPassword().equals(user.getConfirmPassword())) {
    error.addMessage(new MessageBuilder().error().source(
      "confirmPassword").defaultText("Password does not match confirm password!").build());
    transitionValue = "failure";    
   }  
   if(userlabDAO.getByEmail(user.getEmail())!=null) {
    error.addMessage(new MessageBuilder().error().source(
      "email").defaultText("Email address is already taken!").build());
    transitionValue = "failure";
   }
  return transitionValue;
 }
 
 public String saveAll(RegisterModel registerModel) {
  String transitionValue = "success";
  Userlab user = registerModel.getUserlab();
  if(user.getRole().equals("USER")) {
   // create a new cart
/*   Cart cart = new Cart();
   cart.setUser(user);
   user.setCart(cart);*/
  }
   
  // encode the password
  user.setPassword(passwordEncoder.encode(user.getPassword()));
  
  // save the user
  userlabDAO.add(user);
  // save the billing address
  Address billing = registerModel.getBilling();
  billing.setUserId(user.getId());
  billing.setBilling(true);  
  userlabDAO.addAddress(billing);
  
  return transitionValue ;
 } 
}
