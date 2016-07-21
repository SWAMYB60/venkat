package com.niit.shoppingcartbackend.config;


import java.util.Properties;
import javax.sql.DataSource;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.niit.shoppingcartbackend.dao.CategoryDAO;
import com.niit.shoppingcartbackend.dao.CategoryDAOImpl;
import com.niit.shoppingcartbackend.dao.SupplierDAO;
import com.niit.shoppingcartbackend.dao.SupplierDAOImpl;
import com.niit.shoppingcartbackend.model.Category;
import com.niit.shoppingcartbackend.model.Supplier;


@Configuration
@ComponentScan("com.niit.shoppingcartbackend")
@EnableTransactionManagement

public class ApplicationContextConfig {
	
	@Bean(name = "dataSource")
	public DataSource getH2DataSource()
	{
		DriverManagerDataSource datasource=new DriverManagerDataSource();
		datasource.setDriverClassName("org.h2.Driver");
		datasource.setUrl("jdbc:h2:tcp://localhost/~/test");
		
		datasource.setUsername("sa");
		datasource.setPassword("sa");
		return datasource;
	}
	private Properties getHibernateProperties()
	{
		Properties properties=new Properties();
		properties.put("hibernate.show_sql","true");
		properties.put("hibernate.dialect","org.hibernate.dialect.H2Dialect");
		return properties;	
	}
	@Autowired
	@Bean(name="sessionfactory")
	public SessionFactory getSessionFactory(DataSource dataSource){
		LocalSessionFactoryBuilder sessionBuilder=new LocalSessionFactoryBuilder(dataSource);
		sessionBuilder.addProperties(getHibernateProperties());
		sessionBuilder.addAnnotatedClass(Category.class);
		sessionBuilder.addAnnotatedClass( Supplier.class);
		return sessionBuilder.buildSessionFactory();
	}
	@Autowired
	@Bean(name="transactionManager")
	public HibernateTransactionManager getTransactionManger(SessionFactory sessionFactory){
		HibernateTransactionManager transactionManager=new HibernateTransactionManager(sessionFactory);
		return transactionManager;
	}

	@Autowired
	@Bean(name="categoryDAO")
	public CategoryDAO getCategoryDAO(SessionFactory sessionFactory){
		return new CategoryDAOImpl(sessionFactory);
	}
		@Autowired
		@Bean(name="category")
		public Category getCategory(SessionFactory sessionFactory){
			return new Category();
		}
		@Autowired
		@Bean(name="supplierDAO")
		public SupplierDAO getSupplierDAO(SessionFactory sessionFactory){
			return new SupplierDAOImpl(sessionFactory);
		}
			@Autowired
			@Bean(name="supplier")
			public Supplier getSupplier(SessionFactory sessionFactory){
				return new Supplier();
			}
		
	}
	
		
		
	
	
	
	
	
	



