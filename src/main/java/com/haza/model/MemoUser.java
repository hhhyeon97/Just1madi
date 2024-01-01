package com.haza.model;

import java.sql.Timestamp;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import lombok.Data;

@Data
@Entity
@SequenceGenerator(name = "user_seq", sequenceName = "user_sequence", allocationSize = 1)
public class MemoUser {
	
	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_seq")
	private int userNo; // 회원번호
	
	@Column(unique = true, nullable = false)
	private String username; // 닉네임


	private String password;	//비밀번호
	private String role;		//ROLE_USER, ROLE_ADMIN

	@CreationTimestamp
	private Timestamp createDate;	//가입날짜
	
	
	  // 추가: MemoUser에서 User 정보를 반환하는 메서드
    public MemoUser getUser() {
    	MemoUser user = new MemoUser();
        user.setUserNo(userNo);
        user.setUsername(username);
        user.setPassword(password);
        user.setRole(role);
        user.setCreateDate(createDate);
        return user;
    }
}
