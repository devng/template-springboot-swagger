package com.devng.template.springboot.jpa.domain;

import java.util.Date;

import javax.persistence.Entity;

@Entity
public class User extends AbstractPersistable {

	private String firstName;

	private String lastName;

	private String email;

	private Date birthday;

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getEmail() {
		return email;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
}
