package com.guilherme.administrativemanager.resources;

import com.guilherme.administrativemanager.entities.Supplier;
import com.guilherme.administrativemanager.services.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/suppliers")
public class SupplierResource {

    @Autowired
    private SupplierService supplierService;

    @GetMapping
    public ResponseEntity<List<Supplier>> findAll() {
        List<Supplier> list = supplierService.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Supplier> findById(@PathVariable Long id) {
        Supplier obj = supplierService.findById(id);
        return ResponseEntity.ok().body(obj);
    }

}
