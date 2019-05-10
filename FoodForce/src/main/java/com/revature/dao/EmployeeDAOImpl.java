package com.revature.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.revature.entities.Credential;
import com.revature.entities.Employee;

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

	@Override
	public Employee getEmployeeByCredentialId(int id) {
		try {
			Session session = sessionFactory.getCurrentSession();
			CriteriaBuilder builder = session.getCriteriaBuilder();
			CriteriaQuery<Employee> query = builder.createQuery(Employee.class);
			Root<Employee> root = query.from(Employee.class);
	        query.select(root).where(builder.equal(root.get("credential.credentialid"), id));
	        
	        Query<Employee> q = session.createQuery(query);
	        Employee emp = q.getSingleResult();
	        return emp;	
	        
			} catch (Exception e) {
		         
		         return null;
			}
		}
}
