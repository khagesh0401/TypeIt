package com.example.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.entity.TypingTestEntity;


@Repository
public interface TypingTestRepo extends JpaRepository<TypingTestEntity, Integer>{
	public TypingTestEntity save(TypingTestEntity typingTestEntity);
	
	public TypingTestEntity findById(int id);
}
	 