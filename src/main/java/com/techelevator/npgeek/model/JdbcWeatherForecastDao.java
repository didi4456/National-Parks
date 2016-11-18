package com.techelevator.npgeek.model;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

@Component
public class JdbcWeatherForecastDao implements WeatherForecastDao {
	
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public JdbcWeatherForecastDao (DataSource dataSource){
		this.jdbcTemplate= new JdbcTemplate(dataSource);
	}

	@Override
	public List<WeatherForecast> getWeatherForcastByParkCode(String parkCode) {
		List<WeatherForecast> forecast = new ArrayList<>();
		String sqlSelectForecast = "SELECT * FROM weather "
									+ "JOIN park ON park.parkcode=weather.parkcode "
									+ "WHERE park.parkcode=?";
		SqlRowSet result = jdbcTemplate.queryForRowSet(sqlSelectForecast, parkCode);
		while(result.next()){
			forecast.add(mapRowToForecast(result));
		}
		return forecast;
	}
	
	private WeatherForecast mapRowToForecast(SqlRowSet row) {
		WeatherForecast forecast = new WeatherForecast();
		forecast.makeTempRecommendation(row.getInt("high"), row.getInt("low"));
		forecast.tempDiffRecommendation(row.getInt("high"), row.getInt("low"));
		forecast.makeForecastRecommendation(row.getString("forecast"));
		forecast.setName(row.getString("parkname"));
		forecast.setFiveDayForecast(row.getInt("fivedayforecastvalue"));
		forecast.setLowTemp(row.getInt("low"));
		forecast.setHighTemp(row.getInt("high"));
		forecast.setForecast(row.getString("forecast"));
		
		return forecast;
	}




}
