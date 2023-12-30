package com.haza.model;

import java.sql.Timestamp;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
@Entity
public class Memo {


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int memoId; // 메모번호

	private String title; // 메모 제목
	private String content; // 메모 내용

	@CreationTimestamp
	private Timestamp createDate; // 메모 작성일

	@ManyToOne(cascade = CascadeType.PERSIST)
	private MemoUser user; // 메모를 작성한 사용자

}
