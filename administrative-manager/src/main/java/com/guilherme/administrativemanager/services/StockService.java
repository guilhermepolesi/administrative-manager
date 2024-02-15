package com.guilherme.administrativemanager.services;

import com.guilherme.administrativemanager.entities.Stock;
import com.guilherme.administrativemanager.repositories.StockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StockService {

    @Autowired
    private StockRepository stockRepository;

    public Stock insert(Stock obj) {
        return stockRepository.save(obj);
    }

    public List<Stock> findAll() {
        return stockRepository.findAll();
    }

    public Stock findById(Long id) {
        Optional<Stock> obj = stockRepository.findById(id);
        return obj.get();
    }

    public Stock update(Long id, Stock obj) {
        Stock entity = stockRepository.getReferenceById(id);
        updateData(entity, obj);
        return stockRepository.save(entity);
    }

    private void updateData(Stock entity, Stock obj) {
        entity.setName(obj.getName());
    }
    
}
