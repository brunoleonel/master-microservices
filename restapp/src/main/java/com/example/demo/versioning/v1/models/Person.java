package com.example.demo.versioning.v1.models;

public class Person {

	private String name;

	public Person(String name) {
		this.name = name;
	}
	
	public Person() {
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
