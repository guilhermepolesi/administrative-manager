package com.guilherme.administrativemanager.services;

import com.guilherme.administrativemanager.entities.ProductStock;
import com.guilherme.administrativemanager.repositories.ProductStockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
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
    
}
