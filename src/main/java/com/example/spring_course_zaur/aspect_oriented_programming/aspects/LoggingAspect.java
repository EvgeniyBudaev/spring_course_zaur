package com.example.spring_course_zaur.aspect_oriented_programming.aspects;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAspect {
//    @Before("execution(public void get*())")
//    @Before("execution(public void com.example.spring_course_zaur.aspect_oriented_programming.UniLibrary.getBook())")
//    @Before("execution(public void getBook())")
//    @Before("execution(public void getBook(com.example.spring_course_zaur.aspect_oriented_programming.Book, ..))")
//    @Before("execution(* * (..))")
    @Before("execution(public void getBook(com.example.spring_course_zaur.aspect_oriented_programming.Book))")
    public void beforeGetBookAdvice() {
        System.out.println("beforeGetBookAdvice: попытка получить книгу");
    }

    @Before("execution(public void getJournal(String))")
    public void beforeGetJournalAdvice() {
        System.out.println("beforeGetJournalAdvice: попытка получить журнал");
    }

//    @Before("execution(public * returnBook())")
//    @Before("execution(* *())")
//    @Before("execution(public void *(..))")
    @Before("execution(* returnBook())")
    public void beforeReturnBookAdvice() {
        System.out.println("beforeReturnBookAdvice: попытка вернуть книгу");
    }
}
