package com.lifetree.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lifetree.entity.IPLTeam;
import com.lifetree.service.IPLTeamService;

@RestController
@RequestMapping("/iplteam/api")
public class IPLTeamOperationsController {

	@Autowired
	private IPLTeamService iplService;

	@PostMapping("/save")
	public ResponseEntity<String> saveTeam(@RequestBody IPLTeam team) {
		try {
			String msg = iplService.registerTeam(team);
			return new ResponseEntity<String>(msg, HttpStatus.CREATED);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/getTeamById/{id}")
	public ResponseEntity<?> showTeamDetailsById(@PathVariable Integer id) {
		try {
			IPLTeam team = iplService.showTeamDetailsById(id);
			return new ResponseEntity<IPLTeam>(team, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/all")
	public ResponseEntity<?> getAllTeams() {
		try {
			List<IPLTeam> allTeams = iplService.getAllTeams();
			return new ResponseEntity<List<IPLTeam>>(allTeams, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PutMapping("/update")
	public ResponseEntity<?> updateTeam(@RequestBody IPLTeam team){
		try{
			String msg=iplService.updateIPLTeam(team);
			return new ResponseEntity<String>(msg, HttpStatus.OK);
		}catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PatchMapping("/changeVenue/{id}/{venueName}")
	public ResponseEntity<?> changeVenueNameById(@PathVariable Integer id, String venueName){
		try {
			String msg = iplService.changeVenueById(id, venueName);
			return new ResponseEntity<String>(msg, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deleteTeamById(@PathVariable Integer id){
		try {
			String msg = iplService.deleteTeam(id);
			return new ResponseEntity<String>(msg, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
