package com.digrutt.course_spring.persistence.mapper;

import com.digrutt.course_spring.domain.Category;
import com.digrutt.course_spring.persistence.entity.Categorias;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CategoryMapper {
    //Convirtiendo categorias dentro de category
    @Mappings({
            /*Respetando el nombre tal cual*/
            /*Source = de tal variable del Entity
            * target = y transportar a tal variable del domain*/
            @Mapping(source = "idCategoria", target = "categoryId"),
            @Mapping(source = "descripcion", target = "category"),
            @Mapping(source = "estado", target = "active")
    })
    Category toCategory(Categorias categoria);
    List<Category> toCategorys(List<Categorias> categoriasList);

    //Conversion externa
    //Indica que la conversion que vamos a realizar , es inversa
    //al mappings anterior
    @InheritInverseConfiguration
    //Le especificamos al mappign que NO usaremos la variable productos del Entity
    //@Mapping(target = "productos", ignore = true)
    Categorias toCategoria(Category category);
}
