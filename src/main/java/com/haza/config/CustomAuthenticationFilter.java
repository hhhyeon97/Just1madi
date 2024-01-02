package com.haza.config;

import java.io.IOException;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class CustomAuthenticationFilter extends UsernamePasswordAuthenticationFilter{

	 @Override
	    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) {
	        // 사용자 정의 로그인 처리 메서드 호출
	        // ...

	        // Spring Security의 로그인 처리 메서드 호출
	        return super.attemptAuthentication(request, response);
	    }

	    @Override
	    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authResult) throws IOException, ServletException {
	        // 사용자 정의 로직 이후에 추가 작업이 필요하다면 여기에 작성
	        // ...

	        super.successfulAuthentication(request, response, chain, authResult);
	    }

		public void setAuthenticationManager(AuthenticationManager authenticationManagerBean) {
			// TODO Auto-generated method stub
			
		}
    
}
