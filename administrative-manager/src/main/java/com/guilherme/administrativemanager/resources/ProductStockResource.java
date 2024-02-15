package com.guilherme.administrativemanager.resources;

import com.guilherme.administrativemanager.entities.ProductStock;
import com.guilherme.administrativemanager.services.ProductStockService;
import com.guilherme.administrativemanager.utils.AddProductRequest;
import com.guilherme.administrativemanager.utils.RemoveProductRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/product-stocks")
public class ProductStockResource {

    @Autowired
    private ProductStockService productStockService;

    @PostMapping("/add")
    public ResponseEntity<String> addProductToStock(@RequestBody AddProductRequest obj) {
        productStockService.addProductToStock(obj.getProductId(), obj.getStockId(), obj.getQuantity());
        return ResponseEntity.ok().body("Product added to stock successfully");
    }

    @PostMapping("/remove")
    public ResponseEntity<String> removeProductFromStock(@RequestBody RemoveProductRequest obj) {
        productStockService.removeProductFromStock(obj.getProductId(), obj.getStockId(), obj.getQuantity());
        return ResponseEntity.ok().body("Product successfully removed from stock");
    }

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
