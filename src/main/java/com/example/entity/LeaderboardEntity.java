package com.example.entity;

import org.apache.el.parser.AstFalse;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
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
	
}
