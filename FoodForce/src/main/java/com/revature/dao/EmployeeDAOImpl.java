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
	public Employee createEmployee(Employee empl) {
		sessionFactory.getCurrentSession().saveOrUpdate(empl);
		return empl;
		
		
//		sessionFactory.getCurrentSession().persist(empl);
//		try {
//			Session session = sessionFactory.getCurrentSession();
//			CriteriaBuilder builder = session.getCriteriaBuilder();
//			CriteriaQuery<Credential> query = builder.createQuery(Credential.class);
//			Root<Credential> root = query.from(Credential.class);
//	        query.select(root).where(builder.and(builder.equal(root.get("username"), un), builder.equal(root.get("password"), pw)));
//	        
//	        //root.get("password"), pw)
//
//	        Query<Credential> q = session.createQuery(query);
//	        Credential cred = q.getSingleResult();
//	        return cred;	
//		} catch (Exception e) {
//	         
//	         return null;
	   }


	@Override
	public void updateEmployee(int id, Employee empl) {
		Session s = sessionFactory.getCurrentSession();
		Employee oldEmpl = s.byId(Employee.class).load(id);
		oldEmpl.setFirstName(empl.getFirstName());
		oldEmpl.setLastName(empl.getLastName());
		oldEmpl.setReportsTo(empl.getReportsTo());
	}

	@Override
	public void deleteEmployee(int id) {
		Session s = sessionFactory.getCurrentSession();
		Employee empl = s.byId(Employee.class).load(id);
		s.delete(empl);
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
