package com.project.centrus.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.centrus.entities.TimePlan;

public interface ITimePlanRepository extends JpaRepository<TimePlan, Long> {


}
