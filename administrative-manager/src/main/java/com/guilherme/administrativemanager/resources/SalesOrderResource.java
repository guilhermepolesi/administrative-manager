package com.guilherme.administrativemanager.resources;


import com.guilherme.administrativemanager.entities.SalesOrder;
import com.guilherme.administrativemanager.services.SalesOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/sales-orders")
public class SalesOrderResource {

    @Autowired
    private SalesOrderService salesOrderService;

    @GetMapping
    public ResponseEntity<List<SalesOrder>> findAll() {
        List<SalesOrder> list = salesOrderService.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<SalesOrder> findById(@PathVariable Long id) {
        SalesOrder obj = salesOrderService.findById(id);
        return ResponseEntity.ok().body(obj);
    }

}
