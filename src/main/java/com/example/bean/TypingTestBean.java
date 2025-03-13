package com.example.bean;

import java.beans.JavaBean;
import java.time.LocalDateTime;

@JavaBean
public class TypingTestBean {
	private int wpm;
	private int accuracy;
	private int duration;
	private LocalDateTime complete_at;
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
	
}
