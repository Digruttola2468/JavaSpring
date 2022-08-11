package com.digrutt.course_spring.persistence.entity;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

//Esta referenciada a una tabla de la base de datos
@Entity
//Como el nombre de la clase no es igual a la de base de datos colocamos @Table
@Table(name = "compras")
public class Compras {
    @Id
    //Le especificamos que es un ID unica (llave primaria)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_compra")
    private Integer idCompra;

    @Column(name = "id_cliente")
    private String idCliente;


    //Date no se usa mucho por ende usamos LocalDateTime
    private LocalDateTime fecha;

    @Column(name = "medio_pago")
    private String medioPago;

    private String comentario;
    private String estado;

    @ManyToOne
    @JoinColumn(name = "id_cliente", insertable = false, updatable = false)
    private Clientes cliente;

    @OneToMany(mappedBy = "producto")
    private List<ComprasProductos> productosList;

    //Getter Setter
    public Integer getIdCompra() {
        return idCompra;
    }

    public void setIdCompra(Integer idCompra) {
        this.idCompra = idCompra;
    }

    public String getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(String idCliente) {
        this.idCliente = idCliente;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }

    public String getMedioPago() {
        return medioPago;
    }

    public void setMedioPago(String medioPago) {
        this.medioPago = medioPago;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

}
