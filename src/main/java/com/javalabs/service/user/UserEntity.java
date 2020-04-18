package com.javalabs.service.user;

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
	private String firstName;
	@Getter @Setter
	private String lastName;
	@Getter @Setter
	private String email;
	@Getter @Setter
	private String thePassword;
	@Getter @Setter
	private String roles;
	@Getter @Setter
	private boolean enabled;

	public UserEntity() {}

	public UserEntity(User user) {
		this.firstName = user.getFirstName();
		this.lastName = user.getLastName();
		this.email = user.getEmail();
		this.thePassword = user.getPassword();
	}

}
