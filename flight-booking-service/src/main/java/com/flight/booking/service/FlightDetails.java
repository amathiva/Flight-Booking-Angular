package com.flight.booking.service;


public class FlightDetails {
	
	private String flightNumber;
	private String airLineName;
	private String arrivalTime;
	private String departureTime;
	private int duration;
	private int noOfStops;
	private int price;
	private String startPlace;
	private String endPlace;
	
	
	public FlightDetails() {}
	
	public FlightDetails(String flightNumber, String airLineName, String arrivalTime, String departureTime,
			int duration, int noOfStops, int price, String startPlace, String endPlace) {
		this.flightNumber = flightNumber;
		this.airLineName = airLineName;
		this.arrivalTime = arrivalTime;
		this.departureTime = departureTime;
		this.duration = duration;
		this.noOfStops = noOfStops;
		this.price = price;
		this.startPlace = startPlace;
		this.endPlace = endPlace;
	}
	
	public String getFlightNumber() {
		return flightNumber;
	}
	public void setFlightNumber(String flightNumber) {
		this.flightNumber = flightNumber;
	}
	public String getAirLineName() {
		return airLineName;
	}
	public void setAirLineName(String airLineName) {
		this.airLineName = airLineName;
	}
	public String getArrivalTime() {
		return arrivalTime;
	}
	public void setArrivalTime(String arrivalTime) {
		this.arrivalTime = arrivalTime;
	}
	public String getDepartureTime() {
		return departureTime;
	}
	public void setDepartureTime(String departureTime) {
		this.departureTime = departureTime;
	}
	public int getDuration() {
		return duration;
	}
	public void setDuration(int duration) {
		this.duration = duration;
	}
	public int getNoOfStops() {
		return noOfStops;
	}
	public void setNoOfStops(int noOfStops) {
		this.noOfStops = noOfStops;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}

	public String getStartPlace() {
		return startPlace;
	}

	public void setStartPlace(String startPlace) {
		this.startPlace = startPlace;
	}

	public String getEndPlace() {
		return endPlace;
	}

	public void setEndPlace(String endPlace) {
		this.endPlace = endPlace;
	}
	

}
