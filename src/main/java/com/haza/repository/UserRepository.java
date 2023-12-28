package com.haza.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.haza.model.MemoUser;

public interface UserRepository extends JpaRepository<MemoUser, Integer>{

	
	public MemoUser findByUsername(String username);
	
}
