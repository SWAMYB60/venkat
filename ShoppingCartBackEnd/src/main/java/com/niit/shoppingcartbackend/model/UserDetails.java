package com.niit.shoppingcartbackend.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.stereotype.Component;

@Entity
@Table(name = "UserDetails")
@Component
public class UserDetails {

	 @Id
	 @GeneratedValue(strategy=GenerationType.AUTO)
	 @Column(name="id")
    private int id;	
	 
	 @NotNull
	 @Size(min=2,max=30,message="Name Must be more than 2 letters")
	 @Column(name="username")
    private String username;
	 
	 @NotNull
	 @Size(min=2,max=30)
	@Column(name = "email")
	private String email ;
	 @NotNull
	 @Size(min=2,max=30,message="Address at least more than 3 Characters")
	 @Column(name="address")	
	private String address;
		@NotNull
		 @Size(min=2,max=30)
		 @Column(name="password")
	 
		private String password;
		@NotNull
		 @Size(min=2,max=30)
		 @Column(name="confirmpassword")
	 
		private String confirmpassword;
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getUsername() {
			return username;
		}
		public void setUsername(String username) {
			this.username = username;
		}
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		public String getAddress() {
			return address;
		}
		public void setAddress(String address) {
			this.address = address;
		}
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}
		public String getConfirmpassword() {
			return confirmpassword;
		}
		public void setConfirmpassword(String confirmpassword) {
			this.confirmpassword = confirmpassword;
		}
	
	


	
}



	 

	 	