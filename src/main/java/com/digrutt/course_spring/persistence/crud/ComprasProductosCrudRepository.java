package com.digrutt.course_spring.persistence.crud;

import com.digrutt.course_spring.persistence.entity.ComprasProductos;
import com.digrutt.course_spring.persistence.entity.ComprasProductosPK;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface ComprasProductosCrudRepository extends CrudRepository<ComprasProductos, ComprasProductosPK> {

    //Query Method
    Optional<ComprasProductos> findById(ComprasProductosPK id);
    List<ComprasProductos> findByIdOrderByCantidadAsc();
    List<ComprasProductos> findByIdOrderByCantidadDesc();

    //Query Native
    @Query(value = "SELECT * FROM compras_productos ORDER BY total DESC",nativeQuery = true)
    List<ComprasProductos> getComprasProductosTotalDesc();

    @Query(value = "SELECT * FROM compras_productos ORDER BY total ASC",nativeQuery = true)
    List<ComprasProductos> getComprasProductosTotalAsc();

}
