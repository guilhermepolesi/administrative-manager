package com.guilherme.administrativemanager.resources;

import com.guilherme.administrativemanager.entities.ProductStock;
import com.guilherme.administrativemanager.services.ProductStockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/product-stocks")
public class ProductStockResource {

    @Autowired
    private ProductStockService productStockService;

    @GetMapping
    public ResponseEntity<List<ProductStock>> findAll() {
        List<ProductStock> list = productStockService.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<ProductStock> findById(@PathVariable Long id) {
        ProductStock obj = productStockService.findById(id);
        return ResponseEntity.ok().body(obj);
    }

}
