package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.UserClass;
import com.example.demo.model.WebToon;
import com.example.demo.model.WebToonReponse;
import com.example.demo.service.WebToonService;

import io.github.resilience4j.ratelimiter.annotation.RateLimiter;

@RestController
@RequestMapping("webtoons")
public class WebToonController {

	@Autowired
	WebToonService webService;
	
	@RateLimiter(name = "default")
	@GetMapping
	public ResponseEntity<List<WebToonReponse>> getallWebToon(){
		return new ResponseEntity<>(webService.getallWebtoon(),HttpStatus.OK);
	}
	
	@RateLimiter(name = "default")
	@PostMapping
	public ResponseEntity<WebToon> addWebToon(@RequestBody WebToon webToon){
		
		return new ResponseEntity<WebToon>(webService.addWebToon(webToon),HttpStatus.OK);
	}
	
	@RateLimiter(name = "default")
	@GetMapping("{id}")
	public ResponseEntity<WebToonReponse> getWebToon(@PathVariable int id){
		return new ResponseEntity<>(webService.getWebtoon(id),HttpStatus.OK);
	}
	
	@RateLimiter(name = "default")
	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteWebtoon(@PathVariable int id){
		return new ResponseEntity<String>(webService.deleteWebtoon(id),HttpStatus.OK);
	}
}
