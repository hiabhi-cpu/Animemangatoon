package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.UserClass;
import com.example.demo.service.JwtService;
import com.example.demo.service.UserService;

import io.github.resilience4j.ratelimiter.annotation.RateLimiter;

@CrossOrigin
@RestController
@RequestMapping("user")
public class UserController {
	@Autowired
	UserService userService;
	
	@Autowired
	JwtService jwtService;
	
	@Autowired
	AuthenticationManager authenticationManager;
	
	@RateLimiter(name = "default")
	@PostMapping("add")
	public UserClass register(@RequestBody UserClass user) {
		return userService.saveUser(user);
	}
	
	@RateLimiter(name = "default")
	@PostMapping("login")
	public String login(@RequestBody UserClass user) {
		Authentication authentication=authenticationManager
				.authenticate(new UsernamePasswordAuthenticationToken(user.getUserName(), user.getUserPassword()));
		return authentication.isAuthenticated() ? jwtService.generateToken(user.getUserName()):"Failed";
	}
}
