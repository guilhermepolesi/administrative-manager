package com.guilherme.administrativemanager.resources;

import com.guilherme.administrativemanager.entities.Supplier;
import com.guilherme.administrativemanager.services.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/suppliers")
public class SupplierResource {

    @Autowired
    private SupplierService supplierService;

    @PostMapping
    public ResponseEntity<Supplier> insert(@RequestBody Supplier obj) {
        obj = supplierService.insert(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}")
                .buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).body(obj);
    }

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

    @PutMapping(value = "/{id}")
    public ResponseEntity<Supplier> update(@PathVariable Long id, @RequestBody Supplier obj) {
        obj = supplierService.update(id, obj);
        return ResponseEntity.ok().body(obj);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        supplierService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
