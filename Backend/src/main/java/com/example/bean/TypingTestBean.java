package com.example.bean;

import java.beans.JavaBean;
import java.time.LocalDateTime;

@JavaBean
public class TypingTestBean {
	private Integer testId;
	private Long userId;
	private int wpm;
	private int accuracy;
	private int duration;
	private LocalDateTime complete_at;
	private int totalWords;

	public Integer getTestId() {
		return testId;
	}

	public void setTestId(int testId) {
		this.testId = testId;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public int getWpm() {
		return wpm;
	}
	public void setWpm(int wpm) {
		this.wpm = wpm;
	}
	public int getAccuracy() {
		return accuracy;
	}
	public void setAccuracy(int accuracy) {
		this.accuracy = accuracy;
	}
	public int getDuration() {
		return duration;
	}
	public void setDuration(int duration) {
		this.duration = duration;
	}
	public LocalDateTime getComplete_at() {
		return complete_at;
	}
	public void setComplete_at(LocalDateTime complete_at) {
		this.complete_at = complete_at;
	}

	public int getTotalWords() {
		return totalWords;
	}

	public void setTotalWords(int totalWords) {
		this.totalWords = totalWords;
	}
}
