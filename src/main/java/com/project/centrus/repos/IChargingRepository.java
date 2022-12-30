package com.project.centrus.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.centrus.entities.ChargingSystem;

public interface IChargingRepository extends JpaRepository<ChargingSystem, Long> {

}
