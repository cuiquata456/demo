/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.pr41_spring_jpa_book.repository;

import com.mycompany.pr41_spring_jpa_book.entities.BookEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author ldanh
 */
@Repository
public interface BookRepository
        extends CrudRepository<BookEntity, Long> {

}
