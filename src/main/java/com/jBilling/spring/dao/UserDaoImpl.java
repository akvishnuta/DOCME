package com.jBilling.spring.dao;

import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jBilling.spring.model.User;

@Repository
public class UserDaoImpl implements UserDao{
	private final static Logger logger = LoggerFactory.getLogger(UserDaoImpl.class);
	@Autowired
	SessionFactory sessionFactory;
	
	@Override
	public void addUser(User user) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(user);	
		logger.info("User saved successfully, User => "+user);
		
	}

	@Override
	public List<User> getUserList() {
		Session session = this.sessionFactory.getCurrentSession();
		String hql = "FROM User";
		TypedQuery<User> query = session.createQuery(hql,User.class);
		List<User> userList = query.getResultList();
		//session.close();
		return userList;
	}

}
