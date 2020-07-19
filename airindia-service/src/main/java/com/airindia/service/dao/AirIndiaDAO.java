package com.airindia.service.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.airindia.service.FlightDetails;

@Component
public class AirIndiaDAO {
	
	
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	String query = "";
	
	private static final class FlightMapper implements RowMapper<FlightDetails> {
	    @Override
	    public FlightDetails mapRow(ResultSet rs, int rowNum) throws SQLException {
	    	FlightDetails flight = new FlightDetails(rs.getString(2),rs.getString(3),
	    			rs.getString(4),rs.getString(5),rs.getInt(6), rs.getInt(7), rs.getInt(8)
	    			,rs.getString(9),rs.getString(10)); 
	    	System.out.println("DAO:"+rs.getString(2));
	    	
			/*
			 * menu.setId(rs.getInt("id")); menu.setRestaurantId(rs.getString("resId"));
			 * menu.setRestaurantName(rs.getString("res"));
			 * menu.setFoodId(rs.getString("foodId"));
			 * menu.setFoodName(rs.getString("foodName")); menu.setRate(rs.getInt("rate"));
			 */
	        return flight;
	    }
	}
	
	public List<FlightDetails> getFlightDetails(String startPlace, String endPlace)
	{
		List<FlightDetails> list = new ArrayList<>();
		query = "select * from flight_details  where start_place=? and end_place=? order by price"
				;
		list = jdbcTemplate.query(query, 
                new FlightMapper(), startPlace, endPlace);
		return list;
	}

}
