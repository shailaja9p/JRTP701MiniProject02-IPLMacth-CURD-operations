package com.lifetree.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lifetree.entity.IPLTeam;

public interface IPLTeamRepo extends JpaRepository<IPLTeam, Integer> {

}
