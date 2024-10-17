package com.suhil.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.suhil.entity.User;
import com.suhil.exception.UserNotFoundException;
import com.suhil.repo.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository repo;
	
	public User saveUser(User u)
	{
		 return repo.save(u);
	}
	
	public User getUserById(Integer uid) 
	{
		 Optional<User> id = repo.findById(uid);
		 if(id.isPresent())
		 {
			 return id.get();
		 }
		 else
		 {
			 throw new UserNotFoundException("user not found with id : "+uid);
		 }
	}
	
	public List<User> getAllUsers()
	{
		return   repo.findAll();
	}
	

	
}
