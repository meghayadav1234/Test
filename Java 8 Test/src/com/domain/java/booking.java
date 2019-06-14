package com.domain.java;

public class booking {
	public static void main(String[] args){
		BritishAirways britishAirways = new BritishAirways();
		britishAirways.getAllAvailableFlights();
		britishAirways.booking();
		System.out.println("------------------");
		AirIndia airIndia =new AirIndia();
		airIndia.getAllAvailableFlights();
		airIndia.booking();
		
		
		System.out.println("------------------");
		Flight airIndiaFlight =new AirIndia();
		airIndiaFlight.getAllAvailableFlights();
		
		Flight britishAirwaysFlight =new BritishAirways();
		britishAirwaysFlight.getAllAvailableFlights();
	}

}
