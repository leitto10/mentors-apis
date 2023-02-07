package com.mentorsdynamodb.repository;

import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.mentorsdynamodb.entity.Mentor;

@Repository
@EnableScan
public interface MentorRepository extends CrudRepository<Mentor, Integer> {

}
