package com.guilherme.administrativemanager.resources;

import com.guilherme.administrativemanager.entities.Stock;
import com.guilherme.administrativemanager.services.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/stocks")
public class StockResource {

    @Autowired
    private StockService stockService;

    @PostMapping
    public ResponseEntity<Stock> insert(@RequestBody Stock obj) {
        obj = stockService.insert(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}")
                .buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).body(obj);
    }

    @GetMapping
    public ResponseEntity<List<Stock>> findAll() {
        List<Stock> list = stockService.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Stock> findById(@PathVariable Long id) {
        Stock obj = stockService.findById(id);
        return ResponseEntity.ok().body(obj);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Stock> update(@PathVariable Long id, @RequestBody Stock obj) {
        obj = stockService.update(id, obj);
        return ResponseEntity.ok().body(obj);
    }

}
