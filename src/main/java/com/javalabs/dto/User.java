package com.javalabs.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

import javax.ws.rs.QueryParam;

public class User implements Serializable {

	private static final long serialVersionUID = 1L;

	@QueryParam("id")
	@Getter @Setter
	private Long id;
	@QueryParam("first_name")
	@Getter @Setter
	private String firstName;
	@QueryParam("last_name")
	@Getter @Setter
	private String lastName;
	@QueryParam("email")
	@Getter @Setter
	private String email;
	@QueryParam("the_password")
	@Getter @Setter
	private String thePassword;
	@QueryParam("roles")
	@Getter @Setter
	private String roles;
	@QueryParam("enabled")
	@Getter @Setter
	private boolean enabled;

	public User() {}

	public User(String firstName, String lastName, String email, String thePassword) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.thePassword = thePassword;
	}

}
