package com.example.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.model.Player;

public interface PlayerRepository extends JpaRepository<Player, Long> {

}
