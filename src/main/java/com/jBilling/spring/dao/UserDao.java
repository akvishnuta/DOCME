package com.jBilling.spring.dao;

import java.util.List;

import com.jBilling.spring.model.User;

public interface UserDao {
	public void addUser(User user);
	public List<User> getUserList();
}
