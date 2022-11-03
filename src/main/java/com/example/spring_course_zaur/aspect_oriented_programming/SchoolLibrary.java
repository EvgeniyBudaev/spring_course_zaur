package com.example.spring_course_zaur.aspect_oriented_programming;

import org.springframework.stereotype.Component;

@Component
public class SchoolLibrary extends AbstractLibrary {
    @Override
    public void getBook(Book book) {
        System.out.println("Мы берем книгу из SchoolLibrary " + book.getName());
    }
}
