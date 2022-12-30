package com.project.centrus.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.centrus.entities.WarnSettings;

public interface IWarnSettingsRepository extends JpaRepository<WarnSettings, Long> {

}
