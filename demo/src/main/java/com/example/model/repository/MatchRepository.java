package com.example.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.model.Match;
import com.example.model.MatchKey;

public interface MatchRepository extends JpaRepository<Match, MatchKey> {

}
