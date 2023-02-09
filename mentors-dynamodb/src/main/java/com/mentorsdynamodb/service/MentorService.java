package com.mentorsdynamodb.service;

import java.util.List;
import java.util.Optional;

import com.mentorsdynamodb.entity.Mentor;
import com.mentorsdynamodb.exception.MentorException;

public interface MentorService {
	
	public List<Mentor> getMentors() throws MentorException;
	public Optional<Mentor> getMentor(Integer mentorId) throws MentorException;
	public Integer addMentor(Mentor mentor) throws MentorException;
	public Mentor updateMentor(Integer mentorId, Mentor mentor) throws MentorException;
	public void deleteMentor(Integer mentorId) throws MentorException;
	

}
