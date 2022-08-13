package com.digrutt.course_spring.persistence.mapper;

import com.digrutt.course_spring.domain.Purchase;
import com.digrutt.course_spring.persistence.entity.Compras;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring", uses = {PurchaseItemMapper.class})
public interface PurchaseMapper {

    @Mappings({
            @Mapping(source = "idCompra", target = "purchaseId"),
            @Mapping(source = "idCliente", target = "clientId"),
            @Mapping(source = "fecha", target = "date"),
            @Mapping(source = "medioPago", target = "paymentMethod"),
            @Mapping(source = "comentario", target = "comment"),
            @Mapping(source = "estado", target = "state"),
            @Mapping(source = "productosList", target = "item")
    })
    Purchase toPurchase(Compras compra);
    List<Purchase> toPurchases(List<Compras> compras);

    @InheritInverseConfiguration
    @Mapping(target = "cliente", ignore = true)
    Compras toCompra(Purchase purchase);
}
