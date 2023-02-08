package com.mentorsdynamodb.entity;

import com.amazonaws.services.dynamodbv2.datamodeling.*;

import java.time.LocalDate;

@DynamoDBTable(tableName="project")
public class Project {
    @DynamoDBHashKey(attributeName = "project_id")
    private Integer projectId;
    @DynamoDBAttribute(attributeName = "project_name")
    private String projectName;
    @DynamoDBAttribute(attributeName = "idea_owner")
    private Integer ideaOwner;
    @DynamoDBAttribute(attributeName = "release_date")
    @DynamoDBTyped(DynamoDBMapperFieldModel.DynamoDBAttributeType.S)
    private LocalDate releaseDate;
    @DynamoDBAttribute(attributeName = "mentor")
    private Mentor mentor;

    public Project() {

    }

    public Integer getProjectId() {
        return projectId;
    }

    public String getProjectName() {
        return projectName;
    }

    public Integer getIdeaOwner() {
        return ideaOwner;
    }

    @DynamoDBTypeConverted(converter = LocalDateConverter.class)
    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public Mentor getMentor() {
        return mentor;
    }

    public void setProjectId(Integer projectId) {
        this.projectId = projectId;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public void setIdeaOwner(Integer ideaOwner) {
        this.ideaOwner = ideaOwner;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }

    public void setMentor(Mentor mentor) {
        this.mentor = mentor;
    }
}
