package com.example.demo.user.repositories;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.user.models.User;

public interface UserRepository extends CrudRepository<User, Integer> {

}
