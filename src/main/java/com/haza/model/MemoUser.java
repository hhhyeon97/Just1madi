package com.haza.model;

import java.sql.Timestamp;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class MemoUser {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int userNo; // 회원번호
	private String username;	//닉네임

	private String password;	//비밀번호
	private String role;		//ROLE_USER, ROLE_ADMIN

	@CreationTimestamp
	private Timestamp createDate;	//가입날짜
}
