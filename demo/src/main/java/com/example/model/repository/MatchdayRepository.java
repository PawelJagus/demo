package com.example.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.model.Matchday;

public interface MatchdayRepository extends JpaRepository<Matchday, Integer> {

}
