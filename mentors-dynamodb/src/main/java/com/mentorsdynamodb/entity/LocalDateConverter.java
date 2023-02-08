package com.mentorsdynamodb.entity;


import java.time.LocalDate;

import com.amazonaws.services.dynamodbv2.datamodeling.*;

public class LocalDateConverter implements DynamoDBTypeConverter<String, LocalDate> {
    @Override
    public String convert(LocalDate date) {
        return date.toString();
    }

    @Override
    public LocalDate unconvert(final String stringValue) {
        return LocalDate.parse(stringValue);
    }
}
