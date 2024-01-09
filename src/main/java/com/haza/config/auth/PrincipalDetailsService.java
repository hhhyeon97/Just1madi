package com.haza.config.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.haza.model.MemoUser;
import com.haza.repository.UserRepository;


@Service
public class PrincipalDetailsService implements UserDetailsService{

	@Autowired
	private UserRepository userRepository;
	
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		MemoUser userEntity = userRepository.findByUsername(username);
		System.out.println("username : "+username);
		System.out.println("userEntity : "+userEntity);
		  if(userEntity != null) {
	            return new PrincipalDetails(userEntity); 
	        } else {
	            throw new UsernameNotFoundException("User not found with username: " + username);
	        }
	}

	
	
	public MemoUser findByUsername(String username) {
		MemoUser userEntity = userRepository.findByUsername(username);
		return userEntity;
	}

}
