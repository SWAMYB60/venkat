package com.niit.shoppingcartbackend.dao;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.shoppingcartbackend.model.Supplier;

@Repository("supplierDAO")
public  class SupplierDAOImpl implements SupplierDAO 
{
	@Autowired
	private SessionFactory sessionFactory;

	 public SupplierDAOImpl(SessionFactory sessionFactory){
		this.sessionFactory=sessionFactory;
}
	@Transactional
	public List<Supplier> list(){
		@SuppressWarnings("unchecked")
		List<Supplier> listsupplier=(List<Supplier>)
		sessionFactory.getCurrentSession().createCriteria(Supplier.class).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		return listsupplier;
	}
	@Transactional
	public void saveOrUpdate(Supplier  supplier){
		sessionFactory.getCurrentSession().saveOrUpdate(supplier);
	}
	@Transactional
	public void delete(String id){
		Supplier supplier= new Supplier();
		supplier.setId(id);
		sessionFactory.getCurrentSession().delete(supplier);
	}
	@SuppressWarnings("unchecked")
	@Transactional
public Supplier get(String id)
	{
		String hql="from supplier where id="+"'"+id+"'";
		Query query=(Query) sessionFactory.getCurrentSession().createQuery(hql);
		List<Supplier> listsupplier= (List<Supplier>) query.getResultList();
		if(listsupplier!=null && ! listsupplier.isEmpty()){
			return listsupplier.get(0);
		}
	return null;
	}
}
 