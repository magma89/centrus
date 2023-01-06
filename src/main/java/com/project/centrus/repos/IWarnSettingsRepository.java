package com.project.centrus.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.RequestParam;

import com.project.centrus.entities.WarnSettings;
import com.project.centrus.model.WarnQueueNames;

public interface IWarnSettingsRepository extends JpaRepository<WarnSettings, Long> {
	

	

}


