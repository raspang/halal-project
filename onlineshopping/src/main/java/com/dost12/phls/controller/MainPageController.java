package com.dost12.phls.controller;

import java.io.PrintWriter;
import java.io.StringWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;

import com.dost12.phls.exception.ProductNotFoundException;
import com.dost12.phls.model.UserModel;
import com.dost12.phls.phlsbackend.dao.CategoryDAO;
import com.dost12.phls.phlsbackend.dao.ProductDAO;
import com.dost12.phls.phlsbackend.dto.Category;
import com.dost12.phls.phlsbackend.dto.Product;

@Controller
public class MainPageController {
	
	private static final Logger logger = LoggerFactory.getLogger(MainPageController.class);
	
	@Autowired
	private CategoryDAO categoryDAO;
	
	@Autowired
	private ProductDAO productDAO;
	

	
	

		
}
