package com.example.spring_course_zaur.aspect_oriented_programming.aspects;

import org.aspectj.lang.annotation.Pointcut;

public class MyPointcuts {
    @Pointcut("execution(* get*())")
    public void allGetMethods() {}

    @Pointcut("execution(* add*())")
    public void allAddMethods() {}
}
