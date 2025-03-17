package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.bean.TypingAnalyticsBean;
import com.example.bean.TypingTestBean;
import com.example.repowrapper.TypingAnalyticsRepoWrapper;

@Service
public class TypingAnalyticsService {
	@Autowired
	public TypingAnalyticsRepoWrapper typingAnalyticsRepoWrapper;
	
	public TypingAnalyticsBean updateDataService(TypingTestBean typingTestBean,int userId) {
		//i dont want new entry, need to avergae it and update same
		TypingAnalyticsBean typingAnalyticsBean=typingAnalyticsRepoWrapper.findByIdWrapper(userId);
		if(typingAnalyticsBean!=null) {
			int avgwpm=(typingAnalyticsBean.getWPMAverage()+typingTestBean.getWpm())/2;
			int avgAccuracy=(typingAnalyticsBean.getAccuracyAverage()+typingTestBean.getAccuracy())/2;
			typingAnalyticsBean.setAccuracyAverage(avgAccuracy);
			typingAnalyticsBean.setWPMAverage(avgwpm);
			return typingAnalyticsRepoWrapper.updateData(typingAnalyticsBean,userId);
			}
		return null;
	}
}
