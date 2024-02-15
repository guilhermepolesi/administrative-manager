package com.guilherme.administrativemanager.services;

import com.guilherme.administrativemanager.entities.Product;
import com.guilherme.administrativemanager.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public Product insert(Product obj) {
        return productRepository.save(obj);
    }

    public List<Product> findAll() {
        return productRepository.findAll();
    }

    public Product findById(Long id) {
        Optional<Product> obj = productRepository.findById(id);
        return obj.get();
    }

    public Product update(Long id, Product obj) {
        Product entity = productRepository.getReferenceById(id);
        updateData(entity, obj);
        return productRepository.save(entity);
    }

    private void updateData(Product entity, Product obj) {
        entity.setName(obj.getName());
        entity.setPrice(obj.getPrice());
    }
    
}
