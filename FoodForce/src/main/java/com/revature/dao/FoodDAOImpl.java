package com.revature.dao;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;

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
		sessionFactory.getCurrentSession().get(Food.class, type);
		return null;
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
		System.out.println(oldFood.getDescription());
	}

	@Override
	public void deleteFood(int id) {
		Session s = sessionFactory.getCurrentSession();
		Food food = s.byId(Food.class).load(id);
		s.delete(food);
		
		
	}

}
