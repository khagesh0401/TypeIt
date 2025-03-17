package com.example.repowrapper;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.example.bean.TypingAnalyticsBean;
import com.example.entity.TypingAnalyticsEntity;
import com.example.entity.UserEntity;
import com.example.repo.TypingAnalyticsRepo;

@Component
public class TypingAnalyticsRepoWrapper {
	@Autowired
	public TypingAnalyticsRepo typingAnalyticsRepo;
	@Autowired
	public UserRepoWrapper userRepoWrapper;

	
	public TypingAnalyticsBean updateData(TypingAnalyticsEntity typingAnalyticsEntity,int userId) {
		TypingAnalyticsEntity typingAnalyticsEntity2=findByIdWrapper(userId);
		typingAnalyticsEntity2.setAccuracyAverage(typingAnalyticsEntity.getAccuracyAverage());
		typingAnalyticsEntity2.setWPMAverage(typingAnalyticsEntity.getWPMAverage());
		typingAnalyticsRepo.save(typingAnalyticsEntity2);
		return entitytoBean(typingAnalyticsEntity2);
	}
	
	public TypingAnalyticsEntity findByIdWrapper(int UserId) {
		TypingAnalyticsEntity typingAnalyticsEntity=typingAnalyticsRepo.findByUserEntity_UserId(UserId);
		if(typingAnalyticsEntity==null)
			return null;
		return typingAnalyticsEntity;
	}
	
	public TypingAnalyticsEntity beantoEntity(TypingAnalyticsBean typingAnalyticsBean) {
		TypingAnalyticsEntity typingAnalyticsEntity= new TypingAnalyticsEntity();
		BeanUtils.copyProperties(typingAnalyticsBean, typingAnalyticsEntity);
		return typingAnalyticsEntity;
	}
	
	public TypingAnalyticsBean entitytoBean(TypingAnalyticsEntity typingTestEntity) {
		TypingAnalyticsBean typingAnalyticsBean = new TypingAnalyticsBean();
		BeanUtils.copyProperties(typingTestEntity, typingAnalyticsBean);
		return typingAnalyticsBean;
	}
}
