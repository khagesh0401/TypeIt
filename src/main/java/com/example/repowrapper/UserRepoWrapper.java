package com.example.repowrapper;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.bean.UserBean;
import com.example.entity.UserEntity;
import com.example.repo.UserRepo;

@Component
public class UserRepoWrapper {
	
	@Autowired
	public UserRepo userRepo;
	
	public int saveUser(UserBean userBean) {
		UserEntity userEntity= beantoEntity(userBean);
		userRepo.save(userEntity);
		return userEntity.getId();
	}
	
	public UserEntity findById(int userId) {
		UserEntity userEntity = userRepo.findById(userId);
		return userEntity;
	}
	
	public UserEntity beantoEntity(UserBean userBean) {
		UserEntity userEntity= new UserEntity();
		BeanUtils.copyProperties(userBean, userEntity);
		return userEntity;
	}
	
	public UserBean entitytoBean(UserEntity userEntity) {
		UserBean userBean= new UserBean();
		BeanUtils.copyProperties(userEntity, userBean);
		return userBean;
	}
}
