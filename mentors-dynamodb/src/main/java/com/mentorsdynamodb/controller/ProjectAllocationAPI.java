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

import com.mentorsdynamodb.entity.Project;
import com.mentorsdynamodb.service.ProjectAllocationService;

@Validated
@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ProjectAllocationAPI {

    @Autowired
    public ProjectAllocationService projectAllocationService;

    @GetMapping("/projects")
    public ResponseEntity<List<Project>> getProjects(){
        List<Project> allProjects = projectAllocationService.getProjects();
        return new ResponseEntity<>(allProjects, HttpStatus.OK);
    }
}