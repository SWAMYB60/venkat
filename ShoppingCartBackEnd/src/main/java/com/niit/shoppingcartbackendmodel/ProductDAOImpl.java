package com.niit.shoppingcartbackendmodel;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.shoppingcartbackend.model.Product;

@Repository("productDAO")
public  class ProductDAOImpl implements ProductDAO 
{
	@Autowired
	private SessionFactory sessionFactory;

	 public ProductDAOImpl(SessionFactory sessionFactory){
		this.sessionFactory=sessionFactory;
}
	@Transactional
	public List<Product> list(){
		@SuppressWarnings("unchecked")
		List<Product> listproduct=(List<Product>)
		sessionFactory.getCurrentSession().createCriteria(Product.class).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		return listproduct;
	}
	@Transactional
	public Product get(int id)
		{
			String hql="from Product where id="+"'"+id+"'";
			Query query= sessionFactory.getCurrentSession().createQuery(hql);
			List<Product> listproduct= (List<Product>) query.list();
			if(listproduct!=null ||
					! listproduct.isEmpty()){
				return listproduct.get(0);
			}
		return null;
		
		}
	@Transactional
	public void saveOrUpdate(Product  product){
		sessionFactory.getCurrentSession().saveOrUpdate(product);
	}
	@Transactional
	public void delete(int id){
		Product productToDelete= new Product();
		productToDelete.setId(id);
		sessionFactory.getCurrentSession().delete(productToDelete);
	}
	@SuppressWarnings("unchecked")
	

@Transactional
public List<Product>List() {
	/*@SuppressWarnings("unchecked")
	List<Product> listProduct =(List<Product>)
	sessionFactory.getCurrentSession().createCriteria(Product.class).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
	
	return listProduct;*/
Session session=sessionFactory.openSession();
List<Product> list=session.createQuery("from Product").list();
session.close();
return list;
}
	@Transactional


	public List getAllProducts() {
		// TODO Auto-generated method stub
		Session session=sessionFactory.openSession();
		List list=session.createQuery("from Product").list();
		session.close();
		return list;
		}


@Transactional

public int deleteProduct(int id) {
	// TODO Auto-generated method stub
	Session session=sessionFactory.openSession();
	org.hibernate.Transaction tx=session.beginTransaction();
	Product product=(Product)session.load(Product.class, id);
	session.delete(product);
	tx.commit();
	
	session.close();
	return id;
}

 
 


}
