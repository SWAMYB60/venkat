 package com.niit.shoppingcartbackend;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.shoppingcartbackend.model.User;
import com.niit.shoppingcartbackendmodel.UserDAO;

public class UserTest {
 
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();
		UserDAO userDAO = (UserDAO) context.getBean("userDAO");
		User user = (User) context.getBean("user");
		user.setId("101");
		user.setName("venkat");
		user.setPassword("password");
		user.setEmail("email");

		

		userDAO.saveOrUpdate(user);

	}

}
