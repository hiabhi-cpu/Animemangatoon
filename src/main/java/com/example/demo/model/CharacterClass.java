package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "CharTable")
public class CharacterClass {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int charid;
	@Column(name = "charname")
	private String name;
	@Column(name = "chardesc")
	private String description;
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "webid", nullable = false)
	@JsonIgnore
	private WebToon webtoon;
	public CharacterClass(int charid, String name, String description, WebToon webToon) {
		super();
		this.charid = charid;
		this.name = name;
		this.description = description;
		this.webtoon = webToon;
	}
	public CharacterClass() {
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
	public WebToon getWebToon() {
		return webtoon;
	}
	public void setWebToon(WebToon webToon) {
		this.webtoon = webToon;
	}
	@Override
	public String toString() {
		return "CharacterClass [charid=" + charid + ", name=" + name + ", description=" + description + ", webtoon="
				+ webtoon + "]";
	}
	
	
}
