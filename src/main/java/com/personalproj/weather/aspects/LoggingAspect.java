package com.personalproj.weather.aspects;

import org.aopalliance.intercept.Joinpoint;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;

import java.util.logging.Logger;

@Aspect
@Order
public class LoggingAspect {
    private Logger logger = Logger.getLogger(LoggingAspect.class.getName());

    @Before("execution (public String com.personalproj.weather.model.WeatherAug.getHighDegF())")
    public void loggingAdviceGetHighF() {
        logger.info("The WeatherAug getHighF method is being called.");
    }

    @AfterReturning("execution (public String com.personalproj.weather.controller.WeatherDiffController.findHotter())")
    public void loggingAdviceGotHottest(){
        logger.warning("Temp difference has returned a hottest list");
    }

    @Pointcut()
    public void allFebMethods() {}

    @After("allFebMethods()")
    public void loggingAdviceFeb (JoinPoint jointPoint){
        logger.info("A method of February has been called.");
        logger.info(jointPoint.toString());
        logger.info(jointPoint.getTarget().toString());
    }
}
