package com.project.centrus.util;
 
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class DateFormatter {
	
	public String getDateTimeFormat (String format) {
		
		if(format == null) {
			format = "00:00:000";
		}else {
			String time = format.toString();
			//String time = "2022-09-10 22:06:48.897";
			SimpleDateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
			SimpleDateFormat outputFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			try {
			Date date =  inputFormat.parse(time); 
			
			String outString= outputFormat.format(date); 
			return outString;
			
			} catch (Exception e) {
				
				log.error("Error :",e);
			}
			

		}
		return format;
	}

}
