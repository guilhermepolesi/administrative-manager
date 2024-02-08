package com.guilherme.administrativemanager.resources;

import com.guilherme.administrativemanager.entities.PurchaseOrder;
import com.guilherme.administrativemanager.services.PurchaseOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/purchase-orders")
public class PurchaseOrderResource {

    @Autowired
    private PurchaseOrderService purchaseOrderService;

    @GetMapping
    public ResponseEntity<List<PurchaseOrder>> findAll() {
        List<PurchaseOrder> list = purchaseOrderService.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<PurchaseOrder> findById(@PathVariable Long id) {
        PurchaseOrder obj = purchaseOrderService.findById(id);
        return ResponseEntity.ok().body(obj);
    }
    
}
