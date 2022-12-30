package com.project.centrus.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.centrus.entities.Settings;

public interface ISettingsRepository extends JpaRepository<Settings, Long> {

}
