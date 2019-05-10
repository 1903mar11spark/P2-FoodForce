package com.revature.dao;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.revature.beans.Order;


@Repository(value = "OrderDAO")
@Transactional
public class OrderDAOImpl implements OrderDAO {
	
	
	private SessionFactory sessionFactory;

	@Autowired
	public OrderDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	

	@Override
	public void createOrder(Order order) {
		sessionFactory.getCurrentSession().persist(order);

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Order> getCustomerOrders(int customerId) {
		
		List<Order> orders = new ArrayList<>();
		
		Session s = sessionFactory.getCurrentSession();
		orders= s.createQuery("from Orders").getResultList();
		return orders;
	}

	@Override
	public void updateStatus(Order order) {
		sessionFactory.getCurrentSession().saveOrUpdate(order);
	}

//	@Override
//	public void updateTotal(Order order) {
//		sessionFactory.getCurrentSession().saveOrUpdate(order);
//	}
	
	@Override
	public void deleteOrder(Order order) {
		sessionFactory.getCurrentSession().delete(order);
		
	}

}
