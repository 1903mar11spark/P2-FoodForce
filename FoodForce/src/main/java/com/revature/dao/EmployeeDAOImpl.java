package com.revature.dao;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.revature.beans.Employee;

@Repository
@Transactional
@EnableTransactionManagement(proxyTargetClass = true)
public class EmployeeDAOImpl implements EmployeeDAO {

	private SessionFactory sessionFactory;
	
	@Autowired // Constructor injection
	public EmployeeDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	@Override
	public Employee getEmployeeById(int id) {
		Session currentSession = sessionFactory.getCurrentSession();
        Employee emp = currentSession.get(Employee.class, id);
        return emp;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Employee> allEmployees() {
		List<Employee> emp = new ArrayList<>();
		Session s = sessionFactory.getCurrentSession();
		emp = s.createQuery("from Employee").getResultList();
		return emp;
	}

	@Override
	public void createEmployee(Employee empl) {
		sessionFactory.getCurrentSession().persist(empl);
		
	}

	@Override
	public void updateEmployee(Employee empl) {
		sessionFactory.getCurrentSession().saveOrUpdate(empl);
		
	}

	@Override
	public void deleteEmployee(Employee empl) {
		sessionFactory.getCurrentSession().delete(empl);
	}
}
