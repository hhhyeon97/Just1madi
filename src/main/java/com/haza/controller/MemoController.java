package com.haza.controller;

import java.io.PrintWriter;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.haza.model.Memo;
import com.haza.model.MemoUser;
import com.haza.repository.MemoRepository;
import com.haza.repository.UserRepository;
import com.haza.service.MemoService;

import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;


@Controller
public class MemoController {

	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Autowired
	private MemoRepository memoRepository;
	
	@Autowired
	private UserRepository userRepository;

	private final MemoService memoService;

	private final DataSource dataSource;  // dataSource 주입    
	    
	@Autowired
	    public MemoController(MemoService memoService,DataSource dataSource) {
	        this.memoService = memoService;
	        this.dataSource = dataSource;
	    }
	    
	    
	/*
	@GetMapping("/memo/create")
	public String createMemoForm(@AuthenticationPrincipal MemoUser currentUser, Model model) {
		System.out.println("로그인한 유저 : "+currentUser);
	    model.addAttribute("currentUser", currentUser);
	    model.addAttribute("memo", new Memo());
	    return "memoForm";
	}
	*/
	
	@GetMapping("/memo/create")
	public String createMemoForm(Model model) {
	    // 현재 인증된 사용자 정보 가져오기
	    Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
	    if (authentication != null) {
	        // 현재 사용자의 principal을 가져오기
	        Object principal = authentication.getPrincipal();

	        if (principal instanceof UserDetails) {
	            // UserDetails에서 사용자 이름 얻기
	            String username = ((UserDetails) principal).getUsername();
	            System.out.println("현재 사용자의 이름: " + username);
	        }
	    }
	    return "memoForm";
	}
 
	 @PostMapping("/memo/save")
	    public String saveMemo(@RequestParam("content") String content) {
	        memoService.saveMemo(content);
	        return "redirect:/memo/list";
	    }
	 
	 @GetMapping("/memo/list")
	    public String viewMemoList(Model model) {
	        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
	        if (authentication != null) {
	            Object principal = authentication.getPrincipal();

	            if (principal instanceof UserDetails) {
	                String username = ((UserDetails) principal).getUsername();
	                List<Memo> memoList = memoService.getUserMemos(username);
	               
	                model.addAttribute("memoList", memoList);
	            }
	        }
	        return "memoList";
	    }
	 
	  @GetMapping("/memo/detail/{memoId}")
	    public String getMemoDetail(@PathVariable("memoId") int memoId, Model model) {
		  Memo memo = memoRepository.findById(memoId)
				  .orElseThrow(() -> new IllegalArgumentException("Invalid memoId"));
		  
		  System.out.println("Trying to fetch memo with ID: " + memoId);
		  
		  String memoEnter=memo.getContent().replace("\n","<br/>"); 
		  //textarea 태그 영역에서 엔터키 친부분을 웹브라우에 출력할때 줄바꿈처리
		  		  
		  // 수정된 날짜가 null이면 생성된 날짜를 사용하도록 처리
	        Timestamp memoDate;
	        if (memo.getUpdateDate() != null) {
	            memoDate = memo.getUpdateDate();
	        } else {
	            memoDate = memo.getCreateDate();
	        }
	        // SimpleDateFormat을 사용하여 포맷 지정
	        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm");
	        String formattedDate = format.format(memoDate);
	        
	        model.addAttribute("time", formattedDate);
		    model.addAttribute("memo", memo);
	        model.addAttribute("content",memoEnter);
	        
	        return "memoContent";
	    }
	 
	// 메모 수정 폼으로 이동
	@GetMapping("/memo/edit/{memoId}")
	public String editMemoForm(@PathVariable("memoId") int memoId, Model model) {
		// 메모 ID를 기반으로 메모 조회
		Memo memo = memoRepository.findById(memoId)
				.orElseThrow(() -> new IllegalArgumentException("Invalid memoId"));
		// 메모 정보를 모델에 추가
		model.addAttribute("memo", memo);
		return "memoEdit";
	}

