package com.digrutt.course_spring.persistence;

import com.digrutt.course_spring.domain.Product;
import com.digrutt.course_spring.domain.repository.ProductRepository;
import com.digrutt.course_spring.persistence.crud.ProductoCrudRepository;
import com.digrutt.course_spring.persistence.entity.Producto;
import com.digrutt.course_spring.persistence.mapper.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.awt.desktop.PreferencesEvent;
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
/*Para orientar el producto repository al dominio lo primero que tenemos que hacer
* es implementar la interfaz*/
/*No esto evitamos que nuestro proyecto se acomple a una base de datos, */
public class ProductoRepository implements ProductRepository {
    //Estas interfaces no estan inicializadas por ende si queremos realizar un accion con ellas
    //Nos devuelve un NullPointerException
    //La solucion para esto es que Spring se encargue de inicializarlas
    @Autowired
    private ProductoCrudRepository productoCrudRepository;

    //Es obligatorio saber que esa interfaz que Spring va a inicializar (ProductMapper.class)
    //sea parte tambien de un componente de Spring
    @Autowired
    private ProductMapper mapper;

    @Override
    public List<Product> getAll(){
        List<Producto> produc = (List<Producto>) productoCrudRepository.findAll();
        return mapper.toProducts(produc);
    }

    @Override
    public Optional<List<Product>> getByCategory(int categoryId){
        List<Producto> productos = productoCrudRepository.findByIdCategoriaOrderByNombreAsc(categoryId);
        return Optional.of(mapper.toProducts(productos));
    }

    @Override
    public Optional<List<Product>> getScarseProducts(int quantity) {
        Optional<List<Producto>> productos = productoCrudRepository.findByCantidadStockLessThanAndEstado(quantity,true);
        return productos.map( prods -> mapper.toProducts(prods) );
    }

    @Override
    public Optional<Product> getProduct(int productId) {
        return productoCrudRepository.findById(productId).map(product -> mapper.toProduct(product));
    }

    @Override
    public Product save(Product product) {
        Producto producto = mapper.toProducto(product);
        return mapper.toProduct(productoCrudRepository.save(producto));
    }

    //Delete
    @Override
    public void delete(int productId){
        productoCrudRepository.deleteById(productId);
    }
}
