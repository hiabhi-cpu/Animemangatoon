package com.example.demo.model;

import org.springframework.stereotype.Component;

@Component
public class CharacterResponse {
	private int charid;
	private String name;
	private String description;
	public CharacterResponse(CharacterClass characterClass) {
		this.charid=characterClass.getCharid();
		this.name=characterClass.getName();
		this.description=characterClass.getDescription();
	}
	public CharacterResponse(int charid, String name, String description) {
		super();
		this.charid = charid;
		this.name = name;
		this.description = description;
	}
	public CharacterResponse() {
		super();
	}
	public int getCharid() {
		return charid;
	}
	public void setCharid(int charid) {
		this.charid = charid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	
}
