package com.dost12.phls.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.dost12.phls.model.UserModel;
import com.dost12.phls.phlsbackend.dao.UserDAO;
import com.dost12.phls.phlsbackend.dao.UserlabDAO;
import com.dost12.phls.phlsbackend.dto.Cart;
import com.dost12.phls.phlsbackend.dto.User;
import com.dost12.phls.phlsbackend.dto.Userlab;

@ControllerAdvice
public class GlobalController {
	
	
	@Autowired
	private UserlabDAO userlabDAO;
	
	@Autowired
	private HttpSession session;
	
	private UserModel userModel = null;
	private Userlab user = null;	
	
	
	@ModelAttribute("userModel")
	public UserModel getUserModel() {		
		if(session.getAttribute("userModel")==null) {
			// get the authentication object
			Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
			
			
			if(!authentication.getPrincipal().equals("anonymousUser")){
				// get the user from the database
				user = userlabDAO.getByEmail(authentication.getName());
				
				if(user!=null) {
					// create a new model
					userModel = new UserModel();
					// set the name and the id
					userModel.setId(user.getId());
					userModel.setFullName(user.getFirstName() + " " + user.getLastName());
					userModel.setRole(user.getRole());
					userModel.setEmail(user.getEmail());
			
	
					session.setAttribute("userModel", userModel);
					return userModel;
				}			
			}
		}
		
		return (UserModel) session.getAttribute("userModel");		
	}
		
}
