package com.digrutt.course_spring.persistence.mapper;

import com.digrutt.course_spring.domain.Product;
import com.digrutt.course_spring.persistence.entity.Producto;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring", uses = {CategoryMapper.class})
//Con el uses = {} le especificamos que en los Mapping uno de ellos vamos a convertir
//categoria dentro de Category tiene que usar CategoryMapper.class
public interface ProductMapper {

    @Mappings({
            //Siempre tendra esta forma
            @Mapping(source = "idProducto", target = "productId"),
            @Mapping(source = "nombre", target = "name"),
            @Mapping(source = "idCategoria", target = "categoryId"),
            @Mapping(source = "precioVenta", target = "price"),
            @Mapping(source = "cantidadStock", target = "stock"),
            @Mapping(source = "estado", target = "active"),
            @Mapping(source = "categoria", target = "category")
    })
    Product toProduct(Producto producto);
    List<Product> toProducts(List<Producto> products);

    @InheritInverseConfiguration
    @Mapping(target = "codigoBarras", ignore = true)
    Producto toProducto(Product poProduct);
}
