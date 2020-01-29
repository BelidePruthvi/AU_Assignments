package com.accolite.au.web.xmldemo.Aspect;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
@Aspect
@Component
public class UserAspect {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @Before(value = "execution(* com.accolite.au.web.xmldemo.controller.*.*(..))")
    public void beforeAdvice(JoinPoint joinPoint) {
        logger.info("Before method:" + joinPoint.getSignature());

        logger.info("controller method is ready to serve");
    }

    @After(value = "execution(* com.accolite.au.web.xmldemo.controller.UserController.*.*(..))")
    public void afterAdvice(JoinPoint joinPoint) {
        logger.info("After method:" + joinPoint.getSignature());

        logger.info("successfully handled the request");
    }

    @Around(value = "execution(* com.accolite.au.web.xmldemo.controller.*.*(..))")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        Object result;
        long startTime = System.currentTimeMillis();
        result=joinPoint.proceed();
        long timeTaken = System.currentTimeMillis() - startTime;
        logger.info("Time Taken by {} is {}", joinPoint, timeTaken);
        return result;
    }
}
