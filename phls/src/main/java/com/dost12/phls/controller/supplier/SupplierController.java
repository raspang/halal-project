package com.dost12.phls.controller.supplier;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.dost12.phls.model.UserModel;
import com.dost12.phls.phlsbackend.dao.CategoryDAO;
import com.dost12.phls.phlsbackend.dao.CertificateDAO;
import com.dost12.phls.phlsbackend.dao.HalalAnalysisReportDAO;
import com.dost12.phls.phlsbackend.dao.HalalParameterDAO;
import com.dost12.phls.phlsbackend.dao.IngredientDAO;
import com.dost12.phls.phlsbackend.dao.IngredientDetailDAO;
import com.dost12.phls.phlsbackend.dao.NutritionFactsParameterDAO;
import com.dost12.phls.phlsbackend.dao.NutritionFactsResultDAO;
import com.dost12.phls.phlsbackend.dao.OnsiteAssessmentDAO;
import com.dost12.phls.phlsbackend.dao.ProductDAO;
import com.dost12.phls.phlsbackend.dao.SupplierDAO;
import com.dost12.phls.phlsbackend.dao.UserDAO;
import com.dost12.phls.phlsbackend.dto.Category;
import com.dost12.phls.phlsbackend.dto.Certification;
import com.dost12.phls.phlsbackend.dto.HalalAnalysisReport;
import com.dost12.phls.phlsbackend.dto.HalalParameter;
import com.dost12.phls.phlsbackend.dto.Ingredient;
import com.dost12.phls.phlsbackend.dto.IngredientDetail;
import com.dost12.phls.phlsbackend.dto.NutritionFactsParameter;
import com.dost12.phls.phlsbackend.dto.NutritionFactsResult;
import com.dost12.phls.phlsbackend.dto.OnsiteAssessment;
import com.dost12.phls.phlsbackend.dto.Supplier;
import com.dost12.phls.phlsbackend.dto.User;
import com.dost12.phls.phlsbackend.dto.Product;
import com.dost12.phls.util.FileUtil;
import com.dost12.phls.validator.ProductValidator;

@Controller
@RequestMapping("/supplier")
public class SupplierController {

	private static final Logger logger = LoggerFactory.getLogger(SupplierController.class);

	
	@Autowired
	private HttpSession session;	
	
	@Autowired
	private UserDAO userDAO;	
	
	@Autowired
	private CategoryDAO categoryDAO;

	@Autowired
	private IngredientDAO ingredientDAO;

	@Autowired
	private ProductDAO productDAO;

	@Autowired
	private IngredientDetailDAO ingredientDetailDAO;

	@Autowired
	private SupplierDAO supplierDAO;

	@Autowired
	private OnsiteAssessmentDAO onsiteAssessmentDAO;

	@Autowired
	private CertificateDAO certificationDAO;

	@Autowired
	private NutritionFactsParameterDAO nutritionFactsParameterDAO;
	
	@Autowired
	private HalalParameterDAO halalParameterDAO;
	
	@Autowired
	private HalalAnalysisReportDAO halalAnalysisReportDAO;	
	
	@Autowired
	private NutritionFactsResultDAO nutritionFactsResultDAO;	
	

	@RequestMapping(value = { "/", "/main", "/index" })
	public ModelAndView manageLabProduct(@RequestParam(name = "success", required = false) String success) {
		ModelAndView mv = new ModelAndView("page-supplier");
		mv.addObject("title", getCompanyName().getNameOfEstablishment()+" Page");
		mv.addObject("userClickDashboard", true);
		return mv;

	}

	@RequestMapping(value = "/orders")
	public ModelAndView orders() {
		ModelAndView mv = new ModelAndView("page-supplier");
		mv.addObject("title", "Order");
		mv.addObject("userClickOrders", true);
		return mv;
	}
	
	@RequestMapping(value = "/products")
	public ModelAndView products() {
		ModelAndView mv = new ModelAndView("page-supplier");
		mv.addObject("title", "Products");
		mv.addObject("userClickProducts", true);
		return mv;
	}

