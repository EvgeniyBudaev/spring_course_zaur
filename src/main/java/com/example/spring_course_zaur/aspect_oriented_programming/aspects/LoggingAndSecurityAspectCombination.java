package com.example.spring_course_zaur.aspect_oriented_programming.aspects;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAndSecurityAspectCombination {
    @Pointcut("execution(* com.example.spring_course_zaur.aspect_oriented_programming.UniLibrary.get*())")
    private void allGetMethodsFromUniLibrary() {}

    @Pointcut("execution(* com.example.spring_course_zaur.aspect_oriented_programming.UniLibrary.return*())")
    private void allReturnMethodsFromUniLibrary() {}

    @Pointcut("allGetMethodsFromUniLibrary() || allReturnMethodsFromUniLibrary()")
    private void allGetAndReturnMethodsFromUniLibrary() {}

    @Before("allGetMethodsFromUniLibrary()")
    public void beforeGetMethodsFromUniLibrary() {
        System.out.println("beforeGetMethodsFromUniLibrary: writing Log #1");
    }

    @Before("allReturnMethodsFromUniLibrary()")
    public void beforeReturnMethodsFromUniLibrary() {
        System.out.println("beforeReturnMethodsFromUniLibrary: writing Log #2");
    }

    @Before("allGetAndReturnMethodsFromUniLibrary()")
    public void beforeGetAndReturnMethodsFromUniLibrary() {
        System.out.println("beforeGetAndReturnMethodsFromUniLibrary: writing Log #3");
    }

    //

    @Pointcut("execution(* com.example.spring_course_zaur.aspect_oriented_programming.UniLibrary.*(..))")
    private void allMethodsFromUniLibrary() {}

    @Before("execution(public void com.example.spring_course_zaur.aspect_oriented_programming.UniLibrary.returnMagazine())")
    public void returnMagazineFromUniLibrary() {
        System.out.println("returnMagazineFromUniLibrary: writing Log #4");
    }
}
