package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.demo.model.UserClass;
import com.example.demo.model.UserPrincipal;
import com.example.demo.repository.UserRepo;

@Service
public class MyUserDetailService implements UserDetailsService{

	@Autowired
	UserRepo repo;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		UserClass user=repo.findByUserName(username);
		if(user==null) {
			System.out.println("User not found \n *******************************");
			throw new UsernameNotFoundException("User not found");
		}
		return new UserPrincipal(user);
	}

}
