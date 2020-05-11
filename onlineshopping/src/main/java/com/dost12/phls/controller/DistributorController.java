package com.dost12.phls.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/distributor")
public class DistributorController {

	private static final Logger logger = LoggerFactory.getLogger(DistributorController.class);
	
	@RequestMapping(value = {"/", "/main", "/index"})
	public ModelAndView dashboard(@RequestParam(name="success",required=false)String success) {		
		ModelAndView mv = new ModelAndView("page-distributor");		
		mv.addObject("title","Distributor Page");
		mv.addObject("userClickDashboard",true);
		return mv;
		
	}
	
}

	
