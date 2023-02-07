package com.mentorsdynamodb.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mentorsdynamodb.entity.Mentor;
import com.mentorsdynamodb.repository.MentorRepository;

@Service
public class MentorServiceImpl implements MentorService {

	@Autowired
	private MentorRepository mentorRepository;
	
	@Override
	public List<Mentor> getMentors() {
		return (List<Mentor>) mentorRepository.findAll();
	}

}
