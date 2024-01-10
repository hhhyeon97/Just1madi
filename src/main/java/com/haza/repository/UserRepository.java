package com.haza.repository;


import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.haza.model.Memo;
import com.haza.model.MemoUser;

public interface UserRepository extends JpaRepository<MemoUser, Integer>{

	
	public MemoUser findByUsername(String username);

	public List<Memo> findByUsername(MemoUser username);

	//public Optional<MemoUser> findByUsername(String username);
	
}
