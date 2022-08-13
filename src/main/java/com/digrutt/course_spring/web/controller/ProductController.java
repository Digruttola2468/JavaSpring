package com.digrutt.course_spring.web.controller;

import com.digrutt.course_spring.domain.Product;
import com.digrutt.course_spring.domain.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

//Garantiza que esta clase va a ser controlador de una API REST
@RestController
//
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/all")
    public List<Product> getAll(){
        return productService.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Product> getProduct(@PathVariable("id") int productId){
        return productService.getProduct(productId);
    }

    /*Agregamos /category/{categoryId} para diferenciar entre el numero entero que le enviaremos a
    * /1 que pertenece a getProduct() por otra parte getByCategory /category/1
    */
    @GetMapping("/category/{categoryId}")
    Optional<List<Product>> getByCategory(@PathVariable("categoryId") int categoryId){
        return productService.getByCategory(categoryId);
    }

    @PostMapping("/save")
    public Product save(@RequestBody Product product){
        return productService.save(product);
    }

    @DeleteMapping("/delete/{id}")
    public boolean delete(@PathVariable("id") int productId){
        return productService.delete(productId);
    }
}
