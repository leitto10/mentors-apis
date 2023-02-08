package com.mentorsdynamodb.entity;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;


@DynamoDBTable(tableName="mentor")
public class Mentor {
	
	@DynamoDBHashKey(attributeName = "mentor_id")
	private Integer mentorId;
	
	@DynamoDBAttribute(attributeName = "mentor_name")
	private String mentorName;
	
	@DynamoDBAttribute(attributeName = "projects_mentored")
	private Integer numberOfProjectsMentored;
	
	public Mentor() {
		
	}

	public Integer getMentorId() {
		return mentorId;
	}

	public void setMentorId(Integer mentorId) {
		this.mentorId = mentorId;
	}

	public String getMentorName() {
		return mentorName;
	}

	public void setMentorName(String mentorName) {
		this.mentorName = mentorName;
	}

	public Integer getNumberOfProjectsMentored() {
		return numberOfProjectsMentored;
	}

	public void setNumberOfProjectsMentored(Integer numberOfProjectsMentored) {
		this.numberOfProjectsMentored = numberOfProjectsMentored;
	}

	@Override
	public String toString() {
		return "Mentor [mentorId=" + mentorId + ", mentorName=" + mentorName + ", numberOfProjectsMentored="
				+ numberOfProjectsMentored + "]";
	}
	
}
