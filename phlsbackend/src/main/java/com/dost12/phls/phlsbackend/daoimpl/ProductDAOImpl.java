package com.dost12.phls.phlsbackend.daoimpl;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.dost12.phls.phlsbackend.dao.ProductDAO;
import com.dost12.phls.phlsbackend.dto.Product;
import com.dost12.phls.phlsbackend.dto.Supplier;


@Repository("productDAO")
@Transactional
public class ProductDAOImpl implements ProductDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	/*
	 * SINGLE
	 * */
	
	@Override
	public Product get(int productId) {
		try {			
			return sessionFactory
					.getCurrentSession()
						.get(Product.class,Integer.valueOf(productId));			
		}
		catch(Exception ex) {		
			ex.printStackTrace();			
		}
		return null;
	}

	/*
	 * LIST
	 * */
	
	@Override
	public List<Product> list() {
		return sessionFactory
				.getCurrentSession()
					.createQuery("FROM Product" , Product.class)
						.getResultList();
	}

	/*
	 * INSERT
	 * */
	@Override
	public Integer add(Product product) {
		try {		
			
			Integer id = (Integer)sessionFactory
					.getCurrentSession()
						.save(product);
			return id;
		}
		catch(Exception ex) {		
			ex.printStackTrace();			
		}		
		return 0;
	}

	/*
	 * UPDATE
	 * */
	@Override
	public boolean update(Product product) {
		product.setUpdatedOn(LocalDate.now());;
		try {			
			sessionFactory
					.getCurrentSession()
						.update(product);
			return true;
		}
		catch(Exception ex) {		
			ex.printStackTrace();			
		}		
		return false;		
	}

	
	/*
	 * DELETE
	 * */
	@Override
	public boolean delete(Product product) {
		try {
			
			product.setActive(false);
			// call the update method
			return this.update(product);
		}
		catch(Exception ex) {		
			ex.printStackTrace();			
		}		
		return false;			
	}

	@Override
	public List<Product> getProductsByParam(String param, int count) {
		
		String query = "FROM Product WHERE active = true AND displayed = true ORDER BY " + param + " DESC";
		
		return sessionFactory
					.getCurrentSession()
						.createQuery(query,Product.class)
							.setFirstResult(0)
								.setMaxResults(count)
									.getResultList();
		
	}
	
	@Override
	public List<Product> getLatestActiveProducts(int count) {
		return sessionFactory
				.getCurrentSession()
					.createQuery("FROM Product WHERE active = :active AND displayed = true ORDER BY updatedOn, id", Product.class)
						.setParameter("active", true)
							.setFirstResult(0)
							.setMaxResults(count)
								.getResultList();					
	}	
	
	@Override
	public List<Product> listActiveDisplayedProducts() {
		String selectActiveProducts = "FROM Product WHERE active = :active  AND displayed = true ORDER BY updatedOn, id DESC";
		return sessionFactory
				.getCurrentSession()
					.createQuery(selectActiveProducts, Product.class)
						.setParameter("active", true)
							.getResultList();
	}

	@Override
	public List<Product> listActiveDisplayedProductsByCategory(int categoryId) {
		String selectActiveProductsByCategory = "FROM Product WHERE active = :active AND displayed = true AND categoryId = :categoryId ORDER BY updatedOn, id DESC";
		return sessionFactory
				.getCurrentSession()
					.createQuery(selectActiveProductsByCategory, Product.class)
						.setParameter("active", true)
						.setParameter("categoryId",categoryId)
							.getResultList();
	}
	
	
	
	
	@Override
	public List<Product> listActiveProducts() {
		String selectActiveProducts = "FROM Product WHERE active = :active ORDER BY updatedOn, id DESC";
		return sessionFactory
				.getCurrentSession()
					.createQuery(selectActiveProducts, Product.class)
						.setParameter("active", true)
							.getResultList();
	}

	@Override
	public List<Product> listActiveProductsByCategory(int categoryId) {
		String selectActiveProductsByCategory = "FROM Product WHERE active = :active AND categoryId = :categoryId ORDER BY updatedOn, id DESC";
		return sessionFactory
				.getCurrentSession()
					.createQuery(selectActiveProductsByCategory, Product.class)
						.setParameter("active", true)
						.setParameter("categoryId",categoryId)
							.getResultList();
	}

	



	
	@Override
	public List<Product> listActiveProductsBySupplier(Supplier supplier) {
		String query = "FROM Product WHERE active = :active AND supplier = :supplier ORDER BY updatedOn, id DESC";
		return sessionFactory
				.getCurrentSession()
					.createQuery(query, Product.class)
						.setParameter("active", true)
						.setParameter("supplier",supplier)
							.getResultList();
	}



}
