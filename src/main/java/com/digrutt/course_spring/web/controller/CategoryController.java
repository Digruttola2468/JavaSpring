package com.digrutt.course_spring.web.controller;

import com.digrutt.course_spring.domain.Category;
import com.digrutt.course_spring.domain.Product;
import com.digrutt.course_spring.domain.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
//
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/all")
    public List<Category> getAll(){
        return categoryService.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Category> getCategory(@PathVariable("id") int id){
        return categoryService.getCategory(id);
    }

    @GetMapping("/estado/{estado}")
    public List<Category> getEstadoTrue(@PathVariable("estado") boolean estado){
        if(!estado)
            return categoryService.getEstadoTrue();
        else
            return categoryService.getEstadoFalse();
    }

    @PostMapping("/save")
    public Category save(@RequestBody Category product){
        return categoryService.save(product);
    }

    @DeleteMapping("/delete/{id}")
    public boolean delete(@PathVariable("id") int id){
        return categoryService.delete(id);
    }
}
