package com.niit.shoppingcartbackend;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.shoppingcartbackend.model.Supplier;
import com.niit.shoppingcartbackendmodel.SupplierDAO;

public class SupplierTest {
	public static void main(String[]args){
		AnnotationConfigApplicationContext context= new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();
		SupplierDAO supplierDAO=(SupplierDAO) context.getBean("supplierDAO");
		Supplier supplier=(Supplier) context.getBean("supplier");
		supplier.setId("sc001");
		supplier.setName("scname356");
		supplier.setAddress("address");
		
		supplierDAO.saveOrUpdate(supplier);
		
		
		
		
				
		
	}

}
