package com.haza.model;

import java.sql.Timestamp;

import org.hibernate.annotations.CreationTimestamp;  // 변경된 import

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import lombok.Data;
@Data
@Entity
@SequenceGenerator(name = "memo_seq", sequenceName = "memo_sequence", allocationSize = 1)
public class Memo {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "memo_seq")
    private int memoId; // 메모번호

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userNo", nullable = false)
    private MemoUser user;

    @Column(nullable = false)
    private String content; // 메모 내용

    @CreationTimestamp
    private Timestamp createDate; // 메모 생성일
    
    // 생성자, getter, setter 등 필요한 메서드 추가

    // 유저를 설정하는 메서드
    public void setUser(MemoUser user) {
        this.user = user;
    }

	public void setUser(String username) {
		// TODO Auto-generated method stub
		
	}
}
