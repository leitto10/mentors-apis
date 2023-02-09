package com.mentorsdynamodb.controller;

import java.util.List;
import java.util.Optional;

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

import com.mentorsdynamodb.entity.Project;
import com.mentorsdynamodb.exception.MentorException;
import com.mentorsdynamodb.service.ProjectService;

@Validated
@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ProjectController {

	@Autowired
	private ProjectService projectService;
	@Autowired
	private Environment environment;
	
	@GetMapping("/projects")
    public ResponseEntity<List<Project>> getProjects() throws MentorException {
        List<Project> allProjects = projectService.getProjects();
        return new ResponseEntity<>(allProjects, HttpStatus.OK);
    }
	
	@GetMapping("/project/{projectId}")
	public ResponseEntity<Optional<Project>> getProject(@PathVariable Integer projectId) throws MentorException {
		return new ResponseEntity<Optional<Project>>(projectService.getProject(projectId), HttpStatus.OK);
	}
	
	@PostMapping("/project")
	public ResponseEntity<Project> addProject(@RequestBody Project projectBody) throws MentorException {
		Project project = projectService.addProject(projectBody);
		return new ResponseEntity<Project>(project, HttpStatus.CREATED);
	}
	
	@PutMapping("/project/{projectId}")
	public ResponseEntity<Project> updateProject(
			@PathVariable Integer projectId, @RequestBody Project projectBody) throws MentorException {
		Project project = projectService.updateProject(projectId, projectBody);
		return new ResponseEntity<Project>(project, HttpStatus.OK);
	}
	
	@DeleteMapping("/project/{projectId}")
	public ResponseEntity<String> deleteProject(@PathVariable Integer projectId) throws MentorException {
		String message = environment.getProperty("API.PROJECT_DELETE_SUCCESS");
		projectService.deleteProject(projectId);
		return new ResponseEntity<String>(message, HttpStatus.OK);
	}
}






