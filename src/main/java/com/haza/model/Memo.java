package com.haza.model;

import java.sql.Timestamp;

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonManagedReference;

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
import lombok.ToString;


@Data
@Entity
@SequenceGenerator(name = "memo_seq", sequenceName = "memo_sequence", allocationSize = 1)
public class Memo {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "memo_seq")
    private int memoId; // 메모번호

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(nullable = false)
    @JsonManagedReference
    private MemoUser user;
    
    @Column(nullable = false)
    private String content; // 메모 내용

    @CreationTimestamp
    private Timestamp createDate; // 메모 생성일
    

}
