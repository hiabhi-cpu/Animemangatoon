package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.CharacterClass;
import com.example.demo.model.UserClass;
import com.example.demo.service.CharacterService;
import com.example.demo.service.JwtService;
import com.example.demo.service.MyUserDetailService;

import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import jakarta.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("character")
public class CharacterController {
	
	@Autowired
	CharacterService charService;
	
	@Autowired
	JwtService jwtService;
	
	@RateLimiter(name = "default")
	@GetMapping
	public ResponseEntity<List<CharacterClass>> getAllCharacters(){
		return new ResponseEntity<>(charService.getAllChracters(),HttpStatus.OK);
	}
	
	@RateLimiter(name = "default")
	@PostMapping("{id}")
	public ResponseEntity<CharacterClass> addCharacter(@RequestBody CharacterClass characterClass,@PathVariable int id){
		return new ResponseEntity<CharacterClass>(charService.addChar(characterClass,id),HttpStatus.OK);
	}
	
	@RateLimiter(name = "default")
	@GetMapping("{id}")
	public ResponseEntity<CharacterClass> getCharacter(@PathVariable int id){
		return new ResponseEntity<CharacterClass>(charService.getCharacters(id),HttpStatus.OK);
	}
	
	@RateLimiter(name = "default")
	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteChar(@PathVariable int id){
		return new ResponseEntity<String>(charService.deleteChar(id),HttpStatus.OK);
	}
	
}
