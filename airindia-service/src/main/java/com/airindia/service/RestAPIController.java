package com.airindia.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.airindia.service.dao.AirIndiaDAO;

import java.util.*;

@RestController
@RequestMapping("/flights")
public class RestAPIController {
	
	@Autowired
	AirIndiaDAO dao;
	
	@CrossOrigin
	@RequestMapping("/{startPlace}/{endPlace}")
	public List<FlightDetails> getFlights(@PathVariable("startPlace")String startPlace, @PathVariable("endPlace")String endPlace)
	{
		System.out.println("api entered:"+startPlace);
		List<FlightDetails> flights = dao.getFlightDetails(startPlace, endPlace);
		return flights;
	}

}
