package com.haza.config;

import java.io.IOException;
import java.io.PrintWriter;

import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;

import com.haza.model.MemoUser;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class CustomAuthenticationFailureHandler extends SimpleUrlAuthenticationFailureHandler{

	
	 public void fail(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
	        response.setContentType("text/html; charset=utf-8");
	        PrintWriter out = response.getWriter();
	        out.println("<script>");
	        out.println("alert('가입 안 된 회원이거나 비밀번호가 다릅니다!');");
	        out.println("history.go(-1);");
	        out.println("</script>");
	    }

}
