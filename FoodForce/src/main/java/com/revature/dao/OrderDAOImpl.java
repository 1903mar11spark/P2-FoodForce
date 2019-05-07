package com.revature.dao;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.revature.beans.Order;


@Repository
@Transactional
public class OrderDAOImpl implements OrderDAO {
	
	
	private SessionFactory sessionFactory;

	@Autowired
	public OrderDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	

	@Override
	public boolean createOrder(Order order) {
		
		return false;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Order> getCustomerOrders(int customerId) {
		
		List<Order> orders = new ArrayList<>();
		
		Session s = sessionFactory.getCurrentSession();
		Transaction tx = s.beginTransaction();
		orders= s.createQuery("from orders").getResultList();
		tx.commit();
		
		return orders;
	}

	@Override
	public Order updateStatus(Order order) {
		
		return null;
	}

	@Override
	public Order updateTotal(Order order) {
		
//		
//		Session s = sessionFactory.getCurrentSession();
//		Transaction tx = s.beginTransaction(); 
//			
//		//order = s.get(Order.class, orderId);
//		//s.update(Order.class, total);
//		tx.commit(); 
//			
	return null;
	}


	@Override
	public Order deleteOrder(Order order) {
		
		return null;
	}

}
