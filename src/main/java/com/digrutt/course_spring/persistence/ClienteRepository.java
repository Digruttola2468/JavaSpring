package com.digrutt.course_spring.persistence;

import com.digrutt.course_spring.persistence.crud.ClientesCrudRepository;
import com.digrutt.course_spring.persistence.entity.Clientes;

import java.util.List;

public class ClienteRepository {
    ClientesCrudRepository clientesCrudRepository;

    public Clientes getCliente(int id){
        return clientesCrudRepository.findById(id);
    }

    public List<Clientes> getClientes(){
        return (List<Clientes>) clientesCrudRepository.findAll();
    }

    public List<Clientes> getClientesIdAsc(){
        return clientesCrudRepository.getClientesOrderIdAsc();
    }

    public List<Clientes> getClientesIdDec(){
        return clientesCrudRepository.findByIdOrderByIdDesc();
    }
}
