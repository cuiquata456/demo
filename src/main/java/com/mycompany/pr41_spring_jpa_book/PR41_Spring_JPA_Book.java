/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */
package com.mycompany.pr41_spring_jpa_book;

import com.mycompany.pr41_spring_jpa_book.configuration.SpringConfig;
import com.mycompany.pr41_spring_jpa_book.entities.BookEntity;
import com.mycompany.pr41_spring_jpa_book.service.BookService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 *
 * @author ldanh
 */
public class PR41_Spring_JPA_Book {
    
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
        BookService bookService = (BookService) context.getBean("bookService");
//        displayBooks(bookService);
//        displayBook(bookService);
//        addBook(bookService);
//        updateBook(bookService);
//        deleteBook(bookService);
        //displayBookInCategory(bookService);
    }
    
    public static void displayBooks(BookService bookService) {
        for (BookEntity book : bookService.getBooks()) {
            System.out.println(book.toString());
        }
    }
    
    public static void displayBook(BookService bookService) {
        System.out.println(bookService.getBook(1));
    }
    
    public static void addBook(BookService bookService) {
        bookService.addBook();
    }
    
    public static void updateBook(BookService bookService) {
        bookService.updateBook(5);
    }
    
    public static void deleteBook(BookService bookService) {
        bookService.deleteBook(5);
    }
    
    public static void displayBookInCategory(BookService bookService) {
        bookService.displayBookInCategory(1);
    }
}
