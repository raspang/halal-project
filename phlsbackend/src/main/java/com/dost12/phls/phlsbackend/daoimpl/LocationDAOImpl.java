package com.dost12.phls.phlsbackend.daoimpl;

import java.util.Date;
import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.dost12.phls.phlsbackend.dao.LocationDAO;
import com.dost12.phls.phlsbackend.dto.Shipment;

@Repository("locationDAO")
@Transactional
public class LocationDAOImpl implements LocationDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Shipment> list() {
		
		String selectActiveCategory = "FROM Location WHERE active = :active";
		
		Query query = sessionFactory.getCurrentSession().createQuery(selectActiveCategory);
				
		query.setParameter("active", true);
						
		return query.getResultList();
	}

	/*
	 * Getting single category based on id
	 */
	@Override
	public Shipment get(int id) {

		return sessionFactory.getCurrentSession().get(Shipment.class, Integer.valueOf(id));

	}

	@Override
	public boolean add(Shipment location) {

		try {
			location.setCreatedOn(new Date());
			location.setUpdatedOn(new Date());
			// add the category to the database table
			sessionFactory.getCurrentSession().persist(location);
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
	public boolean update(Shipment location) {

		try {
			location.setUpdatedOn(new Date());
			// add the category to the database table
			sessionFactory.getCurrentSession().update(location);
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean delete(Shipment location) {
		
		location.setActive(false);
		location.setUpdatedOn(new Date());
		try {
			// add the category to the database table
			sessionFactory.getCurrentSession().update(location);
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

}
