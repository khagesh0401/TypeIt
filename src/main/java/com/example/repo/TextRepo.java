package com.example.repo;

import java.awt.event.TextEvent;
import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.entity.TextEntity;

@Repository
public interface TextRepo extends JpaRepository<TextEntity, Integer>{
	@Query(value = "SELECT * FROM texts order by RAND() LIMIT 1",nativeQuery = true)
	public TextEntity findRandomText();
	
	@Query(value = "SELECT * FROM texts",nativeQuery = true)
	public List<TextEntity> findAll();
	
	public TextEntity findById(int id);
}
