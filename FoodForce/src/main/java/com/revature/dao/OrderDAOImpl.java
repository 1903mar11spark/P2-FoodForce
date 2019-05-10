package com.revature.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.revature.entities.Customer;
import com.revature.entities.Order;


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
		try {
		
		Session session = sessionFactory.getCurrentSession();
		CriteriaBuilder builder = session.getCriteriaBuilder();
		CriteriaQuery<Order> query = builder.createQuery(Order.class);
		Root<Order> root = query.from(Order.class);
        query.select(root).where(builder.equal(root.get("customer"), customerId));
        
        Query<Order> q = session.createQuery(query);
        List<Order> o = (List<Order>) q.list();
        return o;	
        
		} catch (Exception e) {
		e.printStackTrace();
		return null;
	         
		}

		
//		List<Order> orders = new ArrayList<>();
//		Session s = sessionFactory.getCurrentSession();
//		orders= s.createQuery("from Orders where order.customerid = ").getResultList();
//		return orders;
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
