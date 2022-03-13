package com.user.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.user.model.User;
import com.user.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService service;

	@PostMapping(path = "/add")
	public ResponseEntity<User> createUser(@RequestBody @Valid User user) {
		return new ResponseEntity<User>(service.addUser(user), HttpStatus.CREATED);
	}

	@GetMapping(path = "/getuser/{id}")
	public ResponseEntity<User> getUser(@PathVariable(name = "id") Long id) {
		return new ResponseEntity<User>(service.getUserWithId(id), HttpStatus.FOUND);
	}

	@GetMapping(path = "/allusers")
	public List<User> getAllUsers() {
		return service.getAllUsers();
	}

	@PutMapping(path = "/update/{id}")
	public ResponseEntity<User> updateUser(@RequestBody @Valid User user, @PathVariable(name = "id") Long id) {
		return new ResponseEntity<User>(service.updateUser(user, id), HttpStatus.OK);
	}

}
