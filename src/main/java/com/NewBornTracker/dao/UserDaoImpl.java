package com.NewBornTracker.dao;


import org.hibernate.query.Query;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.NewBornTracker.model.User;

@Repository
@Transactional
public class UserDaoImpl implements UserDao{
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public User findById(Long id) {
		CriteriaBuilder builder = sessionFactory.getCurrentSession().getCriteriaBuilder();
		CriteriaQuery<User> query = builder.createQuery(User.class);
		Root<User> root = query.from(User.class);
		query.select(root).where(builder.equal(root.get("Id"), id));
		Query<User> q = sessionFactory.getCurrentSession().createQuery(query);
		User user = q.getSingleResult();
		return user;
	}

	@Override
	public User save(User user) {
		sessionFactory.getCurrentSession().save(user);
		User u = sessionFactory.getCurrentSession().get(User.class, user.getId());
		if(u != null) {
			return u;
		}
		return null;
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
	}

	@Override
	public User findByUsername(String name) {
		Query<User> q = sessionFactory.getCurrentSession().createQuery("from User u where u.userName = :username");
		q.setParameter("username", name);
		
		User u = (User) q.uniqueResult();
		
		if (u != null) {
			return u;
		}
		return null;
	}

}
