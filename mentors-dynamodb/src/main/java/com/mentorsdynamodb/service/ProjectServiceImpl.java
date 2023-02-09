package com.mentorsdynamodb.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mentorsdynamodb.entity.Project;
import com.mentorsdynamodb.exception.MentorException;
import com.mentorsdynamodb.repository.ProjectRepository;

@Service
public class ProjectServiceImpl implements ProjectService {
	
	@Autowired
	private ProjectRepository projectRepository;

	@Override
	public List<Project> getProjects() throws MentorException {
		return (List<Project>) projectRepository.findAll();
	}
	
	@Override
	public Optional<Project> getProject(Integer projectId) throws MentorException {
		Optional<Project> project = projectRepository.findById(projectId);
		if(project.isPresent())
			return project;
		else
			throw new MentorException("Service.PROJECT_NOT_FOUND");
	}

	@Override
	public Project addProject(Project project) throws MentorException {
		boolean exists = projectRepository.existsById(project.getProjectId());
		if(exists)
			throw new MentorException("API.MENTOR_ALREADY_EXISTS");
		else
			return projectRepository.save(project);
	}

	@Override
	public Project updateProject(Integer projectId, Project project) throws MentorException {
		boolean exists = projectRepository.existsById(projectId);
		if(!exists)
			throw new MentorException("Service.PROJECT_NOT_FOUND");
		else
			project.setProjectId(projectId);
			return projectRepository.save(project);
	}

	@Override
	public void deleteProject(Integer projectId) throws MentorException {
		boolean exists = projectRepository.existsById(projectId);
		if(!exists)
			throw new MentorException("Service.PROJECT_NOT_FOUND");
		else
			projectRepository.deleteById(projectId);
	}
	
}
