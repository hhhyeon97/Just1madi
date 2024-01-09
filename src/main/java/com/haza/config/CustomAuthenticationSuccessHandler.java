package com.haza.config;

import java.io.IOException;
import java.net.URLEncoder;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class CustomAuthenticationSuccessHandler  implements AuthenticationSuccessHandler{

	
	 @Override
	    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
	        // 현재 인증된 사용자 정보 가져오기
	        String username = SecurityContextHolder.getContext().getAuthentication().getName();

	        // JavaScript를 사용하여 알림창을 띄움
	       /*
	        PrintWriter out = response.getWriter();
	        out.println("<script>");
	        out.println("alert('어서오세요, " + username + "님!');");
	        out.println("window.location.replace('/memo/list');");
	        out.println("</script>");
	    */
	        // 리다이렉션 경로 설정
	        //response.sendRedirect(request.getContextPath() + "/memo/list?username=" + URLEncoder.encode(username, "UTF-8"));
	        //response.sendRedirect(request.getContextPath() + "/memo/list");
	        
	        // 로그인 성공 후 세션에 사용자 이름 저장
	        request.getSession().setAttribute("username", username);
	     // 리다이렉션 경로 설정
	        response.sendRedirect(request.getContextPath() + "/memo/list");
	   
	 }
}
