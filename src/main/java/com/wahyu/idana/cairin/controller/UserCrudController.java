package com.wahyu.idana.cairin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.wahyu.idana.cairin.model.Users;
import com.wahyu.idana.cairin.repository.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.List;
import java.util.Optional;

@CrossOrigin()
@RestController
@RequestMapping({ "/users" })
public class UserCrudController {

	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	@Autowired
	private UserRepository userRepository;

	@GetMapping(produces = "application/json")
	public List<Users> firstPage() {
		return (List<Users>) userRepository.findAll();
	}

	@GetMapping(path = { "/{id}" }, produces = "application/json")
	public Optional<Users> byId(@PathVariable("id") int id) {
		return (Optional<Users>) userRepository.findById(id);
	}

	@DeleteMapping(path = { "/{id}" })
	public Users delete(@PathVariable("id") int id) {
		Users deletedEmp = null;
		
		return deletedEmp;
	}

	@PostMapping
	public Users create(@RequestBody Users user) {
		String encodedPassword = bCryptPasswordEncoder.encode(user.getPassword());
		user.setPassword(encodedPassword);
		userRepository.save(user);
		return user;
	}
}