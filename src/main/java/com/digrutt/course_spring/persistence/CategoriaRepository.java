package com.digrutt.course_spring.persistence;

import com.digrutt.course_spring.persistence.crud.CategoriasCrudRepository;
import com.digrutt.course_spring.persistence.entity.Categorias;

import java.util.List;

public class CategoriaRepository {
    CategoriasCrudRepository categoriasCrudRepository;

    public List<Categorias> getCategorias(){
        return (List<Categorias>) categoriasCrudRepository.findAll();
    }

    public Categorias getCategoria(int idCategoria){
        return categoriasCrudRepository.findByIdCategoria(idCategoria);
    }

    public List<Categorias> getCategoriasEstadoTrue(){
        return categoriasCrudRepository.findByEstadoTrue();
    }

    public List<Categorias> getCategoriasEstadoFalse(){
        return categoriasCrudRepository.getCategoriasEstadoFalse();
    }
}
