package com.digrutt.course_spring.domain.service;

import com.digrutt.course_spring.domain.Category;
import com.digrutt.course_spring.domain.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {
    @Autowired
    CategoryRepository categoryRepository;

    public List<Category> getAll(){
        return categoryRepository.getAll();
    }

    public Optional<Category> getCategory(int categoryId){
        return categoryRepository.getCategory(categoryId);
    }

    public List<Category> getEstadoTrue(){
        return categoryRepository.getEstadoTrue();
    }

    public List<Category> getEstadoFalse(){
        return categoryRepository.getEstadoFalse();
    }

    public Category save(Category category){
        return categoryRepository.save(category);
    }

    public boolean delete(int categoryId){
        if(getCategory(categoryId).isPresent()){
            categoryRepository.delete(categoryId);
            return true;
        }else
            return false;
    }
}
