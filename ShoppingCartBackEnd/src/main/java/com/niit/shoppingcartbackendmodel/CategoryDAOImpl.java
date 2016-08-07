package com.niit.shoppingcartbackendmodel;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.shoppingcartbackend.model.Category;

@Repository("categoryDAO")
public  class CategoryDAOImpl implements CategoryDAO 
{
	@Autowired
	private SessionFactory sessionFactory;

	 public CategoryDAOImpl(SessionFactory sessionFactory){
		this.sessionFactory=sessionFactory;
}
	@Transactional
	public List<Category> list(){
		@SuppressWarnings("unchecked")
		List<Category> listcategory=(List<Category>)
		sessionFactory.getCurrentSession().createCriteria(Category.class).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		return listcategory;
	}
	@Transactional
	public void saveOrUpdate(Category  category){
		sessionFactory.getCurrentSession().saveOrUpdate(category);
	}
	@Transactional
	public void delete(String id){
		Category category= new Category();
		category.setId(id);
		sessionFactory.getCurrentSession().delete(category);
	}
	@SuppressWarnings("unchecked")
	@Transactional
public Category get(String id)
	{
		String hql="from category where id="+"'"+id+"'";
		Query query=(Query) sessionFactory.getCurrentSession().createQuery(hql);
		List<Category> listcategory= (List<Category>) query.getResultList();
		if(listcategory!=null && ! listcategory.isEmpty()){
			return listcategory.get(0);
		}
	return null;
	}
	public boolean isValidUser(String name, String password) {
		// TODO Auto-generated method stub
		return false;
	}

	}

 