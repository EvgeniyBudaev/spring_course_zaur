package com.example.spring_course_zaur.aspect_oriented_programming;

import org.springframework.stereotype.Component;

@Component
public class UniLibrary extends AbstractLibrary {
    @Override
    public void getBook(Book book) {
        System.out.println("Мы берем книгу из UniLibrary " + book.getName());
        System.out.println("--------------------------");
    }

    public void getJournal(String journalName) {
        System.out.println("Мы берем журнал из UniLibrary " + journalName);
        System.out.println("--------------------------");
    }

    public void getMagazine() {
        System.out.println("Мы берем магазин из UniLibrary");
        System.out.println("--------------------------");
    }

    public void returnBook() {
        System.out.println("Мы возвращаем книгу в UniLibrary");
        System.out.println("--------------------------");
    }

    public void returnMagazine() {
        System.out.println("Мы возвращаем магазин в UniLibrary");
        System.out.println("--------------------------");
    }

    public void addBook(String person_name, Book book) {
        System.out.println("Мы добавляем книгу в UniLibrary");
        System.out.println("--------------------------");
    }

    public void addMagazine() {
        System.out.println("Мы добавляем магазин в UniLibrary");
        System.out.println("--------------------------");
    }
}
