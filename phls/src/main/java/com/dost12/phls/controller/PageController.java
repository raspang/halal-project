package com.dost12.phls.controller;

import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.dost12.phls.exception.ProductNotFoundException;
import com.dost12.phls.model.UserModel;
import com.dost12.phls.phlsbackend.dao.CategoryDAO;
import com.dost12.phls.phlsbackend.dao.HalalAnalysisReportDAO;
import com.dost12.phls.phlsbackend.dao.IngredientDetailDAO;
import com.dost12.phls.phlsbackend.dao.NutritionFactsResultDAO;
import com.dost12.phls.phlsbackend.dao.ProductDAO;
import com.dost12.phls.phlsbackend.dao.SupplierDAO;
import com.dost12.phls.phlsbackend.dto.Category;
import com.dost12.phls.phlsbackend.dto.Product;
import com.dost12.phls.phlsbackend.dto.Supplier;
import com.dost12.phls.util.FileUtil;
import com.dost12.phls.validator.SupplierValidator;

@Controller
public class PageController {
	
	private static final Logger logger = LoggerFactory.getLogger(PageController.class);
	
	@Autowired
	private CategoryDAO categoryDAO;
	
	@Autowired
	private ProductDAO productDAO;
	
	@Autowired
	private IngredientDetailDAO ingredientDetailDAO;
	
	@Autowired
	private HalalAnalysisReportDAO halalAnalysisReportDAO;

	@Autowired
	private NutritionFactsResultDAO nutritionFactsResultDAO;
	
	@Autowired
	private SupplierDAO supplierDAO;
	
	@Autowired
	private HttpSession session;	
	
	@RequestMapping(value = {"/home", "/index"})
	public ModelAndView index(@RequestParam(name="logout",required=false)String logout) {		
		ModelAndView mv = new ModelAndView("page");		
		mv.addObject("title","Home");
		
		logger.info("Inside PageController index method - INFO");
		logger.debug("Inside PageController index method - DEBUG");
		
		//passing the list of categories
		mv.addObject("categories", categoryDAO.list());
		
		if(logout!=null) {
			mv.addObject("message", "You have successfully logged out!");			
		}
		
		mv.addObject("userClickHome",true);	
		return mv;				
	}

	@RequestMapping(value = {"/"})
	public String index(@RequestParam(name="logout",required=false)String logout,
			HttpServletRequest request, HttpServletResponse response) {
		if(session.getAttribute("userModel") != null) {
			UserModel userModel = (UserModel) session.getAttribute("userModel");
			if(userModel.getRole().equals("LABORATORY")) 
				return "redirect:/laboratory";		
			else if (userModel.getRole().equals("USER"))
				return "redirect:/home";
			
		}
		return "redirect:/home";
		
	}	
	
	@RequestMapping(value="/login")
	public ModelAndView login(@RequestParam(name="error", required = false)	String error,
			@RequestParam(name="logout", required = false) String logout) {
		
		ModelAndView mv= new ModelAndView("login");
		mv.addObject("title", "Login");
		if(error!=null) {
			mv.addObject("message", "Username and Password is invalid!");
		}
		if(logout!=null) {
			mv.addObject("logout", "You have logged out successfully!");
		}
		return mv;
	}
	
	@RequestMapping(value="/logout")
	public String logout(HttpServletRequest request, HttpServletResponse response) {
		// Invalidates HTTP Session, then unbinds any objects bound to it.
	    // Removes the authentication from securitycontext 		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	    if (auth != null){    
	        new SecurityContextLogoutHandler().logout(request, response, auth);
	    }
		
