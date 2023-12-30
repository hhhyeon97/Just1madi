package com.haza.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.haza.model.Memo;
import com.haza.model.MemoUser;
import com.haza.repository.MemoRepository;

import jakarta.transaction.Transactional;

@Service
public class MemoService {

    @Autowired
    private MemoRepository memoRepository;

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
}
