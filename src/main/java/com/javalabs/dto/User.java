package com.javalabs.dto;

import java.io.Serializable;

import javax.ws.rs.QueryParam;

public class User implements Serializable {

	private static final long serialVersionUID = 1L;

	@QueryParam("id")
	private Long id;
	@QueryParam("first_name")
	private String firstName;
	@QueryParam("last_name")
	private String lastName;
	@QueryParam("email")
	private String email;
	@QueryParam("password")
	private String password;
	@QueryParam("roles")
	private String roles;
	@QueryParam("enabled")
	private boolean enabled;

	public User() {}

	public User(String firstName, String lastName, String email, String password) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRoles() {
		return roles;
	}

	public void setRoles(String roles) {
		this.roles = roles;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
	
}
