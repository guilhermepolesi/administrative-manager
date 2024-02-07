package com.guilherme.administrativemanager.resources;

import com.guilherme.administrativemanager.entities.Stock;
import com.guilherme.administrativemanager.services.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/stocks")
public class StockResource {

    @Autowired
    private StockService stockService;

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

}
