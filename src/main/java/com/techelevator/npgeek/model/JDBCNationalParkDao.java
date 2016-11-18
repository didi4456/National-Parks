package com.techelevator.npgeek.model;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

@Component
public class JDBCNationalParkDao implements NationalParkDao {
	
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public JDBCNationalParkDao(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public List<NationalPark> getAllParks() {
		List<NationalPark> nationalPark = new ArrayList<>();
		String sqlSelectAllParks = "SELECT * FROM park";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlSelectAllParks);
		while(results.next()) {
			nationalPark.add(mapRowToNationalPark(results));
		}
		return nationalPark;
	}
	@Override
	public NationalPark getParkByParkCode(String parkCode) {
		NationalPark park= new NationalPark();
		String sqlSelectPark= "SELECT * FROM park WHERE parkcode=?";
		SqlRowSet result= jdbcTemplate.queryForRowSet(sqlSelectPark, parkCode);
		if(result.next()){
			park = mapRowToNationalPark(result);
		}
		return park;
	}
	
	private NationalPark mapRowToNationalPark(SqlRowSet row) {
		NationalPark nationalPark = new NationalPark();
		nationalPark.setName(row.getString("parkname"));
		nationalPark.setLocation(row.getString("state"));
		nationalPark.setSummary(row.getString("parkdescription"));
		nationalPark.setParkCode(row.getString("parkcode"));
		nationalPark.setAcreage(row.getInt("acreage"));
		nationalPark.setElevationInFeet(row.getInt("elevationinfeet"));
		nationalPark.setMilesOfTrail(row.getDouble("milesoftrail"));
		nationalPark.setNumberOfCampsites(row.getInt("numberofcampsites"));
		nationalPark.setClimate(row.getString("climate"));
		nationalPark.setYearFounded(row.getInt("yearfounded"));
		nationalPark.setAnnualVisitors(row.getInt("annualvisitorcount"));
		nationalPark.setInspirationalQuote(row.getString("inspirationalquote"));
		nationalPark.setQuoteSource(row.getString("inspirationalquotesource"));
		nationalPark.setEntryFee(row.getInt("entryfee"));
		nationalPark.setNumberOfAnimalSpecies(row.getInt("numberofanimalspecies"));
		
		
		return nationalPark;
	}


	
	
	

}
