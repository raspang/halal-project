package com.dost12.phls.phlsbackend.daoimpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.dost12.phls.phlsbackend.dao.CategoryDAO;
import com.dost12.phls.phlsbackend.dao.OnsiteAddressDAO;
import com.dost12.phls.phlsbackend.dto.Category;
import com.dost12.phls.phlsbackend.dto.OnsiteAddress;
import com.dost12.phls.phlsbackend.dto.Supplier;

@Repository("onsiteAddressDAO")
@Transactional
public class OnsiteAddressDAOImpl implements OnsiteAddressDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<OnsiteAddress> list() {
		
		String selectActiveCategory = "FROM OnsiteAddress WHERE active = :active";
		
		Query query = sessionFactory.getCurrentSession().createQuery(selectActiveCategory);
				
		query.setParameter("active", true);
						
		return query.getResultList();
	}

	/*
	 * Getting single category based on id
	 */
	@Override
	public OnsiteAddress get(int id) {

		return sessionFactory.getCurrentSession().get(OnsiteAddress.class, Integer.valueOf(id));

	}

	@Override

	public boolean add(OnsiteAddress onsiteAddress) {

		try {
			// add the category to the database table
			sessionFactory.getCurrentSession().persist(onsiteAddress);
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
	public boolean update(OnsiteAddress onsiteAddress) {

		try {
			// add the category to the database table
			sessionFactory.getCurrentSession().update(onsiteAddress);
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean delete(OnsiteAddress onsiteAddress) {
		
		onsiteAddress.setActive(false);
		
		try {
			// add the category to the database table
			sessionFactory.getCurrentSession().update(onsiteAddress);
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}
	
	@Override
	public List<OnsiteAddress> list(int id) {
		
		
		String selectActiveCategory = "FROM OnsiteAddress WHERE supplierId = :supplierId AND "
				+ "active = :active";
		
		Query query = sessionFactory.getCurrentSession().createQuery(selectActiveCategory);
				
		query.setParameter("active", true);
		
		query.setParameter("supplierId", id);
						
		return query.getResultList();
	}

}
