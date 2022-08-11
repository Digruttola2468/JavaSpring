package com.digrutt.course_spring.persistence.crud;


import com.digrutt.course_spring.persistence.entity.Producto;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

//CrudRepository<Tabla,Tipo de la clave primaria>
public interface ProductoCrudRepository extends CrudRepository<Producto, Integer> {
    //Query Method
    //Es mucho mejor usar Query method porque garantiza una mejor flexibilidad
    List<Producto> findByIdCategoriaOrderByNombreAsc(int idCategoria);
    // "findBy" + nombre variable en la clase producto (respetando Camel Case)
    // findByCantidadStockLessThanAndEstado(se tiene que llamar igual al nombre y tipo de variable en la clase producto)
    Optional<List<Producto>> findByCantidadStockLessThanAndEstado(int cantidadStock, boolean estado);
    //OR

    //Pero vale la pena que se puede hacer de manera nativa
    @Query(value = "SELECT * FROM productos WHERE id_categoria = ?", nativeQuery = true)
    List<Producto> getByCategoria(int idCategoria);
}
