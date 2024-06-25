package com.lifetree.service;

import java.util.List;

import com.lifetree.entity.IPLTeam;

public interface IPLTeamService {

	public String registerTeam(IPLTeam team);
	public IPLTeam showTeamDetailsById(Integer id);
	public List<IPLTeam> getAllTeams();
	public String updateIPLTeam(IPLTeam team);
	public String deleteTeam(Integer id);
	public String changeVenueById(Integer id,String venue);
	
}
