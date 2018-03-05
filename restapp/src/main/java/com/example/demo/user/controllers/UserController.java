package com.example.demo.user.controllers;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.demo.user.models.User;
import com.example.demo.user.services.UserService;

@RestController
public class UserController {

	@Autowired
	private UserService service;
	
	@GetMapping(path = "/user/{id}")
	public Resource<User> find(@PathVariable int id) throws Exception {
		
		User user = this.service.find(id);
		
		Resource<User> resource = new Resource<User>(user);
		ControllerLinkBuilder link = linkTo(methodOn(this.getClass()).all());
		resource.add(link.withRel("all-users"));
		
		return resource;
	}
	
	@GetMapping(path = "/user")
	public List<User> all() {
		return this.service.all();
	}
	
	@PostMapping(path = "/user")
	public ResponseEntity<Object> save(@Valid @RequestBody User user) {
		
		User newUser = this.service.save(user);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
								   .path("/{id}")
								   .buildAndExpand(newUser.getId())
								   .toUri();
		
		return ResponseEntity.created(uri).build();
	}
	
	@DeleteMapping(path = "/user/{id}")
	public void delete(@PathVariable int id) throws Exception {
		User user = this.service.find(id);
		this.service.delete(user);
	}
}
