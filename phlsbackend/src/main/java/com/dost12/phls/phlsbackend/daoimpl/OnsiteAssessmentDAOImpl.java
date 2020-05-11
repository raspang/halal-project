package com.dost12.phls.phlsbackend.daoimpl;

import java.time.LocalDate;
import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.dost12.phls.phlsbackend.dao.OnsiteAssessmentDAO;
import com.dost12.phls.phlsbackend.dto.OnsiteAssessment;

@Repository("onsiteAssessmentDAO")
@Transactional
public class OnsiteAssessmentDAOImpl implements OnsiteAssessmentDAO{
	                                            
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<OnsiteAssessment> list() {
		
		String selectActiveOnsiteAssessment = "FROM OnsiteAssessment WHERE active = :active";
		
		Query query = sessionFactory.getCurrentSession().createQuery(selectActiveOnsiteAssessment);
				
		query.setParameter("active", true);
						
		return query.getResultList();
	}

	/*
	 * Getting single category based on id
	 */
	@Override
	public OnsiteAssessment get(int id) {

		return sessionFactory.getCurrentSession().get(OnsiteAssessment.class, Integer.valueOf(id));

	}

	@Override

	public boolean add(OnsiteAssessment onsiteAssessment) {

		try {
			// add the category to the database table
			sessionFactory.getCurrentSession().persist(onsiteAssessment);
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
	public boolean update(OnsiteAssessment onsiteAssessment) {
		onsiteAssessment.setUpdateOn(LocalDate.now());
		try {
			// add the category to the database table
			sessionFactory.getCurrentSession().update(onsiteAssessment);
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean delete(OnsiteAssessment onsiteAssessment) {
		
		onsiteAssessment.setActive(false);
		onsiteAssessment.setUpdateOn(LocalDate.now());
		try {
			// add the category to the database table
			sessionFactory.getCurrentSession().update(onsiteAssessment);
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}
}
