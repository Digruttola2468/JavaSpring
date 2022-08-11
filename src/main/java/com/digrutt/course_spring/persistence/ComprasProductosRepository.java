package com.digrutt.course_spring.persistence;

import com.digrutt.course_spring.persistence.crud.ComprasProductosCrudRepository;
import com.digrutt.course_spring.persistence.entity.ComprasProductos;
import com.digrutt.course_spring.persistence.entity.ComprasProductosPK;

import java.util.List;
import java.util.Optional;

public class ComprasProductosRepository {
    ComprasProductosCrudRepository comprasProductosCrudRepository;

    public List<ComprasProductos> getComprasProductos(){
        return (List<ComprasProductos>) comprasProductosCrudRepository.findAll();
    }

    public Optional<ComprasProductos> getCompraProducto(ComprasProductosPK id){
        return comprasProductosCrudRepository.findById(id);
    }

    public List<ComprasProductos> getComprasProductosCantidadAsc(){
        return comprasProductosCrudRepository.findByIdOrderByCantidadAsc();
    }

    public List<ComprasProductos> getComprasProductosCantidadDesc(){
        return comprasProductosCrudRepository.findByIdOrderByCantidadDesc();
    }

    public List<ComprasProductos> getComprasProductosTotalAsc(){
        return comprasProductosCrudRepository.getComprasProductosTotalAsc();
    }

    public List<ComprasProductos> getComprasProductosTotalDesc(){
        return comprasProductosCrudRepository.getComprasProductosTotalDesc();
    }
}
