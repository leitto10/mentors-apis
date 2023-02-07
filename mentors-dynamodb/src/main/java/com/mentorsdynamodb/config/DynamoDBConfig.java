package com.mentorsdynamodb.config;

import org.socialsignin.spring.data.dynamodb.repository.config.EnableDynamoDBRepositories;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;


@Configuration
@EnableDynamoDBRepositories(basePackages = "com.mentorsdynamodb.repository")
public class DynamoDBConfig {
	
	@Value("${amazon.dynamodb.endpoint}")
	public String endpoint;
	@Value("${amazon.aws.accesskey}")
	public String accesskey;
	@Value("${amazon.aws.secretkey}")
	public String secretkey;
	@Value("${amazon.aws.region}")
	public String region;
	
	@Bean
	AmazonDynamoDB amazonDynamoDB() {
		return AmazonDynamoDBClientBuilder
				.standard()
				.withEndpointConfiguration(
						new AwsClientBuilder.EndpointConfiguration(endpoint, region))
				.withCredentials(new AWSStaticCredentialsProvider(
						new BasicAWSCredentials(accesskey, secretkey)))
				.build();
	}
	

}
