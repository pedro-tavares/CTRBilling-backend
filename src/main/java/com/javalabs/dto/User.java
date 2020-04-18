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
	private String first_name;
	@QueryParam("last_name")
	@Getter @Setter
	private String last_name;
	@QueryParam("email")
	@Getter @Setter
	private String email;
	@QueryParam("password")
	@Getter @Setter
	private String password;
	@QueryParam("roles")
	@Getter @Setter
	private String roles;
	@QueryParam("enabled")
	@Getter @Setter
	private boolean enabled;

	public User() {}

	public User(String first_name, String last_name, String email, String password) {
		this.first_name = first_name;
		this.last_name = last_name;
		this.email = email;
		this.password = password;
	}

}
