package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.bean.TypingAnalyticsBean;
import com.example.bean.TypingTestBean;
import com.example.entity.TypingAnalyticsEntity;
import com.example.repowrapper.TypingAnalyticsRepoWrapper;

@Service
public class TypingAnalyticsService {
	@Autowired
	public TypingAnalyticsRepoWrapper typingAnalyticsRepoWrapper;
	
	public TypingAnalyticsBean updateDataService(TypingTestBean typingTestBean,int userId) {
		TypingAnalyticsEntity typingAnalyticsEntity=typingAnalyticsRepoWrapper.findByIdWrapper(userId);
		if(typingAnalyticsEntity!=null) {
			int avgwpm=(typingAnalyticsEntity.getWPMAverage()+typingTestBean.getWpm())/2;
			int avgAccuracy=(typingAnalyticsEntity.getAccuracyAverage()+typingTestBean.getAccuracy())/2;
			typingAnalyticsEntity.setWPMAverage(avgwpm);
			typingAnalyticsEntity.setAccuracyAverage(avgAccuracy);
			return typingAnalyticsRepoWrapper.updateData(typingAnalyticsEntity,userId);
			}
		return null;
	}
}
