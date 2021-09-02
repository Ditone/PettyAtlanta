package com.personalproj.weather.aspects;

import org.aopalliance.intercept.Joinpoint;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Aspect
@Order(1)
@ComponentScan
public class LoggingAspect {
    private Logger logger = Logger.getLogger(LoggingAspect.class.getName());

    @Before("execution (public String com.personalproj.weather.model.WeatherAug.getHighDegF())")
    public void loggingAdviceGetHighF() {
        System.out.println("log Aug High");
        logger.info("The WeatherAug getHighF method is being called.");
    }

    @AfterReturning("execution (public String com.personalproj.weather.controller.WeatherDiffController.findHotter())")
    public void loggingAdviceGotHottest(){
        System.out.println ("log hot");
        logger.warning("Temp difference has returned a hottest list");
    }

    @Pointcut("within(com.personalproj.weather.model.WeatherFeb")
    public void allFebMethods() {}

    @After("allFebMethods()")
    public void loggingAdviceFeb (JoinPoint jointPoint){
        System.out.println("log feb");
        logger.info("A method of February has been called.");
        logger.info(jointPoint.toString());
        logger.info(jointPoint.getTarget().toString());
    }
}
