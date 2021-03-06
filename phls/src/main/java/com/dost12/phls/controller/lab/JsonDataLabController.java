package com.dost12.phls.controller.lab;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dost12.phls.phlsbackend.dao.CategoryDAO;
import com.dost12.phls.phlsbackend.dao.CertificateDAO;
import com.dost12.phls.phlsbackend.dao.HalalParameterDAO;
import com.dost12.phls.phlsbackend.dao.IngredientDAO;
import com.dost12.phls.phlsbackend.dao.IngredientDetailDAO;
import com.dost12.phls.phlsbackend.dao.NutritionFactsParameterDAO;
import com.dost12.phls.phlsbackend.dao.OnsiteAddressDAO;
import com.dost12.phls.phlsbackend.dao.OnsiteAssessmentDAO;
import com.dost12.phls.phlsbackend.dao.PersonnelDAO;
import com.dost12.phls.phlsbackend.dao.ProductDAO;
import com.dost12.phls.phlsbackend.dao.SupplierDAO;
import com.dost12.phls.phlsbackend.dto.Category;
import com.dost12.phls.phlsbackend.dto.Certification;
import com.dost12.phls.phlsbackend.dto.HalalParameter;
import com.dost12.phls.phlsbackend.dto.Ingredient;
import com.dost12.phls.phlsbackend.dto.IngredientDetail;
import com.dost12.phls.phlsbackend.dto.NutritionFactsParameter;
import com.dost12.phls.phlsbackend.dto.OnsiteAddress;
import com.dost12.phls.phlsbackend.dto.OnsiteAssessment;
import com.dost12.phls.phlsbackend.dto.Personnel;
import com.dost12.phls.phlsbackend.dto.Supplier;
import com.dost12.phls.phlsbackend.dto.Product;

@Controller
@RequestMapping("/laboratory/json/data")
public class JsonDataLabController {

	@Autowired
	private ProductDAO productDAO;

	@Autowired
	private CategoryDAO categoryDAO;

	@Autowired
	private IngredientDAO ingredientDAO;
	
	@Autowired
	private CertificateDAO certificateDAO;
	
	@Autowired
	private SupplierDAO supplierDAO;
	
	@Autowired
	private IngredientDetailDAO ingredientDetailDAO;
	
	@Autowired
	private OnsiteAssessmentDAO onsiteAssessmentDAO;
	
	@Autowired
	private NutritionFactsParameterDAO nutritionFactsParameterDAO;

	@Autowired
	private HalalParameterDAO halalParameterDAO;
	
	@Autowired
	private PersonnelDAO personnelDAO;
	
	@Autowired
	private OnsiteAddressDAO onsiteAddressDAO;
	
	
	@RequestMapping("/all/categories")
	@ResponseBody
	public List<Category> getAllCategorysList() {		
		return categoryDAO.list();
	}	
	
	@RequestMapping("/all/ingredients")
	@ResponseBody
	public List<Ingredient> getAllIngredientsList() {		
		return ingredientDAO.list();
	}
	
	@RequestMapping("/all/certifications")
	@ResponseBody
	public List<Certification> getAllCertificationsList() {		
		return certificateDAO.list();
	}		

	@RequestMapping("/all/products")
	@ResponseBody
	public List<Product> getAllProductsJSONList() {		
		return productDAO.listActiveProducts();
	}

	@RequestMapping("/category/{id}/products")
	@ResponseBody
	public List<Product> getProductsByCategory(@PathVariable int id) {
		return productDAO.listActiveProductsByCategory(id);
	}
	
	@RequestMapping("/all/suppliers")
	@ResponseBody
	public List<Supplier> getAllSupplierJSONList() {		
		return supplierDAO.list();
	}
	
	@RequestMapping("/all/onsiteassessments")
	@ResponseBody
	public List<OnsiteAssessment> getAllAssessmentJSONList() {		
		return onsiteAssessmentDAO.list();
	}
	
	@RequestMapping("/product/{id}/ingredients")
	@ResponseBody
	public List<IngredientDetail> getProductsByIngredients(@PathVariable int id) {
		Product p = productDAO.get(id);
		List<IngredientDetail> ingredientDetails = ingredientDetailDAO.getList(p);
		return ingredientDetails;
		
	}
	
	@RequestMapping("/onsite/{id}/addresses")
	@ResponseBody
	public List<OnsiteAddress> getOnsiteAddress(@PathVariable int id) {
	
		List<OnsiteAddress> onsiteAddresses = onsiteAddressDAO.list(id);
		return onsiteAddresses;
	}	
	@RequestMapping("/all/nutritionfacts")
	@ResponseBody
	public List<NutritionFactsParameter> getAllNutritionFactsJSONList() {		
		return nutritionFactsParameterDAO.list();
	}
	@RequestMapping("/all/halalparameters")
	@ResponseBody
	public List<HalalParameter> getAllHalalParametersJSONList() {		
		return halalParameterDAO.list();
	}
	
	@RequestMapping("/all/personnels")
	@ResponseBody
	public List<Personnel> getAllPersonnelJSONList() {		
		return personnelDAO.list();
	}
}
 