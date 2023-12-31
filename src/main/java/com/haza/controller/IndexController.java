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
import org.springframework.web.servlet.ModelAndView;

import com.haza.model.MemoUser;
import com.haza.repository.UserRepository;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@Controller
public class IndexController {

	@Autowired
	private UserRepository userRepository;
	
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@GetMapping("/")
	public String index() {
		return "index";
	}

	@GetMapping("/memo")
	public @ResponseBody String memo() {
		return "memo";
	}
	
	@GetMapping("/admin")
	public @ResponseBody String admin() {
		return "admin";
	}

	/*
	@PostMapping("/login_ok")
	public String login_ok() {
		return "redirect:/memo";
	}
	*/	

	@GetMapping("/custom-logout")
    public String customLogout(HttpServletRequest request, HttpServletResponse response,
            Authentication authentication) {
        if (authentication != null) {
            new SecurityContextLogoutHandler().logout(request, response, authentication);
            System.out.println("로그아웃...");
        }
        
        return "redirect:/"; // 로그아웃 후 리다이렉트할 페이지
    }
	
	@GetMapping("/join")
	public String join(){
		return "join";
	}
	
	
	//닉네임 중복검색
	@PostMapping("/idCheck")
	public ModelAndView idCheck(String username,HttpServletResponse response)
			throws Exception{
		PrintWriter out=response.getWriter();
		MemoUser db_id = this.userRepository.findByUsername(username);
		int re=-1;
		if(db_id != null) {
			re=1;
		}
		out.println(re);
		return null;
	}
	
	
	
	@PostMapping("/join_ok")
	public String join_ok(MemoUser user, HttpServletRequest request) {
		System.out.println("user ============\n"+user);
		user.setRole("ROLE_USER");
		
		String rawPassword = user.getPassword();
		String encPassword = bCryptPasswordEncoder.encode(rawPassword);
		user.setPassword(encPassword);
		
		userRepository.save(user);
		
		request.setAttribute("message", "회원가입을 축하합니다 !");
		return "redirect:/";
	}
	
	
}
