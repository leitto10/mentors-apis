package com.mentorsdynamodb.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mentorsdynamodb.entity.Mentor;
import com.mentorsdynamodb.exception.MentorException;
import com.mentorsdynamodb.repository.MentorRepository;

@Service
public class MentorServiceImpl implements MentorService {

	@Autowired
	private MentorRepository mentorRepository;
	
	@Override
	public List<Mentor> getMentors() throws MentorException {
		return (List<Mentor>) mentorRepository.findAll();
	}

	@Override
	public Optional<Mentor> getMentor(Integer mentorId) throws MentorException {
		Optional<Mentor> mentor = mentorRepository.findById(mentorId);
		if(mentor.isPresent())
			return mentor;
		else
			throw new MentorException("Service.MENTOR_NOT_FOUND");
	}
	
	@Override
	public Integer addMentor(Mentor mentorBody) throws MentorException {
		boolean exists = mentorRepository.existsById(mentorBody.getMentorId());
		if(exists)
			throw new MentorException("API.MENTOR_ALREADY_EXISTS");
		else
			return mentorRepository.save(mentorBody).getMentorId();
	}

	@Override
	public Mentor updateMentor(Integer mentorId ,Mentor mentor) throws MentorException {
		mentorRepository.findById(mentorId)
				.orElseThrow(() -> new MentorException("Service.MENTOR_NOT_FOUND"));
		
		mentor.setMentorId(mentorId);
		return mentorRepository.save(mentor);
	}

	@Override
	public void deleteMentor(Integer mentorId) throws MentorException {
		boolean exists = mentorRepository.existsById(mentorId);
		if(!exists)
			throw new MentorException("Service.MENTOR_NOT_FOUND");
		else
			mentorRepository.deleteById(mentorId);
	}
	

}
