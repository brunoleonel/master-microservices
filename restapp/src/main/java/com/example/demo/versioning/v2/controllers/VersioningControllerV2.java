package com.example.demo.versioning.v2.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.versioning.v2.models.Person;

@RestController
@RequestMapping(path = "/v2")
public class VersioningControllerV2 {

	@GetMapping(path = "/person")
	public Person getPerson() {
		return new Person("João", "Antônio");
	}
}
