package com.domain.dateAndTime;

import java.time.Clock;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Month;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class DateAndTimeApi {

	public static void main(String[] args) {

		LocalDate localDate =LocalDate.now();
		System.out.println(localDate);
		System.out.println(LocalDate.of(2019, Month.JUNE, 28));
		System.out.println(LocalDate.ofYearDay(2019, 365));
		System.out.println(localDate.getDayOfMonth());
		System.out.println(localDate.getMonthValue());
		System.out.println(localDate.getDayOfYear());
		System.out.println(localDate.getChronology());
		System.out.println(localDate.getYear());
		System.out.println(localDate.isLeapYear());              
		System.out.println(localDate.plusDays(12).toString());


		LocalTime localTime =LocalTime.now();
		System.out.println(localTime);
		System.out.println(LocalTime.of(12, 20, 28));
		System.out.println(LocalTime.of(12, 12));
		System.out.println(localTime.getHour());
		System.out.println(localTime.getMinute());
		System.out.println(localTime.getSecond());
		System.out.println(localTime.getNano());
		System.out.println(localTime.toNanoOfDay());              
		System.out.println(localTime.plusHours(10));
		System.out.println(LocalTime.now(ZoneId.systemDefault()));

		ZonedDateTime currentZone = ZonedDateTime.now();  
		System.out.println("the current zone is "+ currentZone.getZone());  

		ZoneId tokyo = ZoneId.of("Asia/Tokyo"); 

		ZonedDateTime tokyoZone = currentZone.withZoneSameInstant(tokyo); 

		System.out.println("tokyo time zone is " + tokyoZone); 
		Duration fiveHours = Duration.ofHours(5); 

		LocalTime time2 = localTime.plus(fiveHours); 

		System.out.println("after adding five hours " + "of duration " + time2); 

		Duration gap = Duration.between(time2, localTime); 
		System.out.println("duraion gap between time1" + " & time2 is " + gap); 
		Clock clock = Clock.systemDefaultZone();
		System.out.println(clock);                      //SystemClock[Asia/Calcutta]
		System.out.println(clock.instant().toString()); //2013-05-15T06:36:33.837Z
		System.out.println(clock.getZone());            //Asia/Calcutta
		 
	} 

}
