package com.digrutt.course_spring.persistence.entity;


import javax.persistence.*;

//Esta clase se comportara como una clase de la base de datos
@Entity
@Table(name = "productos")
public class Producto {

    //Es importante usar objetos NO PRIMITIVOS
    //private int id_producto;  //MAL

    //Le especificamos que es de tipo ID
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //Como le cambiamos el nombre le especificamos que columna es la que vamos a buscar
    @Column(name = "id_producto")
    private Integer idProducto;

    //Si el nombre de la variable es igual a la columna de la tabla
    //no hace falta agregar @Column(name = "nombre")
    private String nombre;

    @Column(name = "id_categoria")
    private Integer idCategoria;

    @Column(name = "codigo_barras")
    private String codigoBarras;

    @Column(name = "precio_venta")
    private Double precioVenta;

    @Column(name = "cantidad_stock")
    private Integer cantidadStock;

    private Boolean estado;

    @ManyToOne
    //No vamos a borrar o actualizar una nueva categoria
    @JoinColumn(name = "id_categoria", insertable = false, updatable = false)
    private Categorias categoria;

    public Integer getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Integer idProducto) {
        this.idProducto = idProducto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(Integer idCategoria) {
        this.idCategoria = idCategoria;
    }

    public String getCodigoBarras() {
        return codigoBarras;
    }

    public void setCodigoBarras(String codigoBarras) {
        this.codigoBarras = codigoBarras;
    }

    public Double getPrecioVenta() {
        return precioVenta;
    }

    public void setPrecioVenta(Double precioVenta) {
        this.precioVenta = precioVenta;
    }

    public Integer getCantidadStock() {
        return cantidadStock;
    }

    public void setCantidadStock(Integer cantidadStock) {
        this.cantidadStock = cantidadStock;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }
}
