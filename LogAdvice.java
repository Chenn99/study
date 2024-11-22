package com.louis.aop;

/**
 * 切面实现类
 */
public class LogAdvice implements Advice{
    public void beforeAdvice(){
        System.out.println("start time:"+System.currentTimeMillis());
    }

    public void afterAdvice(){
        System.out.println("end time:"+System.currentTimeMillis());
    }
}
