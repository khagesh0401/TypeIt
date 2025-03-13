package com.example.repowrapper;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.bean.TypingTestBean;
import com.example.bean.UserBean;
import com.example.entity.TypingTestEntity;
import com.example.entity.UserEntity;
import com.example.repo.TypingTestRepo;

@Component
public class TypingTestRepoWrapper {
	
	@Autowired
	public TypingTestRepo typingTestRepo;
	
	@Autowired
	public UserRepoWrapper userRepoWrapper;
	
	public TypingTestBean saveTypingTest(TypingTestBean typingTestBean,UserBean user) {
		UserEntity userEntity=userRepoWrapper.beantoEntity(user);
		TypingTestEntity typingTestEntity=beantoEntity(typingTestBean);
		typingTestEntity.setUserEntity(userEntity);
		return typingTestBean;
	}
	
	public TypingTestEntity findTypingTestEntityById(int id) {
		return typingTestRepo.findById(id);
	}
	
	public TypingTestEntity beantoEntity(TypingTestBean typingTestBean) {
		TypingTestEntity typingTestEntity= new TypingTestEntity();
		BeanUtils.copyProperties(typingTestBean, typingTestEntity);
		return typingTestEntity;
	}
	
	public TypingTestBean entitytoBean(TypingTestEntity typingTestEntity) {
		TypingTestBean typingTestBean = new TypingTestBean();
		BeanUtils.copyProperties(typingTestEntity, typingTestBean);
		return typingTestBean;
	}
}
