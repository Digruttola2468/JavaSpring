package com.digrutt.course_spring.persistence;


import com.digrutt.course_spring.domain.Purchase;
import com.digrutt.course_spring.domain.repository.PurchaseRepository;
import com.digrutt.course_spring.persistence.crud.CompraCrudRepository;
import com.digrutt.course_spring.persistence.entity.Compras;
import com.digrutt.course_spring.persistence.mapper.PurchaseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class CompraRepository implements PurchaseRepository {

    @Autowired
    private CompraCrudRepository compraCrudRepository;

    @Autowired
    private PurchaseMapper mapper;

    @Override
    public List<Purchase> getAll() {
        return mapper.toPurchases((List<Compras>) compraCrudRepository.findAll());
    }

    @Override
    public Optional<List<Purchase>> getByClient(String clientId) {
        return compraCrudRepository.findByIdCliente(clientId)
                .map(product -> mapper.toPurchases(product));
    }

    @Override
    public Purchase save(Purchase purchase) {
        Compras compras = mapper.toCompra(purchase);
        compras.getProductosList().forEach(producto -> producto.setCompra(compras));

        return mapper.toPurchase(compraCrudRepository.save(compras));
    }
}
