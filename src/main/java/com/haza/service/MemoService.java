package com.haza.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import com.haza.model.Memo;
import com.haza.model.MemoUser;
import com.haza.repository.MemoRepository;

@Service
public class MemoService {

    //@Autowired
    //private MemoRepository memoRepository;

    /*
    @Transactional
    public void createMemo(Memo memo, MemoUser currentUser) {
        // MemoUser 엔터티의 인스턴스 생성 및 저장
        MemoUser memoUser = new MemoUser();
        memoUser.setUsername(currentUser.getUsername());
        memoUser.setPassword(currentUser.getPassword());
        // userRepository.save(memoUser); // 주석을 풀고 사용해보세요.

        // 메모의 user 필드에 MemoUser 할당
        memo.setUser(memoUser);
        // Memo 저장
        memoRepository.save(memo);
    }
    */
    
   // @Transactional
	//public void saveMemo(Memo memo) {
   // 	   memoRepository.save(memo);
	//}
    
    
    private final MemoRepository memoRepository;

    @Autowired
    public MemoService(MemoRepository memoRepository) {
        this.memoRepository = memoRepository;
    }

    public Memo saveMemo(Memo memo) {
        // 현재 인증된 사용자 정보 가져오기
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if (authentication != null && authentication.isAuthenticated()) {
            // 현재 사용자의 principal을 가져오기
            Object principal = authentication.getPrincipal();

            if (principal instanceof UserDetails) {
                // UserDetails에서 사용자 정보 얻기
                //MemoUser currentUser = userService.findUserByUsername(((UserDetails) principal).getUsername());

                String username = ((UserDetails) principal).getUsername();
                // 메모의 유저 설정
                memo.setUser(username);

                // 메모 저장
                return memoRepository.save(memo);
            }
        }

        // 인증 정보가 없거나 인증되지 않은 경우에 대한 처리
        // 필요에 따라 로그인 페이지로 리다이렉트 등을 할 수 있습니다.
        return null; // 또는 예외 처리 등을 추가할 수 있습니다.
    }
    
    
    
    
}
