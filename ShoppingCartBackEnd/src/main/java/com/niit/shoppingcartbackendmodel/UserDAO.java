package com.niit.shoppingcartbackendmodel;

import java.util.List;

import com.niit.shoppingcartbackend.model.UserDetails;

public interface UserDAO {

	public List<UserDetails> list();

	public UserDetails get(int id);

	public void saveOrUpdate(UserDetails userDetails);

	public void delete(int id);

}
