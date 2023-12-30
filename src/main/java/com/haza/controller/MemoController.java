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

import com.haza.model.Memo;
import com.haza.model.MemoUser;
import com.haza.repository.MemoRepository;
import com.haza.repository.UserRepository;


@Controller
public class MemoController {

	@Autowired
	private MemoRepository memoRepository;

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
		memo.setUser(currentUser);
		// 작성일 설정
		memo.setCreateDate(new Timestamp(System.currentTimeMillis()));
		// 메모 저장
		memoRepository.save(memo);
		// 작성이 완료된 후 메모 목록 페이지로 이동
		return "redirect:/memo/list";
	}

	// 메모 목록 조회
	@GetMapping("/memo/list")
	public String memoList(@AuthenticationPrincipal MemoUser currentUser, Model model) {
		
		if (currentUser == null) {
	        // 로그인하지 않은 상태에서의 처리
	        // 예를 들어, 로그인 페이지로 리다이렉트하거나 다른 처리를 수행할 수 있습니다.
	        return "redirect:/";
	    }
		
		// 현재 로그인한 사용자의 메모 목록 조회
		List<Memo> memoList = memoRepository.findByUser(currentUser);

		// 뷰에 메모 목록 전달
		model.addAttribute("memoList", memoList);
		
		String loggedInUsername = currentUser.getUsername();
		model.addAttribute("loggedInUsername", loggedInUsername);
		 
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

	// 메모 수정 처리
	@PostMapping("/memo/edit/{memoId}")
	public String editMemo(@PathVariable("memoId") int memoId, @ModelAttribute Memo updatedMemo) {
		// 기존 메모 조회
		Memo memo = memoRepository.findById(memoId)
				.orElseThrow(() -> new IllegalArgumentException("Invalid memoId"));

		// 기존 메모의 내용 업데이트
		memo.setTitle(updatedMemo.getTitle());
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


}
