package com.sapit.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
//import org.aopalliance.intercept.Joinpoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

import com.sapit.ResourceNotFoundException;

@Aspect
@Configuration
public class CentralAopForLogger {
	
	private org.slf4j.Logger log=LoggerFactory.getLogger(CentralAopForLogger.class);
	
//	@Pointcut("execution(* com.sapit.controller.*.*(..))")
//	public void p1() {
//		
//	}
	
//	@Before("p1()")
	@Before(value = ("execution(* com.sapit.controller.*.*(..))"))
	public void logStatementBefore(JoinPoint joinPoint) {
		log.info("Executing {}",joinPoint);
	}
	
	
	@After(value = ("execution(* com.sapit.controller.*.*(..))"))
	public void logStatementAfter(JoinPoint joinPoint) {
		log.info("completing {}",joinPoint);
	}
	
	
	@Around(value = ("execution(* com.sapit.*.*(..))"))
	public Object logStatementAround(ProceedingJoinPoint joinPoint) throws Throwable{
		try {
			Object obj = joinPoint.proceed();
			return obj;
		} catch (ResourceNotFoundException e) {
			// TODO: handle exception
			log.info("getResourceName {}",e.getResourceName());
			log.info("Stats code {}",e.getHttpstatus());
			log.info("error{}",e.getMsg());
		}
		return joinPoint;
	}
}
