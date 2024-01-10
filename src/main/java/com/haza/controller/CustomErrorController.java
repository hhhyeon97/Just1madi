package com.haza.controller;

import org.springframework.boot.web.server.ErrorPage;
import org.springframework.boot.web.server.WebServerFactory;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;


@Controller
public class CustomErrorController implements WebServerFactoryCustomizer<WebServerFactory>{

	@Override
	public void customize(WebServerFactory factory) {

		ErrorPage errorPage404 = new ErrorPage(HttpStatus.NOT_FOUND, "error-page/404");
		ErrorPage errorPage403 = new ErrorPage(HttpStatus.FORBIDDEN, "error-page/403");
		
		//factory.addErrorPages(errorPage404);
		//factory.addErrorPages(errorPage403);
	}

	
   
}