	// 메모 수정 처리
	@PostMapping("/memo/edit/{memoId}")
	public String editMemo(@PathVariable("memoId") int memoId, @ModelAttribute Memo updatedMemo) {
		// 기존 메모 조회
		Memo memo = memoRepository.findById(memoId)
				.orElseThrow(() -> new IllegalArgumentException("Invalid memoId"));
		// 기존 메모의 내용 업데이트
		//memo.setTitle(updatedMemo.getTitle());
		memo.setContent(updatedMemo.getContent());
		// @UpdateTimestamp 어노테이션에 의해 updateDate가 자동으로 갱신됩니다.

		// 메모 저장
		memoRepository.save(memo);
		// 수정이 완료된 후 메모 목록 페이지로 이동
		return "redirect:/memo/list";
	}	

	// 메모 삭제 처리
	@PostMapping("/memo/delete/{memoId}")
	public String deleteMemo(@PathVariable("memoId") int memoId) {
		// 메모 ID를 기반으로 메모 조회
		Memo memo = memoRepository.findById(memoId)
				.orElseThrow(() -> new IllegalArgumentException("Invalid memoId"));

		// 메모 삭제
		memoRepository.delete(memo);

		// 삭제가 완료된 후 메모 목록 페이지로 이동
		return "redirect:/memo/list";
	}
	
	// 유저 정보 수정폼
    @GetMapping("/memo/myProfile")
    public String userEdit(Model model)
    throws Exception{
    	  Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
	        if (authentication != null) {
	            Object principal = authentication.getPrincipal();

	            if (principal instanceof UserDetails) {
	                String username = ((UserDetails) principal).getUsername();
	                System.out.println("현재 사용자의 이름: " + username);
	                
	                // 모델에 유저 이름 추가
	                model.addAttribute("username", username);
	            }
	        }
	        return "myProfile";
    }//userEdit()

    // 유저 정보 수정 처리
    @PostMapping("/memo/myProfile_ok")
    public ModelAndView userEditOk(MemoUser mu,HttpServletResponse response,
    		HttpSession session) throws Exception{
    	 Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
	        if (authentication != null) {
	            Object principal = authentication.getPrincipal();
	            if (principal instanceof UserDetails) {
	                String username = ((UserDetails) principal).getUsername();
	        // 비밀번호 인코딩
            String encodedPassword = bCryptPasswordEncoder.encode(mu.getPassword());
           
            // 기존 사용자 정보를 조회 
            //( username을 변경하지 않고 무결성조건 위배되지 않게 기존 username으로 insert x - > 업데이트로 처리할 수 있게 )
            MemoUser existingUser = userRepository.findByUsername(username);

            if (existingUser != null) {
                // 기존 사용자 정보를 업데이트
                existingUser.setPassword(encodedPassword);
                // 다른 필요한 업데이트 작업 수행

                userRepository.save(existingUser);
            }
            // 세션 로그아웃 처리
            session.invalidate();
            return new ModelAndView("redirect:/login");
	            }
	        }
    	return null;
    }//userEditOk()
    
    //=============== 0207 기능 추가 ===================
    @GetMapping("/memo/search")
    public String searchMemo(@RequestParam String keyword, Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null) {
            Object principal = authentication.getPrincipal();
            if (principal instanceof UserDetails) {
                String username = ((UserDetails) principal).getUsername();
                List<Memo> searchResult = memoService.searchUserMemos(username, keyword);
                model.addAttribute("memoList", searchResult);
                
                // 검색 결과가 없는 경우 메시지를 추가
                if (searchResult.isEmpty()) {
                    model.addAttribute("message", "일치하는 메모가 없습니다.");
                }
            }
        }
        return "memoList"; // 검색 결과를 포함한 메모 리스트 페이지를 반환
    }
    
    @PostMapping("/memo/deleteAll")
    public String deleteAllMemos() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null) {
            Object principal = authentication.getPrincipal();
            if (principal instanceof UserDetails) {
                String username = ((UserDetails) principal).getUsername();
                memoService.deleteAllUserMemos(username); // 해당 사용자의 모든 메모 삭제
            }
        }
        return "redirect:/memo/list"; // 삭제 후 메모 리스트 페이지로 리다이렉트
    }
    
    
    
    
    
}
