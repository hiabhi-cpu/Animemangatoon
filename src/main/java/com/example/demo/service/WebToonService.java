package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.example.demo.model.CharacterClass;
import com.example.demo.model.CharacterResponse;
import com.example.demo.model.UserClass;
import com.example.demo.model.WebToon;
import com.example.demo.model.WebToonReponse;
import com.example.demo.repository.UserRepo;
import com.example.demo.repository.WebToonRepo;

@Service
public class WebToonService {

	@Autowired
	UserRepo userRepo;
	
	@Autowired
	WebToonRepo webrepo;

	public WebToon addWebToon(WebToon webToon) {
		// TODO Auto-generated method stub
//		UserClass user=userRepo.findByUserName(SecurityContextHolder.getContext().getAuthentication().getName());
		webToon.setUid(getUserClass());
		return webrepo.save(webToon);
	}

	public List<WebToonReponse> getallWebtoon() {
		// TODO Auto-generated method stub
		List<WebToonReponse> response=new ArrayList<>();
		for(WebToon w:webrepo.findAll()) {
			response.add(getResponse(w));
		}
		return response;
	}
	
	private WebToonReponse getResponse(WebToon w) {
		List<CharacterResponse> charList=new ArrayList<>();
		for(CharacterClass c:w.getCharacters()) {
			charList.add(new CharacterResponse(c));
		}
		return new WebToonReponse(w,charList);
	}
	
	

	public WebToonReponse getWebtoon(int id) {
		// TODO Auto-generated method stub
		Optional<WebToon> res=webrepo.findById(id);
		if(res.isEmpty()) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
		return getResponse(res.get());
	}

	public String deleteWebtoon(int id) {
		// TODO Auto-generated method stub
		if(webrepo.findById(id).get().getUid().getUid()==getUserClass().getUid()) {
			webrepo.deleteById(id);
		}
		else {
			throw new ResponseStatusException(HttpStatus.UNAUTHORIZED);
		}
		return "Deleted";
	}
	
	public UserClass getUserClass() {
		UserClass user=userRepo.findByUserName(SecurityContextHolder.getContext().getAuthentication().getName());
		return user;
	}
}
