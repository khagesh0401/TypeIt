package com.example.bean;

import java.beans.JavaBean;
import java.util.HashMap;
import java.util.Map;

@JavaBean
public class TypingAnalyticsBean {
	private int WPMAverage;
	private int AccuracyAverage;
//	private Map<String, Integer> keyMissingCount=new HashMap<>();
	public int getWPMAverage() {
		return WPMAverage;
	}
	public void setWPMAverage(int wpmAverage) {
		WPMAverage = wpmAverage;
	}
	public int getAccuracyAverage() {
		return AccuracyAverage;
	}
	public void setAccuracyAverage(int accuracyAverage) {
		AccuracyAverage = accuracyAverage;
	}
//	public Map<String, Integer> getKeyMissingCount() {
//		return keyMissingCount;
//	}
//	public void setKeyMissingCount(Map<String, Integer> keyMissingCount) {
//		this.keyMissingCount = keyMissingCount;
//	}
}
