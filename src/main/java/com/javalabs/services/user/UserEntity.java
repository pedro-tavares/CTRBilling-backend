package com.javalabs.services.user;

import lombok.Getter;
import lombok.Setter;

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
	@Getter @Setter
	private Long id;

	@Getter @Setter
	private String first_name;
	@Getter @Setter
	private String last_name;
	@Getter @Setter
	private String email;
	@Getter @Setter
	private String password;
	@Getter @Setter
	private String roles;
	@Getter @Setter
	private boolean enabled;

	public UserEntity() {}

	public UserEntity(User user) {
		this.first_name = user.getFirst_name();
		this.last_name = user.getLast_name();
		this.email = user.getEmail();
		this.password = user.getPassword();
	}

}
