package com.dost12.phls.handler;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.binding.message.MessageContext;
import org.springframework.stereotype.Component;

import com.dost12.phls.model.ProductModel;
import com.dost12.phls.phlsbackend.dao.CategoryDAO;
import com.dost12.phls.phlsbackend.dao.IngredientDAO;
import com.dost12.phls.phlsbackend.dao.IngredientDetailDAO;
import com.dost12.phls.phlsbackend.dao.ProductDAO;
import com.dost12.phls.phlsbackend.dto.Category;
import com.dost12.phls.phlsbackend.dto.Ingredient;
import com.dost12.phls.phlsbackend.dto.IngredientDetail;
import com.dost12.phls.phlsbackend.dto.Product;

@Component
public class ProductHandler {

	private static final Logger logger = LoggerFactory.getLogger(ProductHandler.class);
	@Autowired
	private ProductDAO productDAO;
	
	@Autowired
	private IngredientDetailDAO ingredientDetailDAO;	

	@Autowired
	private IngredientDAO ingredientDAO;	
	
	@Autowired
	private CategoryDAO categoryDAO;
	
	public ProductModel init() {
		return new ProductModel();
	}

	public void addProduct(ProductModel productModel, Product product) {
		logger.info("Init Product");
		productModel.setProduct(product);	
		logger.info("setted Product");
	}

	public List<IngredientDetail> getIngredientsDetails(ProductModel productModel){
		
		List<IngredientDetail> ingredientDetails = new ArrayList<>();
		
		Product product = productModel.getProduct();
		if(product != null && product.getId() > 0)
			ingredientDetails = ingredientDetailDAO.getList(product) ;

		ingredientDetails.addAll(productModel.getIngredientDetails());

		return ingredientDetails;
		
	}
	public void addIngredientProduct(ProductModel productModel, IngredientDetail ingredientDetail) {
		List<IngredientDetail> ingredientDetails = productModel.getIngredientDetails();
		ingredientDetails.add(ingredientDetail);
		productModel.setIngredientDetails(ingredientDetails);
	}	
	public String validationProduct(Product product, MessageContext error) {
		  String transitionValue = "success";
		  return transitionValue;
	}

	public String validationIngrendientDetail(IngredientDetail ingredientDetail, MessageContext error ) {
		  String transitionValue = "success";
		  return transitionValue;
	}

	public String saveAll(ProductModel productModel){
		String transitionValue = "success";
		// save product from productModel
		Product product = productModel.getProduct();
		product.setIngredientDetails(productModel.getIngredientDetails());
		productDAO.add(product);
		
		// save ingredientDetail from productModel
		for (IngredientDetail element : productModel.getIngredientDetails()) 
			ingredientDetailDAO.add(element);
		
		return transitionValue;
	}
	
	public List<Ingredient> getIngredients(){
		return ingredientDAO.list();
	}
	public List<Category> getCategories(){		
		return categoryDAO.list();
	}	
	public List<Product> getProducts(){
		return productDAO.listActiveProducts();
	}
	
}
