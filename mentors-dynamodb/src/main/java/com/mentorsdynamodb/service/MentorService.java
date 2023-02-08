package com.mentorsdynamodb.service;

import java.util.List;

import com.mentorsdynamodb.entity.Mentor;
import com.mentorsdynamodb.exception.MentorException;

public interface MentorService {
	
	public List<Mentor> getMentors() throws MentorException;
	public Integer addMentor(Mentor mentor) throws MentorException;

}