	@RequestMapping(value = "/ingredients")
	public ModelAndView ingredient(@RequestParam(name = "success", required = false) String success,
			@RequestParam(name = "id", required = false) String id) {
		ModelAndView mv = new ModelAndView("page-supplier");
		mv.addObject("title", "Ingredient");

		Ingredient ingredient = new Ingredient();
		if (id != null && ingredientDAO.get(Integer.valueOf(id)) != null) {
			mv.addObject("ingredientForm", true);
			ingredient = ingredientDAO.get(Integer.valueOf(id));
		} else
			mv.addObject("userClickIngredient", true);

		mv.addObject("ingredient", ingredient);
		return mv;
	}

	@RequestMapping(value = "/ingredient", method = RequestMethod.POST)
	public String addIngredient(@ModelAttribute("ingredient") Ingredient ingredient, HttpServletRequest request) {
		if (ingredient.getId() != 0)
			ingredientDAO.update(ingredient);
		else
			ingredientDAO.add(ingredient);
		return "redirect:/supplier/ingredients?success=ingredient";
	}

	@RequestMapping(value = "/ingredient/{id}/delete")
	public String deleteIngredient(@PathVariable int id, HttpServletRequest request) {
		if (ingredientDAO.get(Integer.valueOf(id)) != null)
			ingredientDAO.delete(ingredientDAO.get(Integer.valueOf(id)));
		return "redirect:/supplier/ingredients?success=remove";
	}



	
	@RequestMapping(value = "/product")
	public ModelAndView product(@RequestParam(name = "id", required = false) String id) {
		ModelAndView mv = new ModelAndView("page-supplier");

		mv.addObject("supplier", getCompanyName());

		mv.addObject("title", "Product");
		mv.addObject("productForm", true);

		if (id != null && productDAO.get(Integer.parseInt(id)).getId() != 0)
			mv.addObject("product", productDAO.get(Integer.parseInt(id)));
		else
			mv.addObject("product", new Product());

		return mv;
	}

	
	@RequestMapping(value = "/product", method = RequestMethod.POST)
	public String managePostProduct(@Valid @ModelAttribute("product") Product mProduct, BindingResult results,
			Model model, HttpServletRequest request) {
		// mandatory file upload check
		if (mProduct.getId() == 0) {
			new ProductValidator().validate(mProduct, results);
		} else {
			// edit check only when the file has been selected
			if (!mProduct.getFile().getOriginalFilename().equals("")) {
				new ProductValidator().validate(mProduct, results);
			}
		}
		if (results.hasErrors()) {
			model.addAttribute("message", "Validation fails for adding the product!");
			model.addAttribute("userClickProducts", true);
			return "page-supplier";
		}

		mProduct.setSupplier(supplierDAO.get(mProduct.getSupplierId()));

		if (mProduct.getId() != 0)
			productDAO.update(mProduct);
		else
			productDAO.add(mProduct);

		// upload the file
		if (!mProduct.getFile().getOriginalFilename().equals("")) {
			FileUtil.uploadFile(request, mProduct.getFile(), mProduct.getCode());
		}

		return "redirect:/supplier/products?success=product";
	}

	


	@RequestMapping(value = "/supplier/{supplierId}/products")
	public ModelAndView supplierProduct(@PathVariable int supplierId, HttpServletRequest request) {
		ModelAndView mv = new ModelAndView("page-supplier");
		Supplier supplier = supplierDAO.get(supplierId);
		mv.addObject("title", "Supplier Products");
		mv.addObject("supplierProductsForm", true);
		mv.addObject("supplier", supplier);
		mv.addObject("products", productDAO.listActiveProductsBySupplier(supplier));
		return mv;
	}

