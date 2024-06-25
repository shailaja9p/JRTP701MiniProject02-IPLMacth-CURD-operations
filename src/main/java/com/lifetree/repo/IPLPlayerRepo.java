package com.lifetree.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lifetree.entity.Player;

public interface IPLPlayerRepo extends JpaRepository<Player, Integer> {

}
