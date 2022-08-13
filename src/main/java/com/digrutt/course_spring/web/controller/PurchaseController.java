package com.digrutt.course_spring.web.controller;

import com.digrutt.course_spring.domain.Purchase;
import com.digrutt.course_spring.domain.service.PurchaseService;
import com.digrutt.course_spring.persistence.entity.ComprasProducto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/purchase")
public class PurchaseController {

    @Autowired
    private PurchaseService purchaseService;

    @GetMapping("/all")
    public List<Purchase> getAll(){
        return purchaseService.getAll();
    }

    @GetMapping("/{id}")
    public Optional<List<Purchase>> getByClient(@PathVariable("id") String clientId){
        return purchaseService.getByClient(clientId);
    }

    @PostMapping("/save")
    public Purchase save(@RequestBody Purchase purchase){
        return purchaseService.save(purchase);
    }
}
