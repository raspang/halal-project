package com.dost12.phls.phlsbackend.daoimpl;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.dost12.phls.phlsbackend.dao.HalalAnalysisReportDAO;
import com.dost12.phls.phlsbackend.dto.HalalAnalysisReport;
import com.dost12.phls.phlsbackend.dto.Product;

@Repository("halalAnalysisReportDAO")
@Transactional
public class HalalAnalysisReportDAOImpl implements HalalAnalysisReportDAO{
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<HalalAnalysisReport> list() {
		
		String selectActiveCategory = "FROM HalalAnalysisReport WHERE active = :active";
		
		Query query = sessionFactory.getCurrentSession().createQuery(selectActiveCategory);
				
		query.setParameter("active", true);
						
		return query.getResultList();
	}

	/*
	 * Getting single category based on id
	 */
	@Override
	public HalalAnalysisReport get(int id) {

		return sessionFactory.getCurrentSession().get(HalalAnalysisReport.class, Integer.valueOf(id));

	}

	@Override

	public boolean add(HalalAnalysisReport halalAnalysisReport) {

		try {

			// add the category to the database table
			sessionFactory.getCurrentSession().persist(halalAnalysisReport);
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
	public boolean update(HalalAnalysisReport halalAnalysisReport) {

		try {
			halalAnalysisReport.setUpdatedOn(LocalDate.now());
			// add the category to the database table
			sessionFactory.getCurrentSession().update(halalAnalysisReport);
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean delete(HalalAnalysisReport halalAnalysisReport) {
		
		halalAnalysisReport.setActive(false);
		
		try {
			// add the category to the database table
			sessionFactory.getCurrentSession().update(halalAnalysisReport);
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

	@Override
	public List<HalalAnalysisReport> listOfProduct(Product product) {
		
		String selectActiveCategory = "FROM HalalAnalysisReport WHERE active = :active AND product = :product ORDER BY updatedOn DESC";
		                                    
		Query query = sessionFactory.getCurrentSession().createQuery(selectActiveCategory);
				
		query.setParameter("active", true);
		
		query.setParameter("product", product);
						
		return query.getResultList();
	}
}
