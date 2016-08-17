package com.niit.shoppingcartbackendmodel;
import java.util.List;

import org.hibernate.Criteria;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


import com.niit.shoppingcartbackend.model.UserDetails;

@Repository("userDAO")
public  class UserDAOImpl implements UserDAO 
{
	@Autowired
	private SessionFactory sessionFactory;

	 public UserDAOImpl(SessionFactory sessionFactory){
		this.sessionFactory=sessionFactory;
}
	@Transactional
	public List<UserDetails> list(){
		@SuppressWarnings("unchecked")
		List<UserDetails> listuserDetails=(List<UserDetails>)
		sessionFactory.getCurrentSession().createCriteria(UserDetails.class).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		return listuserDetails;
	}
	@Transactional
	public void saveOrUpdate(UserDetails  userDetails){
		sessionFactory.getCurrentSession().saveOrUpdate(userDetails);
	}
	@Transactional
	public void delete(int id){
		UserDetails userDetails= new UserDetails();
		userDetails.setId(id);
		sessionFactory.getCurrentSession().delete(userDetails);
	}
	@SuppressWarnings("unchecked")
	@Transactional
public UserDetails get(int id)
	{
		String hql="from user where id="+"'"+id+"'";
		Query query=(Query) sessionFactory.getCurrentSession().createQuery(hql);
		List<UserDetails> listuserDetails= (List<UserDetails>) query.getResultList();
		if(listuserDetails!=null && ! listuserDetails.isEmpty()){
			return listuserDetails.get(0);
		}
	return null;
	}
	@Transactional
	public boolean isValidUser(String id,String password){
		String hq1="from user where id='"+id+"'and password'"+password+"'";
		Query query=sessionFactory.getCurrentSession().createQuery(hq1);
		List list=query.list();
		if(list==null||list.isEmpty())
				{
			return false;
				}
		else
		{
			 return true;
		}
	
	 


	 
	
}
}
 