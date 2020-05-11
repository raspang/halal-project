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
import com.dost12.phls.phlsbackend.dto.Category;
import com.dost12.phls.phlsbackend.dto.Ingredient;

@Repository("ingredientDAO")
@Transactional
public class IngredientDAOImpl implements IngredientDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Ingredient> list() {
		
		String selectActiveCategory = "FROM Ingredient WHERE active = :active";
		
		Query query = sessionFactory.getCurrentSession().createQuery(selectActiveCategory);
				
		query.setParameter("active", true);
						
		return query.getResultList();
	}

	/*
	 * Getting single category based on id
	 */
	@Override
	public Ingredient get(int id) {

		return sessionFactory.getCurrentSession().get(Ingredient.class, Integer.valueOf(id));

	}

	@Override
	public boolean add(Ingredient ingredient) {
		
		try {
			ingredient.setCreatedOn(new Date());
			ingredient.setUpdateOn(new Date());
			// add the category to the database table
			sessionFactory.getCurrentSession().persist(ingredient);
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}

	}

	/*
	 * Updating a single category
	 */
	@Override
	public boolean update(Ingredient ingredient) {

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
	public boolean delete(Ingredient ingredient) {
		
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

}
