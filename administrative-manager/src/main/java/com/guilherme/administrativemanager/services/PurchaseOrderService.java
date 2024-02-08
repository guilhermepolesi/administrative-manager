package com.guilherme.administrativemanager.services;

import com.guilherme.administrativemanager.entities.PurchaseOrder;
import com.guilherme.administrativemanager.repositories.PurchaseOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PurchaseOrderService {

    @Autowired
    private PurchaseOrderRepository purchaseOrderRepository;

    public List<PurchaseOrder> findAll() {
        return purchaseOrderRepository.findAll();
    }

    public PurchaseOrder findById(Long id) {
        Optional<PurchaseOrder> obj = purchaseOrderRepository.findById(id);
        return obj.get();
    }
    
}
