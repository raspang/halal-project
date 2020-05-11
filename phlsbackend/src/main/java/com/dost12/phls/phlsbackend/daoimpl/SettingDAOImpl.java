package com.dost12.phls.phlsbackend.daoimpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.dost12.phls.phlsbackend.dao.CategoryDAO;
import com.dost12.phls.phlsbackend.dao.SettingDAO;
import com.dost12.phls.phlsbackend.dto.Category;
import com.dost12.phls.phlsbackend.dto.Setting;

@Repository("settingDAO")
@Transactional
public class SettingDAOImpl implements SettingDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Setting> list() {
		
		String selectsetting = "FROM Setting";
		
		Query query = sessionFactory.getCurrentSession().createQuery(selectsetting);
				
						
		return query.getResultList();
	}

	/*
	 * Getting single Setting based on id
	 */
	@Override
	public Setting get(int id) {

		return sessionFactory.getCurrentSession().get(Setting.class, Integer.valueOf(id));

	}

	@Override

	public boolean add(Setting setting) {

		try {
			// add the Setting to the database table
			sessionFactory.getCurrentSession().persist(setting);
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
	public boolean update(Setting setting) {

		try {
			// add the category to the database table
			sessionFactory.getCurrentSession().update(setting);
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean delete(Setting setting) {
		
		
		try {
			// add the category to the database table
			sessionFactory.getCurrentSession().update(setting);
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

}
