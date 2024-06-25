package com.lifetree.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@Table(name="IPL_Team")
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class IPLTeam {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO )
	@Column(name="TEAM_ID")
	private Integer teamId;
	
	@Column(name="TEAM_NAME",length = 30)
	private String teamName;
	@Column(name="TEAM_SIZE")
	private Integer teamSize;
	@Column(name="COUCH_NAME",length = 30)
	private String coachName;
	@Column(name="VENUE_NAME",length = 30)
	private String venue;
	@Column(name="CAPTAIN_NAME",length = 30)
	private String captainName;
	
	@OneToMany(targetEntity=Player.class, cascade = CascadeType.ALL )
	@JoinColumn(name="iplTeam_fk",referencedColumnName="TEAM_ID")
	private List<Player> playersDetails;
	
	@Override
	public String toString() {
		return "IPLTeam [Teamid= "+teamId+"  TeamName= "+teamName+" TeamSize= "+teamSize+" Coach name "+coachName+" Venue= "+venue+" PlayersList= "+playersDetails;
	}
}
