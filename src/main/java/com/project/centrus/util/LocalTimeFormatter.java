package com.project.centrus.util;

import java.time.LocalTime;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class LocalTimeFormatter {
	
	public String getConverter(String parameter,int type) {
		
		// type = 0 (milliseconds)
		// type = 1 (seconds)
		
		if(type == 0 ) {
		if (parameter == null) {
			parameter ="0";
		}
		
		double convertDouble = Double.parseDouble(parameter);
		int convertInteger = (int) convertDouble;
		LocalTime convertLocalTime = LocalTime.ofSecondOfDay(convertInteger / 1000);
		String value = convertLocalTime.toString();
		return value;
		
		}else if (type == 1) {
			
			if (parameter == null) {
				parameter ="0";
			}
			  
			
			double convertDouble = Double.parseDouble(parameter);
			int convertInteger = (int) convertDouble;
			LocalTime convertLocalTime = LocalTime.ofSecondOfDay(convertInteger);
			String value = convertLocalTime.toString();
			return value;
		} else {
			 
			
			if (parameter == null) {
				String meter = parameter ="0";
				double convertDouble = Double.parseDouble(meter);
				int convertInteger = (int) convertDouble;
				LocalTime convertLocalTime = LocalTime.ofSecondOfDay(convertInteger);
				String value = convertLocalTime.toString();
				return value;
			} else {
				
				String param = parameter.substring(0,1);
				 
				
				if (param.equals("-")) { 
					String rawData = parameter.substring(1, parameter.length());
					double convertDouble = Double.parseDouble(rawData);
					int convertInteger = (int) convertDouble;
					LocalTime convertLocalTime = LocalTime.ofSecondOfDay(convertInteger);
					String value = convertLocalTime.toString();
					return '-' + value;
				}else  {
				
					double convertDouble = Double.parseDouble(parameter);
					int convertInteger = (int) convertDouble;
					LocalTime convertLocalTime = LocalTime.ofSecondOfDay(convertInteger);
					String value = convertLocalTime.toString();
					return value;
				}	
			  }
	}
	}
}
