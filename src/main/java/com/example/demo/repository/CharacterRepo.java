package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.CharacterClass;

@Repository
public interface CharacterRepo extends JpaRepository<CharacterClass, Integer>{

}
