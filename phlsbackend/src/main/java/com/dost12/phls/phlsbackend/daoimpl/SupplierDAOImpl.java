package com.dost12.phls.phlsbackend.daoimpl;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.dost12.phls.phlsbackend.dao.SupplierDAO;
import com.dost12.phls.phlsbackend.dto.Supplier;
import com.dost12.phls.phlsbackend.dto.User;

@Repository("supplierDAO")
@Transactional
public class SupplierDAOImpl implements SupplierDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public Supplier getByEmail(String email) {
		String selectQuery = "FROM Supplier WHERE active = true AND email = :email";
		try {
		return sessionFactory
				.getCurrentSession()
					.createQuery(selectQuery, Supplier.class)
						.setParameter("email",email)
							.getSingleResult();
		}
		catch(Exception ex) {
			return null;
		}
							
	}
	
	@Override
	public Supplier getByEmailEnable(String email) {
		String selectQuery = "FROM Supplier WHERE active = true AND enable = true AND email = :email";
		try {
		return sessionFactory
				.getCurrentSession()
					.createQuery(selectQuery, Supplier.class)
						.setParameter("email",email)
							.getSingleResult();
		}
		catch(Exception ex) {
			return null;
		}
							
	}
	
	@Override
	public List<Supplier> list() {
		
		String selectActiveCategory = "FROM Supplier s WHERE s.active = :active ORDER BY updatedOn DESC";
		
		Query query = sessionFactory.getCurrentSession().createQuery(selectActiveCategory);
				
		query.setParameter("active", true);

		return query.getResultList();
	}

	@Override
	public List<Supplier> list(String email) {
		
		String selectActiveCategory = "FROM Supplier s WHERE s.active = :active AND email = :email ORDER BY updatedOn DESC";
		
		Query query = sessionFactory.getCurrentSession().createQuery(selectActiveCategory);
				
		query.setParameter("active", true);
		
		query.setParameter("email", email);

		return query.getResultList();
	}
	
	/*
	 * Getting single category based on id
	 */
	@Override
	public Supplier get(int id) {

		return sessionFactory.getCurrentSession().get(Supplier.class, Integer.valueOf(id));

	}

	@Override

	public Integer add(Supplier manufacture) {

		try {
			// add the category to the database table
			sessionFactory.getCurrentSession().persist(manufacture);
			Integer id = (Integer)sessionFactory.getCurrentSession().save(manufacture);
			return id;
		} catch (Exception ex) {
			ex.printStackTrace();
			return 0;
		}

	}

	/*
	 * Updating a single category
	 */
	@Override
	public boolean update(Supplier manufacture) {

		try {
			manufacture.setUpdatedOn(LocalDate.now());
			// add the category to the database table
			sessionFactory.getCurrentSession().update(manufacture);
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean delete(Supplier manufacture) {
		
		manufacture.setActive(false);	
		manufacture.setUpdatedOn(LocalDate.now());
		try {
			
			// add the category to the database table
			sessionFactory.getCurrentSession().update(manufacture);
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}


}
