package com.digrutt.course_spring.persistence;

import com.digrutt.course_spring.persistence.crud.ProductoCrudRepository;
import com.digrutt.course_spring.persistence.entity.Producto;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/*
@Component Generalizacion en este tipo de anotaciones,
indicandole que es un componente de Spring pero queda mejor @Repository
*/
/*
@Repository: le indicamos a la clase que es la encarga de interactuar con la base de datos.
*/
@Repository
public class ProductoRepository {
    private ProductoCrudRepository productoCrudRepository;

    public List<Producto> getAll(){
        return (List<Producto>) productoCrudRepository.findAll();
    }

    public List<Producto> getByCategoria(int idCategoria){
        return productoCrudRepository.findByIdCategoriaOrderByNombreAsc(idCategoria);
    }

    public Optional<List<Producto>> getEscasos(int cantidad,boolean estado){
        return productoCrudRepository.findByCantidadStockLessThanAndEstado(cantidad,estado);
    }

    public Optional<Producto> getProducto(int idProducto){
        return productoCrudRepository.findById(idProducto);
    }

    //Guardar
    public Producto save(Producto producto){
        return productoCrudRepository.save(producto);
    }
    //Delete
    public void delete(int idProducto){
        productoCrudRepository.deleteById(idProducto);
    }
}
