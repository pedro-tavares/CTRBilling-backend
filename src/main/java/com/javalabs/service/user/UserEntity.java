package com.javalabs.service.user;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.javalabs.dto.User;

@Entity
@Table(name = "person")
public class UserEntity {

	@Id
	@GeneratedValue
	private Long id;
	private String firstName;
	private String lastName;
	private String email;
	private String thePassword;
	private String roles;
	private boolean enabled;

	public UserEntity() {}

	public UserEntity(User user) {
		this.firstName = user.getFirstName();
		this.lastName = user.getLastName();
		this.email = user.getEmail();
		this.thePassword = user.getPassword();
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

	public String getThePassword() {
		return thePassword;
	}

	public void setThePassword(String thePassword) {
		this.thePassword = thePassword;
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
