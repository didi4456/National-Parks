package com.techelevator.npgeek.model;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import com.techelevator.npgeek.model.Survey;

@Component
public class JdbcSurveyDao implements SurveyDao {

	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public JdbcSurveyDao (DataSource dataSource){
		this.jdbcTemplate= new JdbcTemplate(dataSource);
	}

	@Override
	public List<Survey> getAllSurveys() {
		List<Survey> allSurveys = new ArrayList<>();
		String sqlSelectAllPosts = "SELECT * FROM forum_post";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlSelectAllPosts);
		while(results.next()) {
			Survey post = new Survey();
			post.setId(results.getLong("suveyid"));
			post.setParkCode(results.getString("parkcode"));
			post.setEmailAddress(results.getString("emailaddress"));
			post.setStateOfResidence(results.getString("state"));
			post.setPhysicalActivityLevel(results.getString("activitylevel"));
			allSurveys.add(post);
		}
		return allSurveys;
	}
	
	@Override
	public Survey getFavoritePark(){
		Survey favPark = new Survey();
		String sqlSelectFavPark = "SELECT parkname, survey_result.parkcode, COUNT(survey_result) FROM park "
							   + "JOIN survey_result ON park.parkcode=survey_result.parkcode "
							   + "GROUP BY parkname, survey_result.parkcode "
							   + "ORDER BY COUNT(survey_result) DESC LIMIT 1 ";
		SqlRowSet result = jdbcTemplate.queryForRowSet(sqlSelectFavPark);
		if(result.next()) {
			
			favPark.setParkCode(result.getString("parkcode"));
			favPark.setParkName(result.getString("parkname"));
		}
		return favPark;
	}

	@Override
	public void save(Survey post) {
		Long id = getNextId();
		String sqlInsertPost = "INSERT INTO survey_result(surveyid, parkcode, emailaddress, state, activitylevel) VALUES (?,?,?,?,?)";
		jdbcTemplate.update(sqlInsertPost, id, post.getParkCode(), post.getEmailAddress(), post.getStateOfResidence(), post.getPhysicalActivityLevel());
		post.setId(id);
	}

	private Long getNextId() {
		String sqlSelectNextId = "SELECT NEXTVAL('seq_surveyId')";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlSelectNextId);
		Long id = null;
		if(results.next()) {
			id = results.getLong(1);
		} else {
			throw new RuntimeException("Something strange happened, unable to select next forum post id from sequence");
		}
		return id;
	}
	
	

}

