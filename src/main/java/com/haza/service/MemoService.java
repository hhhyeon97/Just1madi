package com.haza.service;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import com.haza.config.auth.PrincipalDetailsService;
import com.haza.model.Memo;
import com.haza.model.MemoUser;
import com.haza.repository.MemoRepository;

@Service
public class MemoService {

	 private final MemoRepository memoRepository;
	 private final PrincipalDetailsService principalDetailsService;
	 
	 @Autowired
	 public MemoService(PrincipalDetailsService principalDetailsService, MemoRepository memoRepository) {
	     this.principalDetailsService = principalDetailsService;
	     this.memoRepository = memoRepository;
	 }

	    public void saveMemo(String content) {
	        // 현재 인증된 사용자 정보 가져오기
	        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

	        if (principal instanceof UserDetails) {
	            // UserDetails에서 사용자 이름 얻기
	            String username = ((UserDetails) principal).getUsername();

	            // 사용자 이름으로 MemoUser 객체 가져오기 (사용자와 메모 간의 연결을 위해)
	            MemoUser user = principalDetailsService.findByUsername(username);

	            
	            // Memo 객체 생성 및 설정
	            Memo memo = new Memo();
	            memo.setUser(user);
	            memo.setContent(content);

	            // Memo 저장
	            memoRepository.save(memo);
	            System.out.println("메모 저장 성공!");
	        }
	    }
	    
	    
	    public List<Memo> getUserMemos(String username) {
	    	MemoUser user = principalDetailsService.findByUsername(username);
	        return user != null ? user.getMemos() : new ArrayList<>();
	    }

	    
	    
    
}
