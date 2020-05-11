package com.dost12.phls.phlsbackend.daoimpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.dost12.phls.phlsbackend.dao.CategoryDAO;
import com.dost12.phls.phlsbackend.dao.CertificateDAO;
import com.dost12.phls.phlsbackend.dto.Category;
import com.dost12.phls.phlsbackend.dto.Certification;

@Repository("certificateDAO")
@Transactional
public class CertificateDAOImpl implements CertificateDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Certification> list() {
		
		String selectActiveCategory = "FROM Certification WHERE isActive = :active";
		
		Query query = sessionFactory.getCurrentSession().createQuery(selectActiveCategory);
				
		query.setParameter("active", true);
						
		return query.getResultList();
	}

	/*
	 * Getting single category based on id
	 */
	@Override
	public Certification get(int id) {

		return sessionFactory.getCurrentSession().get(Certification.class, Integer.valueOf(id));

	}

	@Override

	public boolean add(Certification certification) {

		try {
			// add the category to the database table
			sessionFactory.getCurrentSession().persist(certification);
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
	public boolean update(Certification certification) {

		try {
			// add the category to the database table
			sessionFactory.getCurrentSession().update(certification);
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean delete(Certification certification) {
		
		certification.setActive(false);
		
		try {
			// add the category to the database table
			sessionFactory.getCurrentSession().update(certification);
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

}
