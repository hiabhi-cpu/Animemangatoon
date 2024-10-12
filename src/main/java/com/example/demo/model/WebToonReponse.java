package com.example.demo.model;

import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class WebToonReponse {
	private int webid;
	private String title;
	private String description;
	private List<CharacterResponse> characters;
	public WebToonReponse(WebToon webToon, List<CharacterResponse> characters) {
		super();
		this.webid = webToon.getWebid();
		this.title = webToon.getTitle();
		this.description = webToon.getDescription();
		this.characters = characters;
	}
	public WebToonReponse() {
		super();
	}
	public int getWebid() {
		return webid;
	}
	public void setWebid(int webid) {
		this.webid = webid;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public List<CharacterResponse> getCharacters() {
		return characters;
	}
	public void setCharacters(List<CharacterResponse> characters) {
		this.characters = characters;
	}
	
	
}
