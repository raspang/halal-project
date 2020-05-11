package com.dost12.phls.phlsbackend.daoimpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.dost12.phls.phlsbackend.dao.CategoryDAO;
import com.dost12.phls.phlsbackend.dao.PersonnelDAO;
import com.dost12.phls.phlsbackend.dto.Category;
import com.dost12.phls.phlsbackend.dto.Personnel;
import com.dost12.phls.phlsbackend.dto.PersonnelType;

@Repository("personnelDAO")
@Transactional
public class PersonnelDAOImpl implements PersonnelDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Personnel> list() {
		
		String selectActiveCategory = "FROM Personnel WHERE active = :active";
		
		Query query = sessionFactory.getCurrentSession().createQuery(selectActiveCategory);
				
		query.setParameter("active", true);
						
		return query.getResultList();
	}

	/*
	 * Getting single category based on id
	 */
	@Override
	public Personnel get(int id) {

		return sessionFactory.getCurrentSession().get(Personnel.class, Integer.valueOf(id));

	}

	@Override

	public boolean add(Personnel personnel) {

		try {
			// add the category to the database table
			sessionFactory.getCurrentSession().persist(personnel);
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
	public boolean update(Personnel personnel) {

		try {
			// add the category to the database table
			sessionFactory.getCurrentSession().update(personnel);
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean delete(Personnel personnel) {
		
		personnel.setActive(false);
		
		try {
			// add the category to the database table
			sessionFactory.getCurrentSession().update(personnel);
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

	@Override
	public List<Personnel> list(PersonnelType personeelType) {
		
		String selectQeueryPersonnel = "FROM Personnel WHERE position = :position AND active = :active";
		
		Query query = sessionFactory.getCurrentSession().createQuery(selectQeueryPersonnel);
				
		query.setParameter("active", true);
		
		query.setParameter("position", personeelType.getUserProfileType());
						
		return query.getResultList();
	}

}
