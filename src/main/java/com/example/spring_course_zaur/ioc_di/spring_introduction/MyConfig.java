package com.example.spring_course_zaur.ioc_di.spring_introduction;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan("com.example.spring_course_zaur.ioc_di.spring_introduction")
@PropertySource("classpath:myApp.properties") // вместо @Value
public class MyConfig {
}
