package com.haza.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.haza.model.Memo;

public interface MemoRepository extends JpaRepository<Memo, Integer> {

}
