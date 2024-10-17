package com.suhil.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.suhil.entity.User;
import com.suhil.service.UserService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/users")
public class UserRestController {
	
	@Autowired
	private UserService service;
	
	@PostMapping("/saveuser")
	public ResponseEntity<User> addUser( @Valid @RequestBody User user)
	
	{
		  User u = service.saveUser(user);
		  return new ResponseEntity<>(u,HttpStatus.CREATED);
	}
	
	@GetMapping("/fetchAll")
    public ResponseEntity<List<User>> fetchAllUsers(){
		List<User> allUsers = service.getAllUsers();
		return new ResponseEntity<>(allUsers,HttpStatus.OK);
        
    }
	
	@GetMapping("/fetch/{userId}")
	public ResponseEntity<User> fetchUser(@PathVariable Integer userId)
	{
		User u = service.getUserById(userId);
		return new ResponseEntity<>(u,HttpStatus.OK);
	}

}
