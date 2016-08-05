package com.niit.shoppingcart.controller;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.niit.shoppingcartbackend.model.Product;

import org.springframework.stereotype.Controller;

@Controller
public class HomeController {
	@RequestMapping("/")
	public ModelAndView display() {
		ModelAndView m1 = new ModelAndView("index");
		return m1;
	}

	@RequestMapping("/register")
	public ModelAndView register() {
		return new ModelAndView("register");

	}

	@RequestMapping("/login")
	public ModelAndView login() {

		ModelAndView m2 = new ModelAndView("login");
		return m2;

	}

	@RequestMapping("/venkat")
	public String display1() {

		return "index";

	}

	@RequestMapping("/addfurniture")
	public ModelAndView display2() {

		ModelAndView m3 = new ModelAndView("addfurniture");
		return m3;
	}

	@RequestMapping("/index")
	public ModelAndView display3() {

		ModelAndView m4 = new ModelAndView("index");
		return m4;
	}

	@ModelAttribute("Product")
	public Product addproduct() {
		return new Product();
	}

}
