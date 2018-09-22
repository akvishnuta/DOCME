package com.jBilling.spring.service;

import java.util.List;

import com.jBilling.spring.model.User;

public interface UserService {
	public void addUser(User user);
	public List<User> getUserList();
}
