package com.lifetree.service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lifetree.config.AppConfigProperties;
import com.lifetree.constants.IPLConstants;
import com.lifetree.entity.IPLTeam;
import com.lifetree.repo.IPLTeamRepo;

@Service
public class IPLTeamServiceImpl implements IPLTeamService {

	@Autowired
	private IPLTeamRepo teamRepo;
	
	private Map<String,String> messages;
	
	@Autowired
	public IPLTeamServiceImpl(AppConfigProperties props) {
		messages=props.getMessages();
		System.out.println("messages::"+this.messages);
	}

	@Override
	public String registerTeam(IPLTeam team) {

		IPLTeam savedTeam = teamRepo.save(team);
		return savedTeam.getTeamId() != null ?messages.get(IPLConstants.SAVESUCCESS)+ savedTeam.getTeamId():messages.get(IPLConstants.SAVEFAILURE);
	}

	@Override
	public IPLTeam showTeamDetailsById(Integer id) {
			return teamRepo.findById(id).orElseThrow(()->new IllegalArgumentException(messages.get(IPLConstants.FINDBYIDFAILURE)));
	}

	@Override
	public List<IPLTeam> getAllTeams() {
		List<IPLTeam> all = teamRepo.findAll();
		return all;
	}

	@Override
	public String updateIPLTeam(IPLTeam team) {
		Optional<IPLTeam> opt = teamRepo.findById(team.getTeamId());
		if(opt.isPresent()) {
			teamRepo.save(team);
			return team.getTeamId()+messages.get(IPLConstants.UPDATESUCCESS);
		}else {
			return team.getTeamId()+messages.get(IPLConstants.UPDATEFAILURE);
		}
	}
	@Override
	public String changeVenueById(Integer id,String venue) {
		Optional<IPLTeam> opt = teamRepo.findById(id);
		if (opt.isPresent()) {
			IPLTeam team = opt.get();
			team.setVenue(venue);
			teamRepo.save(team);
			return id+messages.get(IPLConstants.VENUECHANGESUCCESS);
		}
		else {
			return id+messages.get(IPLConstants.VENUECHANGEFAILURE);
		}
	}

	@Override
	public String deleteTeam(Integer id) {
		Optional<IPLTeam> opt = teamRepo.findById(id);
		if (opt.isPresent()) {
			teamRepo.deleteById(id);
			return id+messages.get(IPLConstants.DELETESUCCESS);
		}else {
			return id+messages.get(IPLConstants.DELETEFAILURE);
		}
	}

	
}
