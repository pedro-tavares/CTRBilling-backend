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
	@QueryParam("name")
	@Getter @Setter
	private String name;
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

	public User(String name, String email, String password) {
		this.name = name;
		this.email = email;
		this.password = password;
	}

}
