package com.project.centrus.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.centrus.entities.QueueAgentGroup;

public interface IQueueAgentGroup extends JpaRepository<QueueAgentGroup, Long> {

}
