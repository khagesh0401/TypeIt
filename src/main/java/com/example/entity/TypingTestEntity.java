	package com.example.entity;

import java.time.LocalDateTime;

import org.hibernate.annotations.CurrentTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
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
	private int duration;
	
	private LocalDateTime completed_at;
	

	@ManyToOne
	@JoinColumn(name = "userId")
	private UserEntity userEntity;
	
	@ManyToOne
	@JoinColumn(name = "textId")
	private TextEntity textEntity;
}
