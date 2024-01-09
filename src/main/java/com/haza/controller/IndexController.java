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
import com.haza.service.UserService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;


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
        
        return "redirect:/"; // 로그아웃 후 리다이렉트할 페이지
    }
	
	/*
	// 시큐리티 로그인 시도 
		@PostMapping("/login_ok")
		public ModelAndView login_ok(String username, String password, HttpServletResponse response, HttpSession session) throws Exception {
		    response.setContentType("text/html;charset=UTF-8");
		    PrintWriter out = response.getWriter();
		    MemoUser mu = this.userRepository.findByUsername(username);
		    if (mu == null) {
		        // 가입 안 된 회원 처리
		        out.println("<script>");
		        out.println("alert('가입 안 된 회원입니다!');");
		        out.println("history.back();");
		        out.println("</script>");
		    } else {
		        // BCryptPasswordEncoder를 사용하여 암호화된 비밀번호를 비교
		        if (!bCryptPasswordEncoder.matches(password, mu.getPassword())) {
		            // 비밀번호가 다를 경우 처리
		            out.println("<script>");
		            out.println("alert('비밀번호가 다릅니다!');");
		            out.println("history.go(-1);");
		            out.println("</script>");
		        } else {
		            // 로그인 성공 시 처리
		            session.setAttribute("username", username);
		            System.out.println("로그인 성공!" + username+"님");
		            //return new ModelAndView("redirect:/letter/loading");
		        }
		    }
		    return null;
		}
	*/
	
	
	@GetMapping("/join")
	public String join(){
		return "join";
	}
	
	
	/*
	@PostMapping("/join")
	public String join(MemoUser user, HttpServletRequest request) {
	    // 중복 닉네임 체크
	    MemoUser dbUser = userRepository.findByUsername(user.getUsername());

	    if (dbUser != null) {
	        // 중복 닉네임인 경우
	        request.setAttribute("message", "중복된 닉네임입니다.");
	        return "redirect:/join"; // 중복 닉네임이면 회원가입 페이지로 다시 리다이렉트
	    }
	    // 중복 닉네임이 아닌 경우
	    user.setRole("ROLE_USER");
	    String rawPassword = user.getPassword();
	    String encPassword = bCryptPasswordEncoder.encode(rawPassword);
	    user.setPassword(encPassword);

	    request.setAttribute("message", "회원가입을 축하합니다 !");
	    userRepository.save(user);

	    return "redirect:/";
	}
*/
	
	
	@PostMapping("/join")
	public String join(MemoUser user, HttpServletRequest request) {
	    // 중복 닉네임 체크
	    MemoUser dbUser = userRepository.findByUsername(user.getUsername());

	    if (dbUser != null) {
	        // 중복 닉네임인 경우
	        request.setAttribute("message", "중복된 닉네임입니다.");
	        return "redirect:/join"; // 중복 닉네임이면 회원가입 페이지로 다시 리다이렉트
	    }

	    // 중복 닉네임이 아닌 경우
	    user.setRole("ROLE_USER");
	    String rawPassword = user.getPassword();
	    String encPassword = bCryptPasswordEncoder.encode(rawPassword);
	    user.setPassword(encPassword);

	    //request.setAttribute("message", "회원가입을 축하합니다 !");
	    userRepository.save(user);

	    return "redirect:/";
	}

	
	
	/*
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
	*/

	
	
}
