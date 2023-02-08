package com.mentorsdynamodb.exception;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;


@Aspect
@Component
public class LogginAspect {
	
	private static final Log LOGGER = LogFactory.getLog(LogginAspect.class);

	@AfterThrowing(pointcut= "execution(* com.mentorsdynamodb.service.*Impl.*(..))", throwing="exception")
	public void logServiceException(MentorException exception){
		LOGGER.info(exception.getMessage(), exception);
	}
}