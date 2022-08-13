package com.digrutt.course_spring.domain.service;

import com.digrutt.course_spring.domain.Product;
import com.digrutt.course_spring.domain.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

//Esta anotacion se puede reemplazar por @Compoent pero es una mala practica
//Porque al definirle que va a ser un Servicio
@Service
public class ProductService {
    /*Colocamos @Autowired a una interfaz que no implementa de Spring;
    * pero como esa interfaz es implementada en una clase donde esta
    * instanciada con Spring entonces no hay problema en agregar la anotacion*/
    @Autowired
    private ProductRepository productRepository;

    /*Esta clase ProductService sirve como un intermediador entre el controlador y la capa de Repositorio*/
    /*Estamos trabajando en terminos del dominio y el servicio desconoce de esa operacion ya sea por ejemplo save()*/
    public List<Product> getAll(){
        return productRepository.getAll();
    }

    public Optional<Product> getProduct(int productId){
        return productRepository.getProduct(productId);
    }

    Optional<List<Product>> getByCategory(int categoryId){
        return productRepository.getByCategory(categoryId);
    }

    Product save(Product product){
        return productRepository.save(product);
    }
    boolean delete(int productId){
        //El map se ejecuta si el product existe
        return getProduct(productId).map(product -> {
            productRepository.delete(productId);
            return true;
        }).orElse(false);

        //OR

        /*if(getProduct(productId).isPresent()){
            productRepository.delete(productId);
            return true;
        }else
            return false;*/
    }
}