		return "redirect:/login?logout";
	}	
	
	
	@RequestMapping(value="/access-denied")
	public ModelAndView accessDenied() {
		ModelAndView mv = new ModelAndView("error");		
		mv.addObject("errorTitle", "Error");		
		mv.addObject("errorDescription", "You are not authorized to view this page!");		
		mv.addObject("title", "403 Access Denied");		
		return mv;
	}		
	
	@RequestMapping(value = "/servicesLaboratory")
	public ModelAndView servicesLaboratoryPage() {		
		ModelAndView mv = new ModelAndView("page");		
		mv.addObject("title","Halal Laboratory");
		mv.addObject("userClickServicesLaboratory",true);
		return mv;				
	}	
	
	@RequestMapping(value = "/servicesLabTesting")
	public ModelAndView servicesLabTestingPage() {		
		ModelAndView mv = new ModelAndView("page");		
		mv.addObject("title","Testing and Verification");
		mv.addObject("userClickServicesLabTesting",true);
		return mv;				
	}
	
	@RequestMapping(value = "/servicesLabOnSite")
	public ModelAndView servicesLabOnSitePage() {		
		ModelAndView mv = new ModelAndView("page");		
		mv.addObject("title","On-Site Assessment and Product Certification");
		mv.addObject("userClickServicesLabOnSite",true);
		return mv;				
	}
	
	@RequestMapping(value = "/servicesFoodDevelopment")
	public ModelAndView foodDevelopmentPage() {		
		ModelAndView mv = new ModelAndView("page");		
		mv.addObject("title","Halal Food Developement/Training");
		mv.addObject("userClickServicesFoodDev",true);
		return mv;				
	}	

	@RequestMapping(value = "/servicesPackageLabel")
	public ModelAndView servicesPackageLabelPage() {		
		ModelAndView mv = new ModelAndView("page");		
		mv.addObject("title","Halal Packaging and Labeling");
		mv.addObject("userClickServicesPackageLabel",true);
		return mv;				
	}	
	
	@RequestMapping(value = "/servicesResearch")
	public ModelAndView servicesResearchPage() {		
		ModelAndView mv = new ModelAndView("page");		
		mv.addObject("title","Halal Research and Development");
		mv.addObject("userClickServicesResearch",true);
		return mv;				
	}
	
	@RequestMapping(value = "/requestLabService")
	public ModelAndView requestLabServicePage() {		
		ModelAndView mv = new ModelAndView("page");		
		mv.addObject("title","Request Laboratory Service");
		mv.addObject("userClickRequestLaboratoryService",true);
		return mv;				
	}	
	
	@RequestMapping(value = "/about")
	public ModelAndView about() {		
		ModelAndView mv = new ModelAndView("page");		
		mv.addObject("title","About Us");
		mv.addObject("userClickAbout",true);
		return mv;				
	}	

	
	@RequestMapping(value = "/enterprise")
	public ModelAndView enterprice() {		
		ModelAndView mv = new ModelAndView("page");		
		mv.addObject("title","Enterprise");
		mv.addObject("userClickEnterprise",true);
		return mv;				
	}		
	
	@RequestMapping(value = "/contact")
	public ModelAndView contact() {		
		ModelAndView mv = new ModelAndView("page");		
		mv.addObject("title","Contact Us");
		mv.addObject("userClickContact",true);
		return mv;				
	}
	
	@RequestMapping(value = "/multimedia")
	public ModelAndView multimedia() {		
		ModelAndView mv = new ModelAndView("page");		
		mv.addObject("title","Multimedia");
		mv.addObject("userClickMultimedia",true);
		return mv;				
	}		
	/*
	 * Methods to load all the products and based on category
	 * */
	
	@RequestMapping(value = "/show/all/products")
	public ModelAndView showAllProducts() {		
		ModelAndView mv = new ModelAndView("page");		
		mv.addObject("title","All Products");
		
		//passing the list of categories
		mv.addObject("categories", categoryDAO.list());
		
		mv.addObject("userClickAllProducts",true);
		return mv;				
	}	
	
	@RequestMapping(value = "/show/category/{id}/products")
	public ModelAndView showCategoryProducts(@PathVariable("id") int id) {		
		ModelAndView mv = new ModelAndView("page");
		
		// categoryDAO to fetch a single category
		Category category = null;
		
		category = categoryDAO.get(id);
		
		mv.addObject("title",category.getNameRp());
		
		//passing the list of categories
		mv.addObject("categories", categoryDAO.list());
		
		// passing the single category object
		mv.addObject("category", category);
		
		mv.addObject("userClickCategoryProducts",true);
		return mv;				
	}	
	
	
	/*
	 * Viewing a single product
	 * */
	
	@RequestMapping(value = "/show/{id}/product") 
	public ModelAndView showSingleProduct(@PathVariable int id) throws ProductNotFoundException {
		
		ModelAndView mv = new ModelAndView("page");
		
		Product product = productDAO.get(id);
	
		if(product == null) throw new ProductNotFoundException();
		
		// update the view count
		product.setViews(product.getViews() + 1);
		productDAO.update(product);
		//---------------------------
		
		mv.addObject("title", product.getName());
		mv.addObject("product", product);
		mv.addObject("ingredientDetails", ingredientDetailDAO.getList(product));
		mv.addObject("halalAnalysisReports", halalAnalysisReportDAO.listOfProduct(product));
		mv.addObject("nutritionFactsResults", nutritionFactsResultDAO.listOfProduct(product));		
		mv.addObject("userClickShowProduct", true);

		return mv;
		
	}
	
	
	@RequestMapping(value="/membership")
	public ModelAndView register() {
		ModelAndView mv= new ModelAndView("page");
		
		logger.info("Page Controller membership called!");
		
		return mv;
	}
	
	@RequestMapping(value="/halalregistration")
	public ModelAndView halalregister() {
		ModelAndView mv= new ModelAndView("companyform");
		
		mv.addObject("title","Registration");
		
		mv.addObject("supplier", new Supplier());
		logger.info("Page Controller membership called!");
		
		return mv;
	}
	
	@RequestMapping(value="/halalregistration", method = RequestMethod.POST)
	public String singleFileUpload(@Valid Supplier supplier, BindingResult result, ModelMap model, HttpServletRequest request) throws IOException {

		new SupplierValidator().validate(supplier, result);
		
		if (result.hasErrors()) {
			model.addAttribute("message", "Validation fails for adding the File!");
			return "companyform";
		}
		
		supplierDAO.add(supplier);
		
		// upload the file
		if (!supplier.getFile().getOriginalFilename().equals("")) {
			FileUtil.uploadDoc(request, supplier.getFile(), supplier.getCode());
		}
		
		return "page";
	}
		
	
	
}
