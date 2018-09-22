package com.jBilling.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.jBilling.spring.model.User;

@Controller
public class HomeController {
	@RequestMapping(value="/register",method=RequestMethod.GET)
	public String registerUser(Model model) {
		model.addAttribute("user",new User());
		return "user/register";
	}
	
	@RequestMapping(value="/login",method=RequestMethod.GET)
	public String loginUser() {
		return "user/login";
	}
}
