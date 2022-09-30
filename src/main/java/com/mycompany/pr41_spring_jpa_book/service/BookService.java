/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.pr41_spring_jpa_book.service;

import com.mycompany.pr41_spring_jpa_book.entities.BookDetailEntity;
import com.mycompany.pr41_spring_jpa_book.entities.BookEntity;
import com.mycompany.pr41_spring_jpa_book.entities.CategoryEntity;
import com.mycompany.pr41_spring_jpa_book.repository.BookRepository;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author ldanh
 */
@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private CategoryService categoryService;

    public List<BookEntity> getBooks() {
        List<BookEntity> books = (List<BookEntity>) bookRepository.findAll();
        if (books != null && books.size() > 0) {
            return books;
        }
        return new ArrayList<>();
    }

    public BookEntity getBook(long id) {
        Optional<BookEntity> bookOpt = bookRepository.findById(id);
        if (bookOpt != null && bookOpt.isPresent()) {
            return bookOpt.get();
        }
        return new BookEntity();
    }

    public void addBook() {
        BookEntity book = new BookEntity();
        book.setAuthor("Michael Gates Gill");
        book.setName("How to Save Your Own Life");

        BookDetailEntity bd = new BookDetailEntity();
        bd.setBook(book);
        bd.setDescription("add new book");
        bd.setIsbn("9781592406036");
        bd.setNumberOfPage(182);
        bd.setPrice(201600);
        bd.setPublishDate(new Date());

        book.setBookDetail(bd);

        CategoryEntity category = categoryService.getCategory(3);
        book.setCategoryEntity(category);

        bookRepository.save(book);
        System.out.println(book.toString());
    }

    public void updateBook(long id) {
        BookEntity book = getBook(id);
        if (book.getId() > 0) {
            book.setName("Update name");
            book.getBookDetail().setNumberOfPage(100);
            book.getBookDetail().setDescription("update");

            CategoryEntity category = categoryService.getCategory(2);
            book.setCategoryEntity(category);

            bookRepository.save(book);
            System.out.println(book.toString());
        } else {
            System.out.println("Not Found!!!");
        }
    }

    public void deleteBook(long id) {
        bookRepository.deleteById(id);
        if (bookRepository.existsById(id)) {
            System.out.println("Delete fail!!");
        } else {
            System.out.println("Delete success!!");
        }
    }

    public void displayBookInCategory(long id) {
        CategoryEntity category
                = categoryService.getCategory(id);
        for (BookEntity book : category.getBooks()) {
            System.out.println(book.toString());
        }
    }
}
