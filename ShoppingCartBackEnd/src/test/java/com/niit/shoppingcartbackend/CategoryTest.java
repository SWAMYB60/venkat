package com.niit.shoppingcartbackend;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.shoppingcartbackend.model.Category;
import com.niit.shoppingcartbackendmodel.CategoryDAO;

public class CategoryTest {
 
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();
		CategoryDAO categoryDAO = (CategoryDAO) context.getBean("categoryDAO");
		Category category = (Category) context.getBean("category");
		category.setId("101");
		category.setName("venkat");
		category.setDescription("good");

		categoryDAO.saveOrUpdate(category);

	}

}
