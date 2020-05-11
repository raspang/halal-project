package com.dost12.phls.phlsbackend.daoimpl;

import java.util.Date;
import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.dost12.phls.phlsbackend.dao.CategoryDAO;
import com.dost12.phls.phlsbackend.dao.IngredientDAO;
import com.dost12.phls.phlsbackend.dao.IngredientDetailDAO;
import com.dost12.phls.phlsbackend.dto.Category;
import com.dost12.phls.phlsbackend.dto.Ingredient;
import com.dost12.phls.phlsbackend.dto.IngredientDetail;
import com.dost12.phls.phlsbackend.dto.Product;

@Repository("ingredientDetailDAO")
@Transactional
public class IngredientDetailDAOImpl implements IngredientDetailDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<IngredientDetail> list() {
		
		String selectActiveCategory = "FROM IngredientDetail WHERE active = :active";
		
		Query query = sessionFactory.getCurrentSession().createQuery(selectActiveCategory);
				
		query.setParameter("active", true);
						
		return query.getResultList();
	}

	/*
	 * Getting single category based on id
	 */
	@Override
	public IngredientDetail get(int id) {

		return sessionFactory.getCurrentSession().get(IngredientDetail.class, Integer.valueOf(id));

	}

	@Override
	public Integer add(IngredientDetail ingredient) {

		try {
			ingredient.setCreatedOn(new Date());
			ingredient.setUpdateOn(new Date());
			// add the category to the database table
			Integer id = (Integer)sessionFactory.getCurrentSession().save(ingredient);
			return id;
		} catch (Exception ex) {
			ex.printStackTrace();
			return 0;
		}

	}

	/*
	 * Updating a single category
	 */
	@Override
	public boolean update(IngredientDetail ingredient) {

		try {
			ingredient.setUpdateOn(new Date());
			// add the category to the database table
			sessionFactory.getCurrentSession().update(ingredient);
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean delete(IngredientDetail ingredient) {
		
		ingredient.setActive(false);
		
		try {
			// add the category to the database table
			sessionFactory.getCurrentSession().update(ingredient);
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

	@Override
	public List<IngredientDetail> getList(Product product) {
		String selectActiveCategory = "FROM IngredientDetail WHERE active = :active AND product = :product";
		
		Query query = sessionFactory.getCurrentSession().createQuery(selectActiveCategory);
		
		query.setParameter("active", true);
		
		query.setParameter("product", product);
		
		return query.getResultList();
	}

}
