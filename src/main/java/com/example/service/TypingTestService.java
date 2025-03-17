package com.example.service;

import java.time.Duration;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.bean.TypingTestBean;
import com.example.bean.UserBean;
import com.example.entity.TypingTestEntity;
import com.example.repowrapper.TextRepoWrapper;
import com.example.repowrapper.TypingTestRepoWrapper;

@Service
public class TypingTestService {

	@Autowired
	public TypingTestRepoWrapper typingTestRepoWrapper;
	
	@Autowired
	public TextRepoWrapper textRepoWrapper;
	
	public TypingTestBean saveTypingTestService(TypingTestBean typingTestBean,int userId,int textId) {
		int wpm=calculateTypingSpeed(typingTestBean.getWpm(), typingTestBean.getDuration());
		long duration = calculateDuration();
		return typingTestRepoWrapper.saveTypingTest(typingTestBean,userId,textId);
	}
	
	//something is not right
	public int startTypingTest() {
		LocalDateTime startTime=LocalDateTime.now();
		TypingTestEntity testEntity=new TypingTestEntity();
		testEntity.setStartTime(startTime);
		typingTestRepoWrapper.typingTestRepo.save(testEntity);
		return testEntity.getId();
	}
	
	public void stopTypingTest(int testId) {
		TypingTestEntity testEntity= typingTestRepoWrapper.findTypingTestEntityById(testId);
		if(testEntity==null) {
			System.out.print("Test Not Found");
		}
		LocalDateTime stopTime=LocalDateTime.now();
		testEntity.setStopTime(stopTime);
		typingTestRepoWrapper.typingTestRepo.save(testEntity);
		 
	}
	
	public long calculateDuration() {
		int testId=startTypingTest();
		TypingTestEntity testEntity= typingTestRepoWrapper.findTypingTestEntityById(testId);
		return Duration.between(testEntity.getStartTime(), testEntity.getStopTime()).toSeconds();
	}
	
	public int calculateTypingSpeed(int totalNumberOfWords, int timeTakenInSeconds) {
		return (totalNumberOfWords*60)/timeTakenInSeconds;
	}
}
