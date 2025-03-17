package com.example.entity;

import java.time.LocalDateTime;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "typingtest")
public class TypingTestEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(nullable = false)
	private int wpm;
	
	@Column(nullable = false)
	private int accuracy;
	
	@Column(nullable = false)
	private long duration;
	
	private LocalDateTime completed_at;
	
	//Unable to create typingtest table
	
	//mapping issues, ig, need only 1 table i think, an
	@ManyToOne
	@JoinColumn(name = "userId")
	private UserEntity userEntity;
	
	@ManyToOne
	@JoinColumn(name = "textId")
	private TextEntity textEntity;
	
	private LocalDateTime startTime;
	private LocalDateTime stopTime;
	
	
	public LocalDateTime getStartTime() {
		return startTime;
	}

	public void setStartTime(LocalDateTime startTime) {
		this.startTime = startTime;
	}

	public LocalDateTime getStopTime() {
		return stopTime;
	}

	public void setStopTime(LocalDateTime stopTime) {
		this.stopTime = stopTime;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public long getDuration() {
		return duration;
	}

	public void setDuration(long duration) {
		this.duration = duration;
	}

	public LocalDateTime getCompleted_at() {
		return completed_at;
	}

	public void setCompleted_at(LocalDateTime completed_at) {
		this.completed_at = completed_at;
	}

	public UserEntity getUserEntity() {
		return userEntity;
	}

	public void setUserEntity(UserEntity userEntity) {
		this.userEntity = userEntity;
	}

	public TextEntity getTextEntity() {
		return textEntity;
	}

	public void setTextEntity(TextEntity textEntity) {
		this.textEntity = textEntity;
	}
	
	public TypingTestEntity() {}
	
}
