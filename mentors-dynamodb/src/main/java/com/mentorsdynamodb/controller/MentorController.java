package com.mentorsdynamodb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mentorsdynamodb.entity.Mentor;
import com.mentorsdynamodb.service.MentorService;

@Validated
@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class MentorController {
	
	@Autowired
	private MentorService mentorService;

	@GetMapping("/mentors")
	public ResponseEntity<List<Mentor>> getMentors() {
		List<Mentor> mentors = mentorService.getMentors();
		return new ResponseEntity<List<Mentor>>(mentors, HttpStatus.OK);
	}
}
