package com.example.repowrapper;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.example.bean.TypingAnalyticsBean;
import com.example.entity.TypingAnalyticsEntity;
import com.example.repo.TypingAnalyticsRepo;

@Component
public class TypingAnalyticsRepoWrapper {
	@Autowired
	public TypingAnalyticsRepo typingAnalyticsRepo;
	
	@Autowired
	public UserRepoWrapper userRepoWrapper;
	
	public TypingAnalyticsBean updateData(TypingAnalyticsBean typingAnalyticsBean,int userId) {
//		TypingAnalyticsEntity typingAnalyticsEntity=beantoEntity(typingAnalyticsBean);
		
		TypingAnalyticsEntity typingAnalyticsEntity=beantoEntity(findByIdWrapper(userId));
		//only retrieving accuracy not others
		System.out.println(typingAnalyticsEntity.getUserEntity());
		System.out.println(typingAnalyticsEntity.getWPMAverage());
		System.out.println(typingAnalyticsEntity.getAccuracyAverage());
		typingAnalyticsEntity.setAccuracyAverage(typingAnalyticsBean.getAccuracyAverage());
		typingAnalyticsEntity.setWPMAverage(typingAnalyticsBean.getWPMAverage());
		
//		typingAnalyticsEntity.setUserEntity(userRepoWrapper.findById(userId));
		typingAnalyticsRepo.save(typingAnalyticsEntity);
		return typingAnalyticsBean;
	}
	
	public TypingAnalyticsBean findByIdWrapper(int UserId) {
		TypingAnalyticsEntity typingAnalyticsEntity=typingAnalyticsRepo.findByUserEntity_UserId(UserId);
		if(typingAnalyticsEntity==null)
			return null;
		return entitytoBean(typingAnalyticsEntity);
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
