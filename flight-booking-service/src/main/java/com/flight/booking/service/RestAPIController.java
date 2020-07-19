package com.flight.booking.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import java.util.*;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/flights")
@SuppressWarnings("unchecked")
public class RestAPIController {
	
	@Autowired
	RestTemplate restTemplate;
	
	@CrossOrigin
	@RequestMapping("/{startPlace}/{endPlace}/{sortParam}")
	public List<FlightDetails> getDetails(@PathVariable("startPlace")String startPlace, 
			@PathVariable("endPlace")String endPlace, @PathVariable("sortParam")String sortParam) throws Exception
	{
		System.out.println("In flight booking:"+restTemplate);
		List<FlightDetails> flightDetails = new ArrayList<>();
		ResponseEntity<FlightDetails[]> response =
				restTemplate.getForEntity("http://airindia-service/flights/"+startPlace+"/"+endPlace, FlightDetails[].class);
		System.out.println("Response details:"+response+"|"+response.getBody());
		
		FlightDetails[] flights = response.getBody();
		System.out.println("Length:"+flights.length);
		
		if(flights.length == 0)
			throw new FilterDoesNotMatchException("Given Filters doesn't match");
		
		flightDetails = Arrays.asList(flights).stream().distinct().collect(Collectors.toList());

		applySortingFilter(sortParam, flightDetails);
		return flightDetails;
	}

	
	private void applySortingFilter(String sortParam, List<FlightDetails> flightDetails) {
		if(sortParam!=null)
		{
			if(sortParam.equals("name"))
			{
				Collections.sort(flightDetails, new NameComparator());
			}
			else if(sortParam.equals("duration"))
			{
				Collections.sort(flightDetails, new DurationComparator());
			}
			else if(sortParam.equals("price"))
			{
				Collections.sort(flightDetails, new PriceComparator());
			}
		}
	}

	
}


@SuppressWarnings("rawtypes")
class NameComparator implements Comparator
{
	@Override
	public int compare(Object o1, Object o2) {
		// TODO Auto-generated method stub
		FlightDetails f1 = (FlightDetails)o1;
		FlightDetails f2 = (FlightDetails)o2;
		return f1.getAirLineName().compareTo(f2.getAirLineName());
	}
}

@SuppressWarnings("rawtypes")
class PriceComparator implements Comparator
{
	@Override
	public int compare(Object o1, Object o2) {
		// TODO Auto-generated method stub
		FlightDetails f1 = (FlightDetails)o1;
		FlightDetails f2 = (FlightDetails)o2;
		if(f1.getPrice() > f2.getPrice())
			return -1;
		else if(f1.getPrice() < f2.getPrice())
			return 1; 
		else return 0;
	}
	
}	

@SuppressWarnings("rawtypes")
class DurationComparator implements Comparator
{
	@Override
	public int compare(Object o1, Object o2) {
		// TODO Auto-generated method stub
		FlightDetails f1 = (FlightDetails)o1;
		FlightDetails f2 = (FlightDetails)o2;
		if(f1.getDuration() > f2.getDuration())
			return 1;
		else if(f1.getDuration() < f2.getDuration())
			return -1; 
		else return 0;
	}
	
}	


