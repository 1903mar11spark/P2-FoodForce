package com.revature.dao;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;
import org.hibernate.Transaction;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.revature.beans.Employee;

@Repository
@Transactional
public class EmployeeDAOImpl implements EmployeeDAO {

private SessionFactory sessionFactory;
	
	@Autowired // Constructor injection
	public EmployeeDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
//	public Employee getEmployeeById(int id) {
//		Session currentSession = sessionFactory.getCurrentSession();
//        Employee emp = currentSession.get(Employee.class, id);
//        return emp;
//	}
	
	
	@Override
	public List<Employee> allEmployees() {
		List<Employee> emp = new ArrayList<>();
		try (Session s = sessionFactory.getCurrentSession()) {
			Transaction tx = s.beginTransaction();
			emp = s.createQuery("from Author").getResultList();
			tx.commit();
		}
		return emp;
	}
}
