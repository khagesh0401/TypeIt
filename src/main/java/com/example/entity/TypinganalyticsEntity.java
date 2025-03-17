package com.example.entity;

import java.util.HashMap;
import java.util.Map;

import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "typinganalytics")
public class TypingAnalyticsEntity {
	
	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY )
	private int id;
	@Column(name = "wpmaverage",nullable = false)
	private int WPMAverage;
	@Column(nullable = false)
	private int AccuracyAverage;
//	@ElementCollection
//	private Map<String, Integer> keyMissingCount=new HashMap<>();
	
	@OneToOne
	private UserEntity userEntity;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getWPMAverage() {
		return WPMAverage;
	}

	public void setWPMAverage(int wPMAverage) {
		WPMAverage = wPMAverage;
	}

//	public Map<String, Integer> getKeyMissingCount() {
//		return keyMissingCount;
//	}
//
//	public void setKeyMissingCount(Map<String, Integer> keyMissingCount) {
//		this.keyMissingCount = keyMissingCount;
//	}

	public UserEntity getUserEntity() {
		return userEntity;
	}

	public void setUserEntity(UserEntity userEntity) {
		this.userEntity = userEntity;
	}
	
	public int getAccuracyAverage() {
		return AccuracyAverage;
	}

	public void setAccuracyAverage(int accuracyAverage) {
		AccuracyAverage = accuracyAverage;
	}

	public TypingAnalyticsEntity() {}
}
