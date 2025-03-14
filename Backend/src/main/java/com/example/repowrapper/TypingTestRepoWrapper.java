package com.example.repowrapper;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.bean.TypingTestBean;
import com.example.bean.UserBean;
import com.example.entity.TypingTestEntity;
import com.example.entity.UserEntity;
import com.example.repo.TypingTestRepo;

import java.util.Optional;

@Component
public class TypingTestRepoWrapper {
	
	@Autowired
	public TypingTestRepo typingTestRepo;


	public TypingTestEntity save(TypingTestEntity testEntity) {
		return typingTestRepo.save(testEntity);
	}

	public TypingTestEntity findTypingTestEntityById(int testId) {
		return typingTestRepo.findById(testId).orElse(null);
	}
	
	public TypingTestBean entitytoBean(TypingTestEntity typingTestEntity) {
		TypingTestBean typingTestBean = new TypingTestBean();
		BeanUtils.copyProperties(typingTestEntity, typingTestBean);
		return typingTestBean;
	}

	public TypingTestBean saveTypingTest(TypingTestBean typingTestBean) {
		TypingTestEntity entity = new TypingTestEntity();
		entity.setId(typingTestBean.getTestId());  // Set the test ID
		entity.setWpm(typingTestBean.getWpm());
		entity.setDuration(typingTestBean.getDuration());

		TypingTestEntity savedEntity = typingTestRepo.save(entity);

		// Convert back to TypingTestBean if needed
		typingTestBean.setTestId(savedEntity.getId());
		return typingTestBean;
	}
}
