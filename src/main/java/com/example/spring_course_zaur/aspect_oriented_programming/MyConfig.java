package com.example.spring_course_zaur.aspect_oriented_programming;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan("com.example.spring_course_zaur.aspect_oriented_programming")
@EnableAspectJAutoProxy
public class MyConfig {
}
