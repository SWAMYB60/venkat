 package com.niit.shoppingcart.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.stereotype.Controller;

@Controller
public class HomeController {
@RequestMapping("/")
public ModelAndView display()
{
	ModelAndView m1= new ModelAndView("index");
	return m1;
}
@RequestMapping("/register")
public ModelAndView register() {
	return new ModelAndView ("register");
	
}

@RequestMapping("/login")
public ModelAndView login() {

	
	ModelAndView mv=new ModelAndView("login");
	return mv;
}
	
}
