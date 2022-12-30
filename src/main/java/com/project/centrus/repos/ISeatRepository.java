package com.project.centrus.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.centrus.entities.Seat;

public interface ISeatRepository extends JpaRepository<Seat, Long> {

}
