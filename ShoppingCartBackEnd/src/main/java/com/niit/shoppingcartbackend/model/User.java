package com.niit.shoppingcartbackend.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table(name="user")
@Component

public class User {
	@Id
	private String id;
	private String name;
	private String password;
	private String email;
	public byte admin;
	@Column(name="admin",columnDefinition="tinyinit default 0")
	public byte getAdmin() {
		return admin;
	}
	public void setAdmin(byte admin) {
		this.admin = admin;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
}
	 