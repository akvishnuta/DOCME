package com.jBilling.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jBilling.spring.biz.PasswordHasher;
import com.jBilling.spring.dao.UserDao;
import com.jBilling.spring.model.User;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	UserDao userDao;
//	public void setUserDao(UserDao userDao) {
//		this.userDao = userDao;
//	}
	@Override
	@Transactional
	public void addUser(User user) {
		String salt=null;
		PasswordHasher hasher = new PasswordHasher();
		String password = user.getPassword();
		password = hasher.hashPassword(password);
		salt = hasher.getSalt();
		user.setPassword(password);
		user.setSalt(salt);
		userDao.addUser(user);
	}
	@Override
	@Transactional
	public List<User> getUserList() {
		return userDao.getUserList();
	}

}
