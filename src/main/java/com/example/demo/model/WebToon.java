package com.example.demo.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "webtoon")
public class WebToon {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int webid;
	@Column(name = "webtitle")
	private String title;
	@Column(name = "webdesc")
	private String description;
	@OneToMany(mappedBy = "webtoon", cascade = CascadeType.ALL, orphanRemoval = true)
	@JsonIgnore
	private List<CharacterClass> characters;
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "uid", nullable = false)
	@JsonIgnore
	private UserClass uid;
	public WebToon(int webid, String title, String description, List<CharacterClass> characters) {
		super();
		this.webid = webid;
		this.title = title;
		this.description = description;
		this.characters = characters;
	}
	

	public WebToon(int webid, String title, String description, List<CharacterClass> characters, UserClass userid) {
		super();
		this.webid = webid;
		this.title = title;
		this.description = description;
		this.characters = characters;
		this.uid = userid;
	}

	public WebToon() {
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
	public List<CharacterClass> getCharacters() {
		return characters;
	}
	public void setCharacters(List<CharacterClass> characters) {
		this.characters = characters;
	}
	@Override
	public String toString() {
		return "WebToon [webid=" + webid + ", title=" + title + ", description=" + description + ", characters="
				+ characters + "]";
	}


	public UserClass getUid() {
		return uid;
	}


	public void setUid(UserClass uid) {
		this.uid = uid;
	}
	
	
}
