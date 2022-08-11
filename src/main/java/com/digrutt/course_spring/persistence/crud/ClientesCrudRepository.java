package com.digrutt.course_spring.persistence.crud;

import com.digrutt.course_spring.persistence.entity.Clientes;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ClientesCrudRepository extends CrudRepository<Clientes, Integer> {

    //Query Method
    Clientes findById(int id);
    List<Clientes> findByIdOrderByIdDesc();

    //Query Native
    @Query(value = "SELECT * FROM clientes order by id asc",nativeQuery = true)
    List<Clientes> getClientesOrderIdAsc();
}
