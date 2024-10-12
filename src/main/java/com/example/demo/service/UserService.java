package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.model.UserClass;
import com.example.demo.repository.UserRepo;

@Service
public class UserService {
	
	@Autowired
	private UserRepo repo;
	BCryptPasswordEncoder encoder=new BCryptPasswordEncoder(12);

	public UserClass saveUser(UserClass user) {
		// TODO Auto-generated method stub
		user.setUserPassword(encoder.encode(user.getUserPassword()));
		System.out.println(user.getUserPassword());
		return repo.save(user);
	}
	
	
	
}