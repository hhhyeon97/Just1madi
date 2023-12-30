package com.haza.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.haza.model.Memo;
import com.haza.model.MemoUser;

public interface UserRepository extends JpaRepository<MemoUser, Integer>{

	
	public MemoUser findByUsername(String username);

	public List<Memo> findByUsername(MemoUser username);

	//public MemoUser idCheck(String username);

	// 중복 닉네임 검사를 위한 추가 메서드
    //long countByUsername(String username);
}
