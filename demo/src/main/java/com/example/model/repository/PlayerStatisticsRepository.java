package com.example.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.model.PlayerStatistics;
import com.example.model.PlayerStatisticsId;

public interface PlayerStatisticsRepository extends JpaRepository<PlayerStatistics, PlayerStatisticsId> {

}
