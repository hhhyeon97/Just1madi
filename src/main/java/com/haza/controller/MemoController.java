package com.haza.controller;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
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
    
    /*
    @GetMapping("/memo/list")
    public @ResponseBody String memoList() {
    	return "memo목록";
    }
    */
    
    // 메모 목록 조회
    @GetMapping("/memo/list")
    public String memoList(@AuthenticationPrincipal MemoUser currentUser, Model model) {
        // 현재 로그인한 사용자의 메모 목록 조회
        List<Memo> memoList = memoRepository.findByUser(currentUser);

        // 뷰에 메모 목록 전달
        model.addAttribute("memoList", memoList);

        return "memoList";
    }

}
