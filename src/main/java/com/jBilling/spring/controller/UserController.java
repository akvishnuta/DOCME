package com.jBilling.spring.controller;

import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.jBilling.spring.model.User;
import com.jBilling.spring.service.UserService;

@Controller
public class UserController {
	@Autowired
	UserService userService;
	
	@RequestMapping(value="/register",method=RequestMethod.POST)
	public ModelAndView addUser(@ModelAttribute("user") @Valid User user,BindingResult result) {
		ModelAndView model = new ModelAndView();
		model.setViewName("user/register");
		model.addObject(user);
		if(result.hasErrors()) {
			result.getAllErrors();
			return model;
			
		}
		this.userService.addUser(user);		
		return listUsers();
		
	}
	
	@RequestMapping(value="/user/list",method=RequestMethod.GET)
	public ModelAndView listUsers() {
		ModelAndView model = new ModelAndView();
		Map<String,Object> dataMap = new HashMap<>();
		dataMap.put("userList", this.userService.getUserList());
		model.addAllObjects(dataMap);
		model.setViewName("user/userList");
		return model;
	}
	

	@RequestMapping(value="/user/searchUser",method=RequestMethod.POST)
	public ModelAndView searchUser(@RequestBody String param) { 
		ModelAndView model = new ModelAndView("register","message","Hello!I'm here.");
		
		return model;
	}
}
