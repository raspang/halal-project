package com.dost12.phls.phlsbackend.daoimpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.dost12.phls.phlsbackend.dao.HalalParameterDAO;
import com.dost12.phls.phlsbackend.dto.HalalParameter;

@Repository("halalParameterDAO")
@Transactional
public class HalalParameterDAOImpl implements HalalParameterDAO{
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<HalalParameter> list() {
		
		String selectActiveCategory = "FROM HalalParameter WHERE active = :active";
		
		Query query = sessionFactory.getCurrentSession().createQuery(selectActiveCategory);
				
		query.setParameter("active", true);
						
		return query.getResultList();
	}

	/*
	 * Getting single category based on id
	 */
	@Override
	public HalalParameter get(int id) {

		return sessionFactory.getCurrentSession().get(HalalParameter.class, Integer.valueOf(id));

	}

	@Override

	public boolean add(HalalParameter halalParameter) {

		try {
			// add the category to the database table
			sessionFactory.getCurrentSession().persist(halalParameter);
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
	public boolean update(HalalParameter halalParameter) {

		try {
	
			// add the category to the database table
			sessionFactory.getCurrentSession().update(halalParameter);
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean delete(HalalParameter halalParameter) {
		
		halalParameter.setActive(false);
		
		try {
			// add the category to the database table
			sessionFactory.getCurrentSession().update(halalParameter);
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}
}
