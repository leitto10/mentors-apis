package com.mentorsdynamodb.repository;

import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.mentorsdynamodb.entity.Project;

@Repository
@EnableScan
public interface ProjectRepository extends CrudRepository<Project, Integer>{

}
