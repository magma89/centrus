package com.project.centrus.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.project.centrus.model.Members;

public interface IGMRepository extends JpaRepository<Members, Long> {
	
	@Query(nativeQuery=true,value="SELECT A.AID,A.NAME,GM.GMID FROM GROUP_MEMBERS GM INNER JOIN Agent A ON A.AID = GM.AID WHERE GM.AGID=:agid")
	List<Members> getGroupMembers(@Param("agid") Long agid);

}
