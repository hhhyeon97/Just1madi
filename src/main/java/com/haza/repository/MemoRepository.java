package com.haza.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.haza.config.auth.PrincipalDetails;
import com.haza.model.Memo;
import com.haza.model.MemoUser;

public interface MemoRepository extends JpaRepository<Memo, Integer> {

	List<Memo> findByUser(MemoUser currentUser);
	List<Memo> findByUser_UserNo(int userNo);
	List<Memo> findByUser_UsernameAndContentContaining(String username, String keyword);
	List<Memo> findByUser_Username(String username);
	void deleteById(int memoId);


	
	
	
}
