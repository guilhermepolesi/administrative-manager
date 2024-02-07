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

    public List<Stock> findAll() {
        return stockRepository.findAll();
    }

    public Stock findById(Long id) {
        Optional<Stock> obj = stockRepository.findById(id);
        return obj.get();
    }
    
}
