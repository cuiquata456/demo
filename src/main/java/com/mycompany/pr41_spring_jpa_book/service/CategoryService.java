/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.pr41_spring_jpa_book.service;

import com.mycompany.pr41_spring_jpa_book.entities.CategoryEntity;
import com.mycompany.pr41_spring_jpa_book.repository.CategoryRepostory;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author ldanh
 */
@Service
public class CategoryService {

    @Autowired
    private CategoryRepostory categoryRepostory;

    public CategoryEntity getCategory(long id) {
        Optional<CategoryEntity> categoryOpt = categoryRepostory.findById(id);
        if (categoryOpt != null && categoryOpt.isPresent()) {
            return categoryOpt.get();
        }
        return new CategoryEntity();
    }
}
