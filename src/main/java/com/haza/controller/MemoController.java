package com.haza.controller;

import java.security.Timestamp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.ui.Model;
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
    
    @GetMapping("/memo/create")
    public String createMemoForm(Model model) {
        model.addAttribute("memo", new Memo());
        return "createMemo";
    }

	
    /*
    
    // 메모 작성 처리
    @PostMapping("/memo/create")
    public String createMemo(@ModelAttribute Memo memo, @AuthenticationPrincipal MemoUser currentUser) {
        // 현재 로그인한 사용자를 메모의 작성자로 설정
        memo.setUser(currentUser);
        // 작성일 설정
        memo.setCreateDate(new Timestamp(System.currentTimeMillis()));

        // 메모 저장
        memoRepository.save(memo);

        // 작성이 완료된 후 메모 목록 페이지로 이동 또는 다른 처리를 수행할 수 있습니다.
        return "redirect:/memo/list";
    }
    
    */
}
