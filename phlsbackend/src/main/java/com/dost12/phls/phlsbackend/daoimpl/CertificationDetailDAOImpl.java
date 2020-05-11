package com.dost12.phls.phlsbackend.daoimpl;

import java.util.Date;
import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.dost12.phls.phlsbackend.dao.CategoryDAO;
import com.dost12.phls.phlsbackend.dao.CertificateDAO;
import com.dost12.phls.phlsbackend.dao.CertificationDetailDAO;
import com.dost12.phls.phlsbackend.dto.Category;
import com.dost12.phls.phlsbackend.dto.Certification;
import com.dost12.phls.phlsbackend.dto.CertificationDetail;

@Repository("certificationDetailDAO")
@Transactional
public class CertificationDetailDAOImpl implements CertificationDetailDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<CertificationDetail> list() {
		
		String selectActiveCategory = "FROM CertificationDetail WHERE isActive = :active";
		
		Query query = sessionFactory.getCurrentSession().createQuery(selectActiveCategory);
				
		query.setParameter("active", true);
						
		return query.getResultList();
	}

	/*
	 * Getting single category based on id
	 */
	@Override
	public CertificationDetail get(int id) {

		return sessionFactory.getCurrentSession().get(CertificationDetail.class, Integer.valueOf(id));

	}

	@Override

	public boolean add(CertificationDetail certificationDetail) {

		try {
			certificationDetail.setCreatedOn(new Date());
			certificationDetail.setUpdateOn(new Date());
			// add the category to the database table
			sessionFactory.getCurrentSession().persist(certificationDetail);
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
	public boolean update(CertificationDetail certificationDetail) {

		try {
			certificationDetail.setUpdateOn(new Date());
			// add the category to the database table
			sessionFactory.getCurrentSession().update(certificationDetail);
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean delete(CertificationDetail certification) {
		
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
