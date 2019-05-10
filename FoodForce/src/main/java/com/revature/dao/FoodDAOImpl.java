package com.revature.dao;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.revature.entities.Food;

@Repository(value = "FoodDAO")
@Transactional
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
	public void updateFood(Food food) {
		sessionFactory.getCurrentSession().saveOrUpdate(food);
	}

	@Override
	public void deleteFood(Food food) {
		sessionFactory.getCurrentSession().saveOrUpdate(food);
		
	}

}
