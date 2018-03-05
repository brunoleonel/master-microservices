package com.example.demo.user.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.exceptions.DataNotFoundException;
import com.example.demo.user.models.User;
import com.example.demo.user.repositories.UserRepository;
import com.google.common.collect.Lists;

@Service
public class UserService {

	@Autowired
	private UserRepository repository;
	
	public User find(int id) throws DataNotFoundException {
		
		User user = this.repository.findById(id).orElse(null);
		
		if (user != null)
			return user;
		
		throw new DataNotFoundException("Usuário não encontrado.");
	}
	
	public List<User> all() {	
		return Lists.newArrayList(this.repository.findAll());
	}
	
	public User save(User user) {
		return this.repository.save(user);
	}
	
	public void delete(User user) {
		this.repository.delete(user);
	}
}
