package com.project.centrus.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.project.centrus.model.TimeModel;

public interface ITimeModelRepository extends JpaRepository<TimeModel, Long> {
	
	 @Query(nativeQuery=true,value="SELECT TP.TIME_PLAN_NAME,TP.QID,TPD.MON_START\r\n"
		 		+ ",MON_END,TPD.TUE_START,TPD.TUE_END,TPD.WED_START,TPD.WED_END,\r\n"
		 		+ "TPD.THU_START,TPD.THU_END,TPD.FRI_START,TPD.FRI_END,\r\n"
		 		+ "TPD.SAT_START,TPD.SAT_END,TPD.SUN_START,TPD.SUN_END\r\n"
		 		+ "FROM TIME_PLAN TP\r\n"
		 		+ "INNER JOIN TIME_PLAN_DETAIL TPD ON TP.TIME_PLAN_ID = TPD.TIME_PLAN_ID\r\n"
		 		+ "WHERE TP.TIME_PLAN_ID= :tid")
		 List<TimeModel> getDetailTimePlan(@Param("tid") Long tid);

}
