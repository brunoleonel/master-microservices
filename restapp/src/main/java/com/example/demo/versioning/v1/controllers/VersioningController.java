package com.example.demo.versioning.v1.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.versioning.v1.models.Person;

@RestController
@RequestMapping(path = "/v1")
public class VersioningController {

	@GetMapping(path = "/person")
	public Person getPerson() {
		return new Person("João");
	}
}
