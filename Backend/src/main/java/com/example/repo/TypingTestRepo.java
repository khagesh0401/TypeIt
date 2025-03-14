package com.example.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.entity.TypingTestEntity;
import java.util.List;
import java.util.Optional;


@Repository
public interface TypingTestRepo extends JpaRepository<TypingTestEntity, Integer>{
	public TypingTestEntity save(TypingTestEntity typingTestEntity);

	Optional<TypingTestEntity> findById(Integer id);
}
