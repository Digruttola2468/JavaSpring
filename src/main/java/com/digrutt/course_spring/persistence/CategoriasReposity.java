package com.digrutt.course_spring.persistence;

import com.digrutt.course_spring.domain.Category;
import com.digrutt.course_spring.domain.repository.CategoryRepository;
import com.digrutt.course_spring.persistence.crud.CategoriasCrudRepository;
import com.digrutt.course_spring.persistence.entity.Categorias;
import com.digrutt.course_spring.persistence.mapper.CategoryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class CategoriasReposity implements CategoryRepository {
    @Autowired
    CategoriasCrudRepository categoriasCrudRepository;
    @Autowired
    CategoryMapper mapper;

    @Override
    public Optional<Category> getCategory(int categoryId) {
        return categoriasCrudRepository.findById(categoryId).map( category -> mapper.toCategory(category));
    }

    @Override
    public List<Category> getAll() {
        List<Categorias> categorias = (List<Categorias>) categoriasCrudRepository.findAll();
        return mapper.toCategorys(categorias);
    }

    @Override
    public List<Category> getEstadoTrue() {
        List<Categorias> categorias = categoriasCrudRepository.getCategoriaEstadoFalse();
        return mapper.toCategorys(categorias);
    }

    @Override
    public List<Category> getEstadoFalse() {
        List<Categorias> categorias = categoriasCrudRepository.getCategoriaEstadoTrue();
        return mapper.toCategorys(categorias);
    }

    @Override
    public Category save(Category categorySave) {
        Categorias categorias = mapper.toCategoria(categorySave);
        return mapper.toCategory(categoriasCrudRepository.save(categorias));
    }

    @Override
    public void delete(int categoryId) {
        categoriasCrudRepository.deleteById(categoryId);
    }
}
