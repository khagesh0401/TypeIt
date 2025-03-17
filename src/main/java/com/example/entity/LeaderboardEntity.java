package com.example.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "leaderboard")
public class LeaderBoardEntity {
	
	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY )
	private int id;
	@Column(nullable = false)
	private int accuracyBest;
	@Column(nullable = false)
	private int WPMBest;
	
	@ManyToOne
	@JoinColumn(name = "userId")
	private UserEntity userEntity;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getAccuracyBest() {
		return accuracyBest;
	}

	public void setAccuracyBest(int accuracyBest) {
		this.accuracyBest = accuracyBest;
	}

	public int getWPMBest() {
		return WPMBest;
	}

	public void setWPMBest(int wPMBest) {
		WPMBest = wPMBest;
	}

	public UserEntity getUserEntity() {
		return userEntity;
	}

	public void setUserEntity(UserEntity userEntity) {
		this.userEntity = userEntity;
	}
	
	public LeaderBoardEntity() {}
}
