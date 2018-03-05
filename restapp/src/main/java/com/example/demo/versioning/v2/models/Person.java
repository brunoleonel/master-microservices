package com.example.demo.versioning.v2.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Person {

	@JsonProperty(value = "first_name")
	private String firstName;
	
	@JsonProperty(value = "last_name")
	private String lastName;

	public Person(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
	}
	
	public Person() {
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String name) {
		this.firstName = name;
	}
	
	public String getLastName() {
		return lastName;
	}

	public void setLastName(String name) {
		this.lastName = name;
	}
}
