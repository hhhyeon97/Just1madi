package com.haza.controller;


import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
	
	@GetMapping("/")
	public String index() {
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
	
	
	@PostMapping("/loginCheck")
	public String loginCheck(MemoUser user, HttpServletResponse response, HttpServletRequest request) throws Exception {
		 PrintWriter out = response.getWriter();
	    // 입력받은 닉네임으로 사용자 정보를 조회
	    MemoUser dbUser = userRepository.findByUsername(user.getUsername());
	    if (dbUser == null) {
	        // 닉네임이 DB에 없는 경우
	    	 out.println("<script>");
		        out.println("alert('가입 안 된 회원입니다!');");
		        out.println("history.back();");
		        out.println("</script>");
	        //request.setAttribute("errorMessage", "존재하지 않은 회원입니다.");
	       // return "index"; // 로그인 페이지로 리다이렉트 또는 원하는 페이지로 이동
	    } else {
	        // 닉네임이 DB에 있는 경우, 비밀번호 일치 여부 확인
	        if (bCryptPasswordEncoder.matches(user.getPassword(), dbUser.getPassword())) {
	        	return "redirect:/memo/list"; // 로그인 성공 시 이동할 페이지
	        } else {
	            // 비밀번호 불일치
	        	 out.println("<script>");
		            out.println("alert('비밀번호가 다릅니다!');");
		            out.println("history.go(-1);");
		            out.println("</script>");
	           // request.setAttribute("errorMessage", "비밀번호가 일치하지 않습니다.");
	           // return "index"; // 로그인 페이지로 리다이렉트 또는 원하는 페이지로 이동
	        }
	    }
	    return null;
	}
	
	/*
	 private void authenticateUserAndSetSession(MemoUser user, HttpServletRequest request) {
	        String username = user.getUsername();
	        // 시큐리티에서 사용자의 권한을 설정할 수 있다면 여기서 권한을 설정할 수 있습니다.
	        // 예: List<GrantedAuthority> authorities = Arrays.asList(new SimpleGrantedAuthority("ROLE_USER"));
	        
	        Authentication authentication = new UsernamePasswordAuthenticationToken(username, null);
	        SecurityContextHolder.getContext().setAuthentication(authentication);

	        // HttpSession에 인증된 사용자를 저장
	        request.getSession().setAttribute(HttpSessionSecurityContextRepository.SPRING_SECURITY_CONTEXT_KEY, SecurityContextHolder.getContext());
	    }
	}
	*/
	
	@GetMapping("/join")
	public String join(){
		return "join";
	}
	
	/*
	//닉네임 중복검색 시도 01 
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
	*/
	
	// 시도 02 
	@PostMapping("/idCheck")
	@ResponseBody
	public Map<String, Object> idCheck(@RequestParam String username) {
	    Map<String, Object> result = new HashMap<>();
	    MemoUser dbUser = userRepository.findByUsername(username);

	    if (dbUser != null) {
	        result.put("result", "duplicate");
	    } else {
	        result.put("result", "available");
	    }

	    return result;
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
