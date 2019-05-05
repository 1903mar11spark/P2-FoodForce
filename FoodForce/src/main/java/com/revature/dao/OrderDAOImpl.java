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
	public boolean createOrder(float total, int customerId, int employeeId) {
		
		return false;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Order> getCustomerOrders(int customerId) {
		List<Order> orders = new ArrayList<>();
		try(Session s = sessionFactory.getCurrentSession()){
		Transaction tx = s.beginTransaction();
		orders= s.createQuery("from orders").getResultList();
		tx.commit();
		}
		return orders;
	}

	@Override
	public Order updateStatus(int orderId, String status) {
		
		return null;
	}

	@Override
	public Order updateTotal(int orderId, float total) {
		
		return null;
	}

}
