package com.haza.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.haza.model.MemoUser;
import com.haza.repository.UserRepository;

@Controller
public class IndexController {

	@Autowired
	private UserRepository userRepository;
	
	
	@GetMapping("/")
	public String index() {
		return "index";
	}
	
	@GetMapping("/user")
	public @ResponseBody String user() {
		return "user";
	}

	@GetMapping("/admin")
	public @ResponseBody String admin() {
		return "admin";
	}

	@GetMapping("/login")
	public @ResponseBody String login() {
		return "login";
	}	

	@GetMapping("/join")
	public String join(){
		return "join";
	}
	
	@PostMapping("/join_ok")
	public String join_ok(MemoUser user) {
		System.out.println("user ============\n"+user);
		user.setRole("ROLE_USER");
		userRepository.save(user);
		return "join";
	}
	
}
