package com.haza.controller;


import java.io.PrintWriter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.haza.model.MemoUser;
import com.haza.repository.UserRepository;
import com.haza.service.UserService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@Controller
public class IndexController {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@GetMapping("/login")
	public String login() {
		return "index";
	}

	@GetMapping("/memo")
	public @ResponseBody String memo() {
		return "memo";
	}

	@GetMapping("/custom-logout")
    public String customLogout(HttpServletRequest request, HttpServletResponse response,
            Authentication authentication) {
        if (authentication != null) {
            new SecurityContextLogoutHandler().logout(request, response, authentication);
            System.out.println("로그아웃...");
        }
        return "redirect:/";
    }
	
	
	@GetMapping("/join")
	public String join(){
		return "join";
	}

	
	@PostMapping("/idCheck")
	public void idCheck(String username, HttpServletResponse response) throws Exception {
	    PrintWriter out = response.getWriter();
	    MemoUser existingMember = this.userService.idCheck(username);
	    int result = (existingMember != null) ? 1 : -1;
	    out.println(result);
	}
	
	
	@PostMapping("/join")
	public String join(MemoUser user, HttpServletRequest request) {
		System.out.println("user ============\n"+user);
		user.setRole("ROLE_USER");
		String rawPassword = user.getPassword();
		String encPassword = bCryptPasswordEncoder.encode(rawPassword);
		user.setPassword(encPassword);
		//request.setAttribute("message", "회원가입을 축하합니다 !");
		userRepository.save(user);
		
		return "redirect:/";
	}
	

	
}
