package com.digrutt.course_spring.domain.repository;

import com.digrutt.course_spring.domain.Category;
import com.digrutt.course_spring.domain.Product;

import java.util.List;
import java.util.Optional;

public interface CategoryRepository {
    Optional<Category> getCategory(int categoryId);
    List<Category> getAll();
    List<Category> getEstadoTrue();
    List<Category> getEstadoFalse();
    Category save(Category categorySave);
    void delete(int categoryId);
}
