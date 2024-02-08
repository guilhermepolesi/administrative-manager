package com.guilherme.administrativemanager.services;


import com.guilherme.administrativemanager.entities.SalesOrder;
import com.guilherme.administrativemanager.repositories.SalesOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SalesOrderService {

    @Autowired
    private SalesOrderRepository salesOrderRepository;

    public List<SalesOrder> findAll() {
        return salesOrderRepository.findAll();
    }

    public SalesOrder findById(Long id) {
        Optional<SalesOrder> obj = salesOrderRepository.findById(id);
        return obj.get();
    }
}
