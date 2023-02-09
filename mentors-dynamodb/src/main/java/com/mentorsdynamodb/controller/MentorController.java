package com.mentorsdynamodb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mentorsdynamodb.entity.Mentor;
import com.mentorsdynamodb.exception.MentorException;
import com.mentorsdynamodb.service.MentorService;

@Validated
@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class MentorController {
	
	@Autowired
	private Environment environment;
	
	@Autowired
	private MentorService mentorService;

	@GetMapping("/mentors")
	public ResponseEntity<List<Mentor>> getMentors() throws MentorException {
		List<Mentor> mentors = mentorService.getMentors();
		return new ResponseEntity<List<Mentor>>(mentors, HttpStatus.OK);
	}
	
	@PostMapping("/mentor")
	public ResponseEntity<String> addMentor(@RequestBody Mentor mentor) throws MentorException {
		Integer addMentor = mentorService.addMentor(mentor);
		String message = environment.getProperty("API.MENTOR_ADDED_SUCCESS");
		return new ResponseEntity<String>(message+": "+addMentor, HttpStatus.CREATED);
	}
	
	@PutMapping("/mentor/{mentorId}")
	public ResponseEntity<Mentor> updateMentor(
			@PathVariable Integer mentorId, @RequestBody Mentor mentorBody) 
			throws MentorException {
		Mentor mentor = mentorService.updateMentor(mentorId, mentorBody);
		String message = environment.getProperty("API.MENTOR_UPDATED_SUCCESS");
		return new ResponseEntity<Mentor>(mentor, HttpStatus.OK);
	}
	
	@DeleteMapping("/mentor/{mentorId}")
	public ResponseEntity<String> deleteMentor(@PathVariable Integer mentorId) throws MentorException {
		mentorService.deleteMentor(mentorId);
		String message = environment.getProperty("API.MENTOR_DELETION_SUCCESS");
		return new ResponseEntity<String>(message, HttpStatus.OK);
	}
	
	
}
