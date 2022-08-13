package com.digrutt.course_spring.persistence.crud;

import com.digrutt.course_spring.persistence.entity.Categorias;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CategoriasCrudRepository extends CrudRepository<Categorias, Integer> {

    @Query(value = "SELECT * FROM categorias where estado = false" , nativeQuery = true)
    List<Categorias> getCategoriaEstadoFalse();

    @Query(value = "SELECT * FROM categorias where estado = true", nativeQuery = true)
    List<Categorias> getCategoriaEstadoTrue();
}
