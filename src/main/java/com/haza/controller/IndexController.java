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
	
	
	
	@PostMapping("/loginCheck")
	public String login(MemoUser user, HttpServletRequest request) {
	    // 입력받은 닉네임으로 사용자 정보를 조회
	    MemoUser dbUser = userRepository.findByUsername(user.getUsername());

	    if (dbUser == null) {
	        // 닉네임이 DB에 없는 경우
	        request.setAttribute("errorMessage", "존재하지 않은 회원입니다.");
	        return "index"; // 로그인 페이지로 리다이렉트 또는 원하는 페이지로 이동
	    } else {
	        // 닉네임이 DB에 있는 경우, 비밀번호 일치 여부 확인
	        if (bCryptPasswordEncoder.matches(user.getPassword(), dbUser.getPassword())) {
	            // 비밀번호 일치
	            // 로그인 성공 처리
	            // 여기서는 간단하게 리다이렉트하는데, 실제로는 로그인 성공 후의 동작을 정의해야 합니다.
	            return "redirect:/memo/list"; // 로그인 성공 시 이동할 페이지
	        } else {
	            // 비밀번호 불일치
	            request.setAttribute("errorMessage", "비밀번호가 일치하지 않습니다.");
	            return "index"; // 로그인 페이지로 리다이렉트 또는 원하는 페이지로 이동
	        }
	    }
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
	
	
	
	@PostMapping("/join")
	public String join(MemoUser user, HttpServletRequest request) {
		System.out.println("user ============\n"+user);
		user.setRole("ROLE_USER");
		
		String rawPassword = user.getPassword();
		String encPassword = bCryptPasswordEncoder.encode(rawPassword);
		user.setPassword(encPassword);
		
		request.setAttribute("message", "회원가입을 축하합니다 !");
		userRepository.save(user);
		
		return "redirect:/";
	}
	
	
}
