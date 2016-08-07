package com.niit.shoppingcartbackendmodel;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.shoppingcartbackend.model.User;

@Repository("userDAO")
public  class UserDAOImpl implements UserDAO 
{
	@Autowired
	private SessionFactory sessionFactory;

	 public UserDAOImpl(SessionFactory sessionFactory){
		this.sessionFactory=sessionFactory;
}
	@Transactional
	public List<User> list(){
		@SuppressWarnings("unchecked")
		List<User> listuser=(List<User>)
		sessionFactory.getCurrentSession().createCriteria(User.class).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		return listuser;
	}
	@Transactional
	public void saveOrUpdate(User  user){
		sessionFactory.getCurrentSession().saveOrUpdate(user);
	}
	@Transactional
	public void delete(String id){
		User user= new User();
		user.setId(id);
		sessionFactory.getCurrentSession().delete(user);
	}
	@SuppressWarnings("unchecked")
	@Transactional
public User get(String id)
	{
		String hql="from user where id="+"'"+id+"'";
		Query query=(Query) sessionFactory.getCurrentSession().createQuery(hql);
		List<User> listuser= (List<User>) query.getResultList();
		if(listuser!=null && ! listuser.isEmpty()){
			return listuser.get(0);
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
 