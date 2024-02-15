package com.guilherme.administrativemanager.services;

import com.guilherme.administrativemanager.entities.ProductStock;
import com.guilherme.administrativemanager.repositories.ProductStockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class ProductStockService {

    @Autowired
    private ProductStockRepository productStockRepository;

    public List<ProductStock> findAll() {
        return productStockRepository.findAll();
    }

    public ProductStock findById(Long id) {
        Optional<ProductStock> obj = productStockRepository.findById(id);
        return obj.get();
    }

    public void addProductToStock(Long productId, Long stockId, int quantityToAdd) {
        ProductStock productStock = getProductStock(productId, stockId);
        int currentQuantity = productStock.getQuantity();
        int newQuantity = currentQuantity + quantityToAdd;
        productStock.setQuantity(newQuantity);
        productStockRepository.save(productStock);
    }

    public void removeProductFromStock(Long productId, Long stockId, int quantityToRemove) {
        ProductStock productStock = getProductStock(productId, stockId);
        int currentQuantity = productStock.getQuantity();
        if (currentQuantity < quantityToRemove) {
            throw new IllegalArgumentException("Insufficient quantity in stock");
        }
        int newQuantity = currentQuantity - quantityToRemove;
        productStock.setQuantity(newQuantity);
        productStockRepository.save(productStock);
    }

    private ProductStock getProductStock(Long productId, Long stockId) {
        Optional<ProductStock> productStockOptional = productStockRepository.findByProductIdAndStockId(productId, stockId);
        return productStockOptional.orElseThrow(() -> new NoSuchElementException("Product not found in stock"));
    }
    
}
