package com.haza.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class CustomAuthenticationProvider implements AuthenticationProvider{

	 @Autowired
	 private UserDetailsService userDetailsService;
	
	 @Autowired
	 private BCryptPasswordEncoder passwordEncoder;
	 
	 /*
	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		 	String username = authentication.getName();
	        String password = authentication.getCredentials().toString();

	        // UserDetailsService를 통해 사용자 정보를 조회
	        UserDetails userDetails = userDetailsService.loadUserByUsername(username);

	        // 인증에 성공하면 Authentication 객체 생성
	        Authentication auth = new UsernamePasswordAuthenticationToken(userDetails, password, userDetails.getAuthorities());
	        return auth;
	}
*/
	 

	    @Override
	    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
	        String username = authentication.getName();
	        String password = authentication.getCredentials().toString();

	        // UserDetailsService를 통해 사용자 정보를 조회
	        UserDetails userDetails = userDetailsService.loadUserByUsername(username);

	        // 비밀번호 확인
	        if (passwordEncoder.matches(password, userDetails.getPassword())) {
	            // 인증에 성공하면 Authentication 객체 생성
	            Authentication auth = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
	            return auth;
	        } else {
	            // 비밀번호가 일치하지 않으면 null 반환 (인증 실패)
	            return null;
	        }
	    }

	 
	 
	 
	@Override
	public boolean supports(Class<?> authentication) {
		return authentication.equals(UsernamePasswordAuthenticationToken.class);
	}

}
