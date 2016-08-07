package com.niit.shoppingcartbackendmodel;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
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
	public void saveOrUpdate(Product  product){
		sessionFactory.getCurrentSession().saveOrUpdate(product);
	}
	@Transactional
	public void delete(int id){
		Product product= new Product();
		product.setId(id);
		sessionFactory.getCurrentSession().delete(product);
	}
	@SuppressWarnings("unchecked")
	@Transactional
public Product get(int id)
	{
		String hql="from product where id="+"'"+id+"'";
		Query query=(Query) sessionFactory.getCurrentSession().createQuery(hql);
		List<Product> listproduct= (List<Product>) query.getResultList();
		if(listproduct!=null && ! listproduct.isEmpty()){
			return listproduct.get(0);
		}
	return null;
	
	}
}
 