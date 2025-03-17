package com.example.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.entity.TypingAnalyticsEntity;

@Repository
public interface TypingAnalyticsRepo extends JpaRepository<TypingAnalyticsEntity, Integer>{
	public TypingAnalyticsEntity save(TypingAnalyticsEntity typingAnalyticsEntity);
	
	public TypingAnalyticsEntity findByUserEntity_UserId(int id);
}