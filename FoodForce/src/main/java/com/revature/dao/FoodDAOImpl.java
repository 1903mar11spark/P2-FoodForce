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

import com.revature.entities.Customer;
import com.revature.entities.Employee;
import com.revature.entities.Food;

@Repository(value = "FoodDAO")
@Transactional
@EnableTransactionManagement(proxyTargetClass = true)
public class FoodDAOImpl implements FoodDAO {

	private SessionFactory sessionFactory;
	
	@Autowired
	public FoodDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	@Override
	public void createFood(Food food) {
		sessionFactory.getCurrentSession().persist(food);
	}

	@Override
	public Food getFoodByType(String type) {
		try {
			Session session = sessionFactory.getCurrentSession();
			CriteriaBuilder builder = session.getCriteriaBuilder();
			CriteriaQuery<Food> query = builder.createQuery(Food.class);
			Root<Food> root = query.from(Food.class);
	        query.select(root).where(builder.equal(root.get("type"), type));
	        
	        Query<Food> q = session.createQuery(query);
	        Food f = q.getSingleResult();
	        return f;	
	        
			} catch (Exception e) {
		         
		         return null;
			}
	}
	


	@SuppressWarnings("unchecked")
	@Override
	public List<Food> getAllFood() {
		List<Food> food = new ArrayList<>();
		Session s = sessionFactory.getCurrentSession();
		food = s.createQuery("from Food").getResultList();
		return food;
	}

	@Override
	public void updateFood(int id, Food food) {
		Session s = sessionFactory.getCurrentSession();
		Food oldFood = s.byId(Food.class).load(id);
		oldFood.setDescription(food.getDescription());
		oldFood.setName(food.getName());
		oldFood.setType(food.getType());
		
	}

	@Override
	public void deleteFood(int id) {
		Session s = sessionFactory.getCurrentSession();
		Food food = s.byId(Food.class).load(id);
		s.delete(food);
		
		
	}

	@Override
	public Food getFoodById(int id) {
		return sessionFactory.getCurrentSession().byId(Food.class).load(id);

	}

}
