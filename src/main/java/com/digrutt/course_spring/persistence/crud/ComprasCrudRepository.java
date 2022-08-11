package com.digrutt.course_spring.persistence.crud;

import com.digrutt.course_spring.persistence.entity.Compras;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ComprasCrudRepository extends CrudRepository<Compras, Integer> {

    //Query Method
    Compras findByIdCompra(int idCompra);
    List<Compras> findByIdCompraOrderByFechaDesc();

    //Query Native
    @Query(value = "SELECT * FROM compras ORDER BY fecha ASC",nativeQuery = true)
    List<Compras> getComprasOrderByFecha();
}
