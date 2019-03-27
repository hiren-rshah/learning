package com.self.learning.java8;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;

public class DateTimeDemo {

	public static void main(String[] args) {
		
		LocalDate today = LocalDate.now();
		LocalDate myBday = LocalDate.of(1982, 2, 7);
		System.out.println(today);
		System.out.println(myBday);
	
		LocalTime indTime = LocalTime.now();
		System.out.println(indTime);
		LocalTime usTime = LocalTime.now(ZoneId.of("America/New_York"));
		System.out.println(usTime);
		
	}

}
