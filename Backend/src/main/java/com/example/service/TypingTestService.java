package com.example.service;

import java.time.Duration;
import java.time.LocalDateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.bean.TypingTestBean;
import com.example.entity.TypingTestEntity;
import com.example.repowrapper.TypingTestRepoWrapper;

@Service
public class TypingTestService {

	@Autowired
	private TypingTestRepoWrapper typingTestRepoWrapper;

	/**
	 * Saves typing test result after calculating WPM and duration
	 */
	public TypingTestBean saveTypingTestService(TypingTestBean typingTestBean) {
		if (typingTestBean.getTestId() == null) {
			throw new RuntimeException("Test ID is required!");
		}

		TypingTestEntity testEntity = typingTestRepoWrapper.findTypingTestEntityById(typingTestBean.getTestId());

		if (testEntity == null) {
			throw new RuntimeException("Typing test not found for ID: " + typingTestBean.getTestId());
		}
		if (testEntity.getStopTime() == null) {
			throw new RuntimeException("Typing test has not been stopped yet!");
		}

		long duration = calculateDuration(testEntity);
		int wpm = calculateTypingSpeed(typingTestBean.getTotalWords(), (int) duration);

		typingTestBean.setWpm(wpm);
		typingTestBean.setDuration((int) duration);

		return typingTestRepoWrapper.saveTypingTest(typingTestBean);
	}


	/**
	 * Starts a new typing test and returns its ID.
	 */
	public int startTypingTest() {
		TypingTestEntity testEntity = new TypingTestEntity();
		testEntity.setStartTime(LocalDateTime.now());

		// Save to database to get generated ID
		testEntity = typingTestRepoWrapper.save(testEntity);
		return testEntity.getId();
	}

	/**
	 * Stops the typing test by setting stop time.
	 */
	public void stopTypingTest(int testId) {
		TypingTestEntity testEntity = typingTestRepoWrapper.findTypingTestEntityById(testId);

		if (testEntity == null) {
			throw new RuntimeException("Test Not Found");
		}

		testEntity.setStopTime(LocalDateTime.now());
		typingTestRepoWrapper.save(testEntity);
	}

	/**
	 * Calculates duration of the typing test
	 */
	public long calculateDuration(TypingTestEntity testEntity) {
		return Duration.between(testEntity.getStartTime(), testEntity.getStopTime()).toSeconds();
	}

	/**
	 * Calculates typing speed in words per minute (WPM)
	 */
	public int calculateTypingSpeed(int totalNumberOfWords, int timeTakenInSeconds) {
		if (timeTakenInSeconds == 0) return 0;
		return (totalNumberOfWords * 60) / timeTakenInSeconds;
	}
}
