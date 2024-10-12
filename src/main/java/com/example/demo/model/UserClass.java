package com.example.demo.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "usertable")
public class UserClass {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int uid;
	@Column(unique = true)
	private String userName;
	private String userPassword;
	@OneToMany(mappedBy = "uid", cascade = CascadeType.ALL, orphanRemoval = true)
	@JsonIgnore
	List<WebToon> webToons;
	public UserClass(int uid, String userName, String userPassword) {
		super();
		this.uid = uid;
		this.userName = userName;
		this.userPassword = userPassword;
	}
	public UserClass() {
		super();
	}
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	@Override
	public String toString() {
		return "UserClass [uid=" + uid + ", userName=" + userName + ", userPassword=" + userPassword + "]";
	}
	
	
}
