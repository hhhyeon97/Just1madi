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

   // @ManyToOne(cascade = CascadeType.ALL)
   // @JoinColumn(name = "userNo", nullable = false, foreignKey = @ForeignKey(name = "fk_memo_user"))
   // private MemoUser user; // 외래키로 연결된 MemoUser

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userNo", nullable = false)
    private MemoUser user;
    
    
    
    @Column(nullable = false)
    private String content; // 메모 내용

    @CreationTimestamp
    private Timestamp createDate; // 메모 생성일
    
    
	public void setUser(int userNo) {
		// TODO Auto-generated method stub
		
	}
	
}
