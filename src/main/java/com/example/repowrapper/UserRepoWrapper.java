package com.example.repowrapper;

import java.beans.Beans;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.bean.UserBean;
import com.example.entity.UserEntity;
import com.example.repo.UserRepo;

import ch.qos.logback.core.joran.util.beans.BeanUtil;
@Component
public class UserRepoWrapper {
	
	@Autowired
	public UserRepo userRepo;
	
	public int saveUser(UserBean userBean) {
		UserEntity userEntity= beantoEntity(userBean);
		userRepo.save(userEntity);
		return userEntity.getId();
	}
	
	public UserEntity beantoEntity(UserBean userBean) {
		UserEntity userEntity= new UserEntity();
		BeanUtils.copyProperties(userBean, userEntity);
		return userEntity;
	}
}
