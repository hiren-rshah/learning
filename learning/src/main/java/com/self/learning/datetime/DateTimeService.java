package com.self.learning.datetime;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.stereotype.Service;

@Service
public class DateTimeService {
	
	public String convertTime(String zone) {
		return ZonedDateTime.now(ZoneId.of(zone)).format(DateTimeFormatter.ofPattern("dd MMM yyyy hh:mm"));
	}
}
