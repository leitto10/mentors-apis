package com.mentorsdynamodb.service;

import java.util.List;

import com.mentorsdynamodb.entity.Mentor;

public interface MentorService {
	
	public List<Mentor> getMentors();

}
