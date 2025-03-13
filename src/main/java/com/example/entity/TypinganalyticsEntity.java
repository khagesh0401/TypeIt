package com.example.entity;

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
public class TypinganalyticsEntity {
	
	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY )
	private int id;
	@Column(nullable = false)
	private int WPMAverage;
	@ElementCollection
	private Map<String, Integer> keyMissingCount;
	
	@OneToOne
	private UserEntity userEntity;
	
}
