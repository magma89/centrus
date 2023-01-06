package com.project.centrus.util;

import java.time.LocalTime;
import java.util.concurrent.TimeUnit;

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
		
			String param = parameter.substring(0,1);
			
			if (param.equals("-")) {
				String rawData = parameter.substring(1, parameter.length());
				double convertDouble = Double.parseDouble(rawData);
				int convertInteger = (int) convertDouble;
				long HH = TimeUnit.MILLISECONDS.toHours(convertInteger);
				long MM = TimeUnit.MILLISECONDS.toMinutes(convertInteger) % 60;
				long SS = TimeUnit.MILLISECONDS.toSeconds(convertInteger) % 60;
				
				String timeInHHMMSS = String.format("%02d:%02d:%02d", HH, MM, SS);
				return '-' + timeInHHMMSS;
			}
		
		
		
			double convertDouble = Double.parseDouble(parameter);
			int convertInteger = (int) convertDouble; 	
			long HH = TimeUnit.MILLISECONDS.toHours(convertInteger);
			long MM = TimeUnit.MILLISECONDS.toMinutes(convertInteger) % 60;
			long SS = TimeUnit.MILLISECONDS.toSeconds(convertInteger) % 60;
			
			String timeInHHMMSS = String.format("%02d:%02d:%02d", HH, MM, SS);
			return timeInHHMMSS;
			
	 
		
		}else  {
			
			if (parameter == null) {
				parameter ="0";
			}
			 
			String param = parameter.substring(0,1);
			
			if (param.equals("-")) {
				String rawData = parameter.substring(1, parameter.length());
				double convertDouble = Double.parseDouble(rawData);
				int convertInteger = (int) convertDouble;
				long HH = TimeUnit.SECONDS.toHours(convertInteger);
				long MM = TimeUnit.SECONDS.toMinutes(convertInteger) % 60;
				long SS = TimeUnit.SECONDS.toSeconds(convertInteger) % 60;
				
				String timeInHHMMSS = String.format("%02d:%02d:%02d", HH, MM, SS);
				return '-' + timeInHHMMSS;
			}
			
			double convertDouble = Double.parseDouble(parameter);
			int convertInteger = (int) convertDouble;	
			long HH = TimeUnit.SECONDS.toHours(convertInteger);
			long MM = TimeUnit.SECONDS.toMinutes(convertInteger) % 60;
			long SS = TimeUnit.SECONDS.toSeconds(convertInteger) % 60;
			
			String timeInHHMMSS = String.format("%02d:%02d:%02d", HH, MM, SS);
			return timeInHHMMSS;
			
			
		} 
	}
}
