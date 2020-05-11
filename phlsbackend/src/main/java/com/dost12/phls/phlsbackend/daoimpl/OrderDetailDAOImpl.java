package com.dost12.phls.phlsbackend.daoimpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.dost12.phls.phlsbackend.dao.CategoryDAO;
import com.dost12.phls.phlsbackend.dao.OrderDetailDAO;
import com.dost12.phls.phlsbackend.dto.Category;
import com.dost12.phls.phlsbackend.dto.OrderDetail;
import com.dost12.phls.phlsbackend.dto.Supplier;
import com.dost12.phls.phlsbackend.dto.User;

@Repository("orderDetailDAO")
@Transactional
public class OrderDetailDAOImpl implements OrderDetailDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<OrderDetail> list() {
		
		String selectActiveOrderDetail = "FROM OrderDetail";
		
		Query query = sessionFactory.getCurrentSession().createQuery(selectActiveOrderDetail);
				
		/*query.setParameter("active", true);*/
						
		return query.getResultList();
	}

	/*
	 * Getting single category based on id
	 */
	@Override
	public OrderDetail get(int id) {

		return sessionFactory.getCurrentSession().get(OrderDetail.class, Integer.valueOf(id));

	}

	@Override

	public boolean add(OrderDetail orderDetail) {

		try {
			// add the category to the database table
			sessionFactory.getCurrentSession().persist(orderDetail);
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
	public boolean update(OrderDetail orderDetail) {

		try {
			// add the category to the database table
			sessionFactory.getCurrentSession().update(orderDetail);
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean delete(OrderDetail orderDetail) {
		
		try {
			// add the category to the database table
			sessionFactory.getCurrentSession().update(orderDetail);
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

	@Override
	public List<OrderDetail> list(User user) {
		String selectActiveUser = "FROM OrderDetail WHERE user = :user";
		
		Query query = sessionFactory.getCurrentSession().createQuery(selectActiveUser);
				
		query.setParameter("user", user);
						
		return query.getResultList();
	}

}
