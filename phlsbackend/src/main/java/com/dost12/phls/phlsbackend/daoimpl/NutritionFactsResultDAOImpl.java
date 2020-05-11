package com.dost12.phls.phlsbackend.daoimpl;

import java.time.LocalDate;
import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.dost12.phls.phlsbackend.dao.NutritionFactsResultDAO;
import com.dost12.phls.phlsbackend.dto.NutritionFactsResult;
import com.dost12.phls.phlsbackend.dto.Product;

@Repository("nutritionFactsResultDAO")
@Transactional
public class NutritionFactsResultDAOImpl implements NutritionFactsResultDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<NutritionFactsResult> list() {

		String query1 = "FROM NutritionFactsResult WHERE active = :active";

		Query query = sessionFactory.getCurrentSession().createQuery(query1);

		query.setParameter("active", true);

		return query.getResultList();
	}

	/*
	 * Getting single category based on id
	 */
	@Override
	public NutritionFactsResult get(int id) {

		return sessionFactory.getCurrentSession().get(NutritionFactsResult.class, Integer.valueOf(id));

	}

	@Override
	public boolean add(NutritionFactsResult nutritionFactsResult) {

		try {
			// add the category to the database table
			sessionFactory.getCurrentSession().persist(nutritionFactsResult);
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
	public boolean update(NutritionFactsResult nutritionFactsResult) {
		
		try {
			nutritionFactsResult.setUpdatedOn(LocalDate.now());
			// add the category to the database table
			sessionFactory.getCurrentSession().update(nutritionFactsResult);
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean delete(NutritionFactsResult nutritionFactsResult) {

		nutritionFactsResult.setActive(false);

		try {
			// add the category to the database table
			sessionFactory.getCurrentSession().update(nutritionFactsResult);
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

	@Override
	public List<NutritionFactsResult> listOfProduct(Product product) {
		String query1 = "FROM NutritionFactsResult WHERE active = :active AND product =:product";

		Query query = sessionFactory.getCurrentSession().createQuery(query1);

		query.setParameter("active", true);
		
		query.setParameter("product", product);

		return query.getResultList();
	}
}
