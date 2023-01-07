package com.project.centrus.services;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.project.centrus.entities.SuspendReason;
import com.project.centrus.entities.TimePlan;
import com.project.centrus.entities.TimePlanDetail;
import com.project.centrus.model.TimeModel;
import com.project.centrus.repos.ITimeModelRepository;
import com.project.centrus.repos.ITimePlanDetailRepository;
import com.project.centrus.repos.ITimePlanRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class TimePlanServices {

	ITimePlanRepository timePlanRepository;
	ITimePlanDetailRepository timePlanDetailRepository;
	ITimeModelRepository timeModelRepository;

	public TimePlanServices(ITimePlanRepository timePlanRepository, ITimePlanDetailRepository timePlanDetailRepository,
			ITimeModelRepository timeModelRepository) {
		this.timePlanRepository = timePlanRepository;
		this.timePlanDetailRepository = timePlanDetailRepository;
		this.timeModelRepository = timeModelRepository;
	}

	public List<TimePlan> getTimePlan() {
		Date date = new Date();
		log.info("Time Plan + " + date);
		return timePlanRepository.findAll();
	}

	public ResponseEntity<Object> addTimePlan(String message, HttpStatus status, @RequestBody TimePlan newtimePlan) {
		TimePlan timePlan = new TimePlan();
		timePlan.setTimePlanName(newtimePlan.getTimePlanName());
		timePlan.setQid(newtimePlan.getQid());
		timePlanRepository.save(timePlan);
		TimePlanDetail timePlanDetail = new TimePlanDetail();
		timePlanDetail.setMonStart(newtimePlan.getMonStart());
		timePlanDetail.setMonEnd(newtimePlan.getMonEnd());
		timePlanDetail.setTueStart(newtimePlan.getTueStart());
		timePlanDetail.setTueEnd(newtimePlan.getTueEnd());
		timePlanDetail.setWedStart(newtimePlan.getWedStart());
		timePlanDetail.setWedEnd(newtimePlan.getWedEnd());
		timePlanDetail.setThuStart(newtimePlan.getThuStart());
		timePlanDetail.setThuEnd(newtimePlan.getThuEnd());
		timePlanDetail.setFriStart(newtimePlan.getFriStart());
		timePlanDetail.setFriEnd(newtimePlan.getFriEnd());
		timePlanDetail.setSatStart(newtimePlan.getSatStart());
		timePlanDetail.setSatEnd(newtimePlan.getSatEnd());
		timePlanDetail.setSunStart(newtimePlan.getSunStart());
		timePlanDetail.setSunEnd(newtimePlan.getSunEnd());
		timePlanDetail.setTimePlanId(timePlan.getTimePlanId());
		timePlanDetailRepository.save(timePlanDetail);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("message", message);
		map.put("status", status.value());
		map.put("tpid", timePlan.getTimePlanId());
		return new ResponseEntity<Object>(map, status);
	}

	public ResponseEntity<Object> deleteTimePlan(String message, HttpStatus status, @PathVariable Long tid) {
		timePlanRepository.deleteById(tid);
		timePlanDetailRepository.deleteById(tid);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("message", message);
		map.put("status", status.value());
		map.put("tpid", tid);
		return new ResponseEntity<Object>(map, status);
	}

	public ResponseEntity<Object> updateTimePlan(String message, HttpStatus status, @PathVariable Long tid,
			@RequestBody TimePlan updateTimePlan) {
		Optional<TimePlan> timePlan = timePlanRepository.findById(tid);
		Optional<TimePlanDetail> timePlanDetail = timePlanDetailRepository.findById(tid);
		if (timePlan.isPresent()) {
			TimePlan timePlans = timePlan.get();
			timePlans.setTimePlanName(updateTimePlan.getTimePlanName());
			timePlanRepository.save(timePlans);
			
			TimePlanDetail timePlanDetails = timePlanDetail.get();
			timePlanDetails.setMonStart(updateTimePlan.getMonStart());
			timePlanDetails.setMonEnd(updateTimePlan.getMonEnd());
			timePlanDetails.setTueStart(updateTimePlan.getTueStart());
			timePlanDetails.setTueEnd(updateTimePlan.getTueEnd());
			timePlanDetails.setWedStart(updateTimePlan.getWedStart());
			timePlanDetails.setWedEnd(updateTimePlan.getWedEnd());
			timePlanDetails.setThuStart(updateTimePlan.getThuStart());
			timePlanDetails.setThuEnd(updateTimePlan.getThuEnd());
			timePlanDetails.setFriStart(updateTimePlan.getFriStart());
			timePlanDetails.setFriEnd(updateTimePlan.getFriEnd());
			timePlanDetails.setSatStart(updateTimePlan.getSatStart());
			timePlanDetails.setSatEnd(updateTimePlan.getSatEnd());
			timePlanDetails.setSunStart(updateTimePlan.getSunStart());
			timePlanDetails.setSunEnd(updateTimePlan.getSunEnd());
			timePlanDetails.setTimePlanId(updateTimePlan.getTimePlanId());
			timePlanDetailRepository.save(timePlanDetails);
			
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("message", message);
			map.put("status", status.value());
			map.put("updateid", tid);
			return new ResponseEntity<Object>(map, status);
		} else {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("message", message);
			map.put("status", status.value());
			map.put("data", "Id Not Found");
			return new ResponseEntity<Object>(map, status);
		}
	}

	public List<TimeModel> timePlanDetail(@PathVariable Long tid) {
		return timeModelRepository.getDetailTimePlan(tid);
//		List<TimeModel> detailTimePlan = new ArrayList<>();
//		Optional<TimePlan> getTimePlan = timePlanRepository.findById(tid);
//		for(TimePlan tempTimePlan : getTimePlan) {
//			detailTimePlan.add(new TimeModel(tempTimePlan.getTimePlanName(), tempTimePlan.getMonStart(), tempTimePlan.getMonEnd(), tempTimePlan.getTueStart(), tempTimePlan.getTueEnd(),
//								tempTimePlan.ge, null, null, null, null, null, null, null, null, null, null) )
//		}
	}

}
