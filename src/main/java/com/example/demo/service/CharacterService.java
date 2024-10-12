package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.example.demo.model.CharacterClass;
import com.example.demo.model.UserClass;
import com.example.demo.model.WebToon;
import com.example.demo.repository.CharacterRepo;
import com.example.demo.repository.UserRepo;
import com.example.demo.repository.WebToonRepo;

@Service
public class CharacterService {

	@Autowired
	CharacterRepo charRepo;
	
	@Autowired
	WebToonRepo webRepo;
	
	@Autowired
	UserRepo userRepo;

	public CharacterClass addChar(CharacterClass characterClass, int id) {
		// TODO Auto-generated method stub
		Optional<WebToon> temp=webRepo.findById(id);
		if(temp.isEmpty()) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
		if(temp.get().getUid().getUid()!=getUserClass().getUid()) {
			throw new ResponseStatusException(HttpStatus.UNAUTHORIZED);
		}
		characterClass.setWebToon(temp.get());
		return charRepo.save(characterClass);
	}

	public List<CharacterClass> getAllChracters() {
		// TODO Auto-generated method stub
		return charRepo.findAll();
	}

	public CharacterClass getCharacters(int id) {
		// TODO Auto-generated method stub
		Optional<CharacterClass> temp=charRepo.findById(id);
		if(temp.isEmpty()) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
		return temp.get();
	}

	public String deleteChar(int id) {
		// TODO Auto-generated method stub
		Optional<CharacterClass> temp=charRepo.findById(id);
		if(temp.isEmpty()) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
		if(temp.get().getWebToon().getUid().getUid()!=getUserClass().getUid()) {
			throw new ResponseStatusException(HttpStatus.UNAUTHORIZED);
		}
		charRepo.deleteById(id);
		return "Deleted";
	}

	public UserClass getUserClass() {
		UserClass user=userRepo.findByUserName(SecurityContextHolder.getContext().getAuthentication().getName());
		return user;
	}
}
