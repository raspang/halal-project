package com.dost12.phls.phlsbackend.dao;

import java.util.List;

import com.dost12.phls.phlsbackend.dto.Product;
import com.dost12.phls.phlsbackend.dto.Supplier;

public interface ProductDAO {

	Product get(int productId);
	List<Product> list();	
	Integer add(Product product);
	boolean update(Product product);
	boolean delete(Product product);

	List<Product> getProductsByParam(String param, int count);	
	
	
	// business methods
	List<Product> listActiveProducts();	
	List<Product> listActiveProductsByCategory(int categoryId);
	List<Product> getLatestActiveProducts(int count);
	List<Product> listActiveProductsBySupplier(Supplier supplier);
	
	List<Product> listActiveDisplayedProducts();	
	List<Product> listActiveDisplayedProductsByCategory(int categoryId);

	
}