	@RequestMapping(value = "/product/{id}/ingredients")
	public ModelAndView productIngredients(@PathVariable int id,
			@RequestParam(name = "ingredientDetailId", required = false) String ingredientDetailId,
			HttpServletRequest request) {
		ModelAndView mv = new ModelAndView("page-supplier");
		Product product = productDAO.get(id);
		mv.addObject("product", product);
		
		// remove 
		List<Ingredient> ingredients = ingredientDAO.list();
		for (IngredientDetail ingredientDetail : ingredientDetailDAO.getList(productDAO.get(id))) 
			for(Ingredient ingredient : ingredientDAO.list())
				if(ingredientDetail.getIngredient().getName().equals(ingredient.getName())) 
					ingredients.remove(ingredient);
		
		if (id != 0) {
			if (ingredientDetailId != null && Integer.parseInt(ingredientDetailId) > 0) {
				mv.addObject("title", "Ingredient");
				mv.addObject("productIngredientDetailForm", true);
				mv.addObject("ingredientDetail", ingredientDetailDAO.get(Integer.parseInt(ingredientDetailId)) );
				mv.addObject("ingredient", ingredientDetailDAO.get(Integer.parseInt(ingredientDetailId)).getIngredient() );
				mv.addObject("ingredients", ingredients );
			} else {
				mv.addObject("title", "Product Ingredients");
				mv.addObject("productIngredientsForm", true);
				mv.addObject("ingredientDetails", ingredientDetailDAO.getList(product));
			}
			
		}
		return mv;
	}
	@RequestMapping(value = "/product/{id}/ingredients/add")
	public ModelAndView addproductingredients(@PathVariable int id,
			HttpServletRequest request) {
		ModelAndView mv = new ModelAndView("page-supplier");
		
		List<Ingredient> ingredients = ingredientDAO.list();
		for (IngredientDetail ingredientDetail : ingredientDetailDAO.getList(productDAO.get(id))) 
			for(Ingredient ingredient : ingredientDAO.list())
				if(ingredientDetail.getIngredient().getName().equals(ingredient.getName())) 
					ingredients.remove(ingredient);
				

		
		mv.addObject("title", "Ingredient");
		mv.addObject("product", productDAO.get(id));
		mv.addObject("productIngredientDetailForm", true);
		mv.addObject("ingredientDetail", new IngredientDetail());
		mv.addObject("ingredients", ingredients);
		return mv;
	}
	
	@RequestMapping(value = "/product/{mProductId}/ingredients/ingredient", method = RequestMethod.POST)
	public String addProductIngredients(@PathVariable int mProductId, HttpServletRequest request,
			@Valid @ModelAttribute("ingredientDetail") IngredientDetail ingredientDetail, Model model,
			BindingResult results) {

		Product product = productDAO.get(mProductId);
		ingredientDetail.setIngredient(ingredientDAO.get(ingredientDetail.getIngredientId()));
		ingredientDetail.setProduct(product);
		
		if (ingredientDetail.getId() > 0)
			ingredientDetailDAO.update(ingredientDetail);
		else
			ingredientDetailDAO.add(ingredientDetail);
		
		return "redirect:/supplier/product/" + product.getId() + "/ingredients";

	}

	@RequestMapping(value = "/product/{id}/ingredients/{ingredientDetailId}/delete")
	public String deleteProductIngredient(@PathVariable int id, @PathVariable int ingredientDetailId,
			HttpServletRequest request) {
		Product product = productDAO.get(id);
		ingredientDetailDAO.delete(ingredientDetailDAO.get(ingredientDetailId));	
		return "redirect:/supplier/product/" + product.getId() + "/ingredients";
	}
	
	@ModelAttribute("categories")
	public List<Category> modelCategories() {
		return categoryDAO.list();
	}

	@ModelAttribute("suppliers")
	public List<Supplier> modelSuppliers() {
		return supplierDAO.list();
	}
	
	@ModelAttribute("company")
	private Supplier getCompanyName() {
		
		if(session.getAttribute("userModel") != null) {
			UserModel userModel = (UserModel) session.getAttribute("userModel");
			return supplierDAO.getByEmail(userModel.getEmail());
		}		
		return null;
	}

}
