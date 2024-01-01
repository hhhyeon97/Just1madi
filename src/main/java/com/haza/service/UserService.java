package com.haza.service;

import java.util.Optional;

//import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.haza.model.MemoUser;
import com.haza.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	 /*public boolean isUsernameExists(String username) {
	        // 닉네임이 이미 존재하는지 확인
	        Optional<MemoUser> existingMember = userRepository.findByUsername(username);
	        return existingMember.isPresent();
	    }
	*/
}
