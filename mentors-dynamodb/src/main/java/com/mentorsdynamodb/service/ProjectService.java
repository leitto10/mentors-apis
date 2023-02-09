package com.mentorsdynamodb.service;

import java.util.List;
import java.util.Optional;

import com.mentorsdynamodb.entity.Project;
import com.mentorsdynamodb.exception.MentorException;

public interface ProjectService {
	
	List<Project> getProjects() throws MentorException;
	public Optional<Project> getProject(Integer projectId) throws MentorException;
	public Project addProject(Project project) throws MentorException;
	public Project updateProject(Integer projectId, Project project) throws MentorException;
	public void deleteProject(Integer projectId) throws MentorException;

}
