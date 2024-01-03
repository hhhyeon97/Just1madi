package com.haza.controller;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.haza.config.auth.PrincipalDetails;
import com.haza.model.Memo;
import com.haza.model.MemoUser;
import com.haza.repository.MemoRepository;
import com.haza.repository.UserRepository;
import com.haza.service.MemoService;


@Controller
public class MemoController {

	@Autowired
	private MemoRepository memoRepository;

	@Autowired
	private MemoService memoService;
	
	@Autowired
	private UserRepository userRepository;

	// 메모 작성폼 
	@GetMapping("/memo/create")
	public String createMemoForm(Model model) {
		model.addAttribute("memo", new Memo());
		return "memoForm";
	}

	// 메모 작성 처리
	@PostMapping("/memo/create_ok")
	public String createMemo(@ModelAttribute Memo memo, @AuthenticationPrincipal MemoUser currentUser) {
		// 현재 로그인한 사용자를 메모의 작성자로 설정
		//memo.setUser(currentUser);
		// MemoUser 엔터티를 먼저 저장
	    //userRepository.save(currentUser);
		// 작성일 설정
		//memo.setCreateDate(new Timestamp(System.currentTimeMillis()));
		// 메모 저장
		//memoService.createMemo(memo,currentUser);
		// memoRepository.save(memo);
		// 작성이 완료된 후 메모 목록 페이지로 이동
		//return "redirect:/memo/list";
		//memo.setUser(currentUser.getUserNo());
		 memo.setUser(currentUser.getUser()); // 메모에 사용자 정보를 설정
		 memo.setCreateDate(new Timestamp(System.currentTimeMillis()));
		    //memoRepository.save(memo);
		 	memoService.saveMemo(memo);
		 return "redirect:/memo/list";
		
	}
	
	@GetMapping("/memo/list")
	public String memoList(@AuthenticationPrincipal PrincipalDetails currentUser, Model model) {
	    // 현재 로그인한 사용자의 ID를 가져옴
	   // int currentUserId = currentUser.getUserNo();
		String currentUserId = currentUser.getUsername();
	    // 현재 로그인한 사용자의 메모 목록 조회
	    //List<Memo> memoList = memoRepository.findByUserNo(userNo);
	    
		List<Memo> memoList = memoRepository.findByUser(currentUserId);
		
	    // 뷰에 메모 목록 전달
	    model.addAttribute("memoList", memoList);

	    return "memoList";
	}

	/*
	
	// 메모 목록 조회
	@GetMapping("/memo/list")
	public String memoList(@AuthenticationPrincipal MemoUser currentUser, HttpSession session, Model model) {
	    // 현재 로그인한 사용자의 메모 목록 조회
	    List<Memo> memoList = memoRepository.findByUser(currentUser);
	   // System.out.println("=============== currentUser : "+currentUser.getUsername());
	    //시도 1
	    // 추가: 현재 로그인한 사용자의 이름을 뷰에 전달
	    //String loggedInUsername = currentUser.getUsername();
	   //addAttribute("loggedInUsername", loggedInUsername);

	    //시도 2
	 // 세션에 사용자 이름 저장
	  //  String loggedInUsername = currentUser.getUsername();
	   // session.setAttribute("loggedInUsername", loggedInUsername);
	    
	    
	    // 메모 내용을 10글자로 제한하여 가공
	    List<String> shortMemoContents = new ArrayList<>();
	    for (Memo memo : memoList) {
	        String content = memo.getContent();
	        if (content.length() > 10) {
	            content = content.substring(0, 10) + "..."; // 10글자 초과 시 ... 추가
	        }
	        shortMemoContents.add(content);
	    }
	 
	    // 뷰에 메모 목록 및 가공된 내용 전달
	    model.addAttribute("memoList", memoList);
	    model.addAttribute("shortMemoContents", shortMemoContents);

	    return "memoList";
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
	
	*/

	// 메모 수정 처리
	@PostMapping("/memo/edit/{memoId}")
	public String editMemo(@PathVariable("memoId") int memoId, @ModelAttribute Memo updatedMemo) {
		// 기존 메모 조회
		Memo memo = memoRepository.findById(memoId)
				.orElseThrow(() -> new IllegalArgumentException("Invalid memoId"));

		// 기존 메모의 내용 업데이트
		//memo.setTitle(updatedMemo.getTitle());
		memo.setContent(updatedMemo.getContent());

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

	
	// 메모유저 정보 수정 
	@GetMapping("/memo/myProfile")
	public String myProfile() {
		return "myProfile";
	}

}
