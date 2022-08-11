package com.digrutt.course_spring.persistence;

import com.digrutt.course_spring.persistence.crud.ComprasCrudRepository;
import com.digrutt.course_spring.persistence.entity.Compras;

import java.util.List;

public class ComprasRepository {
    ComprasCrudRepository comprasCrudRepository;

    public List<Compras> getCompras(){
        return (List<Compras>) comprasCrudRepository.findAll();
    }

    public List<Compras> getComprasFechaAsc(){
        return comprasCrudRepository.getComprasOrderByFecha();
    }

    public List<Compras> getComprasFechaDesc(){
        return comprasCrudRepository.findByIdCompraOrderByFechaDesc();
    }

    public Compras getCompra(int idCompra){
        return comprasCrudRepository.findByIdCompra(idCompra);
    }
}
