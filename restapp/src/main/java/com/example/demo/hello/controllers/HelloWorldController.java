package com.example.demo.hello.controllers;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.hello.models.HelloWorld;

@RestController
public class HelloWorldController {

	@Autowired
	private MessageSource messageSource;
	
	@GetMapping(path = "/hello-world")
	public String helloWorld() {
		return "Hello World";
	}
	
	@GetMapping(path = "/hello-world-bean")
	public HelloWorld helloWorldBean(@RequestHeader(name = "Accept-Language", required = false) Locale locale) {
		String message = messageSource.getMessage("teste", null, locale);
		return new HelloWorld(message);
	}
	
	@GetMapping(path = "/hello-world/path/{name}")
	public HelloWorld helloWorldPathVariable(@PathVariable String name) {
		return new HelloWorld(String.format("Isso é um teste - %s", name));
	}
}
