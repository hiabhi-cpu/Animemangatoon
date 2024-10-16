package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.UserClass;

@Repository
public interface UserRepo extends JpaRepository<UserClass, Integer>{

	UserClass findByUserName(String username);

}
