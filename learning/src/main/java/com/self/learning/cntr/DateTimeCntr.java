package com.self.learning.cntr;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.self.learning.service.DateTimeService;

@RestController
public class DateTimeCntr {

	private DateTimeService dateTimeService;

	public DateTimeCntr(DateTimeService dateTimeService) {
		this.dateTimeService = dateTimeService;
	}
	
	@RequestMapping(value = { "/currentTime", "/currentTime/{timeZone}" }, method = { RequestMethod.GET })
	public String getTime(@PathVariable(value = "timeZone", required = false) String timeZoneStr) {
		if ("PST".equals(timeZoneStr)) {
			return dateTimeService.convertTime("Europe/Paris");
		} else if ("EST".equals(timeZoneStr)) {
			return dateTimeService.convertTime("America/New_York");
		} else {
			return dateTimeService.convertTime("Asia/Kolkata");
		}
	}

	@GetMapping(value = { "/currentTimeJsonGet",  "/currentTimeJsonGet/{timeZone}"}, produces = MediaType.APPLICATION_JSON_VALUE)
	public MyTime getJsonTime(@PathVariable(value = "timeZone", required = false) String timeZoneStr) {
		System.out.println("getJsonTime - Received timeZone is : " + timeZoneStr);
		if ("PST".equals(timeZoneStr)) {
			return new MyTime(timeZoneStr,dateTimeService.convertTime("Europe/Paris"));
		} else if ("EST".equals(timeZoneStr)) {
			return new MyTime(timeZoneStr,dateTimeService.convertTime("America/New_York"));
		} else {
			return new MyTime(timeZoneStr,dateTimeService.convertTime("Asia/Kolkata"));
		}
	}
	
	@PostMapping(value = { "/currentTimeJsonPost",  "/currentTimeJsonPost/{timeZone}"}, consumes = MediaType.APPLICATION_JSON_VALUE ,produces = MediaType.APPLICATION_JSON_VALUE)
	public MyTime postJsonTime(@PathVariable(value = "timeZone", required = false) String timeZoneStr) {
		System.out.println("postJsonTime - Received timeZone is : " + timeZoneStr);
		if ("PST".equals(timeZoneStr)) {
			return new MyTime(timeZoneStr,dateTimeService.convertTime("Europe/Paris"));
		} else if ("EST".equals(timeZoneStr)) {
			return new MyTime(timeZoneStr,dateTimeService.convertTime("America/New_York"));
		} else {
			return new MyTime(timeZoneStr,dateTimeService.convertTime("Asia/Kolkata"));
		}
	}

	private class MyTime {
		private String timeZone;
		private String dateTime;

		public String getTimeZone() {
			return timeZone;
		}

		public void setTimeZone(String timeZone) {
			this.timeZone = timeZone;
		}

		public String getDateTime() {
			return dateTime;
		}

		public void setDateTime(String dateTime) {
			this.dateTime = dateTime;
		}

		public MyTime(String timeZoneStr, String dateTime) {
			this.timeZone = timeZoneStr;
			this.dateTime = dateTime;
		}

	}
}
