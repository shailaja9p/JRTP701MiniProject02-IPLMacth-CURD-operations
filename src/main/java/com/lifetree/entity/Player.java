package com.lifetree.entity;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Table(name="Player")
public class Player {
	@Id
	@SequenceGenerator(name="generator1",sequenceName = "player_seq",initialValue = 100, allocationSize = 1)
	@GeneratedValue(generator = "generator1", strategy = GenerationType.SEQUENCE)
	@Column(name="PLAYER_ID")
	private Integer playerId;
	@Column(name="PLAYER_NAME",length = 30)
	private String playerName;
	@Column(name="SPECIALIZATION",length = 30)
	private String specialization;
	@Column(name="MATCHES_PLAYED")
	private Integer matchesPlayed;
		
	@Column(name="DATE_OF_BIRTH",updatable = false)
	//@CreationTimestamp
	private LocalDateTime dob;
	/*
	 * @ManyToOne(targetEntity=IPLTeam.class, cascade = CascadeType.ALL)
	 * 
	 * @JoinColumn(name="TeamID",referencedColumnName="TEAM_ID")
	
	private IPLTeam team; */
}
