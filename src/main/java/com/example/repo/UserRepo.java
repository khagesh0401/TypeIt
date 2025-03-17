package com.example.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.entity.UserEntity;
import java.util.List;


@Repository
public interface UserRepo extends JpaRepository<UserEntity, Integer>{
	public UserEntity save(UserEntity user);
	
	public UserEntity findById(int id);
}
