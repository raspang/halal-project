package com.dost12.phls.phlsbackend.daoimpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.dost12.phls.phlsbackend.dao.NutritionFactsParameterDAO;
import com.dost12.phls.phlsbackend.dto.NutritionFactsParameter;
import com.dost12.phls.phlsbackend.dto.Product;

@Repository("nutritionFactsParameterDAO")
@Transactional
public class NutritionFactsParameterDAOImpl implements NutritionFactsParameterDAO{
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<NutritionFactsParameter> list() {
		
		String selectActiveCategory = "FROM NutritionFactsParameter WHERE active = :active";
		
		Query query = sessionFactory.getCurrentSession().createQuery(selectActiveCategory);
				
		query.setParameter("active", true);
						
		return query.getResultList();
	}

	/*
	 * Getting single category based on id
	 */
	@Override
	public NutritionFactsParameter get(int id) {

		return sessionFactory.getCurrentSession().get(NutritionFactsParameter.class, Integer.valueOf(id));

	}

/*	@Override

	public boolean add(NutritionFactsParameter nutritionFactsParameter) {

		try {
			// add the category to the database table
			sessionFactory.getCurrentSession().persist(nutritionFactsParameter);
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}

	}*/
	
	/*
	 * INSERT
	 * */
	@Override
	public Integer add(NutritionFactsParameter nutritionFactsParameter) {
		try {		
			
			Integer id = (Integer)sessionFactory
					.getCurrentSession()
						.save(nutritionFactsParameter);
			return id;
		}
		catch(Exception ex) {		
			ex.printStackTrace();			
		}		
		return 0;
	}


	/*
	 * Updating a single category
	 */
	@Override
	public boolean update(NutritionFactsParameter nutritionFactsParameter) {

		try {
		
			// add the category to the database table
			sessionFactory.getCurrentSession().update(nutritionFactsParameter);
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean delete(NutritionFactsParameter nutritionFactsParameter) {
		
		nutritionFactsParameter.setActive(false);
		
		try {
			// add the category to the database table
			sessionFactory.getCurrentSession().update(nutritionFactsParameter);
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}
}
