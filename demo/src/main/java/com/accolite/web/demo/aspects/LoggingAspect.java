package com.accolite.web.demo.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.LoggerFactory;

import jdk.internal.net.http.common.Logger;

@Aspect
public class LoggingAspect {
	
	private Logger logger = (Logger) LoggerFactory.getLogger(this.getClass());
	
	@Around(value="com.accolite.web.demo.services.UserService.getUser()")
	public void loggingmethod(ProceedingJoinPoint pjp) throws Throwable 
	{
		System.out.println("before");
		logger.log("before");
		pjp.proceed();
		System.out.println("after");
		logger.log("after");
		
	}
}
