package com.haza.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.haza.model.Memo;
import com.haza.model.MemoUser;

public interface MemoRepository extends JpaRepository<Memo, Integer> {

	List<Memo> findByUser(MemoUser currentUser);

}
