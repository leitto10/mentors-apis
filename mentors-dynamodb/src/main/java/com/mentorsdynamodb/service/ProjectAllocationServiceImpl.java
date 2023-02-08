package com.mentorsdynamodb.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mentorsdynamodb.entity.Project;
import com.mentorsdynamodb.repository.ProjectRepository;

@Service
public class ProjectAllocationServiceImpl implements ProjectAllocationService {

	@Autowired
	public ProjectRepository projectRepository;
	
	@Override
	public List<Project> getProjects() {
		return (List<Project>) projectRepository.findAll();
	}

}
