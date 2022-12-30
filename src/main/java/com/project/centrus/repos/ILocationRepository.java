package com.project.centrus.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.centrus.entities.Location;

public interface ILocationRepository extends JpaRepository<Location, Long> {

}
