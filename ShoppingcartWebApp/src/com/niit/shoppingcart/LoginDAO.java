package com.niit.shoppingcart;

public class LoginDAO {
	public boolean isvalidUser(String User_ID,String Password)
	{
		if(User_ID.equals(Password))
		{
			return true;
		}
		else
		{
		return false;	
		}
	}
}