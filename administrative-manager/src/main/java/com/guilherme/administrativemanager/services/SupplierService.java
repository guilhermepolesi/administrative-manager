package com.guilherme.administrativemanager.services;

import com.guilherme.administrativemanager.entities.Supplier;
import com.guilherme.administrativemanager.repositories.SupplierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SupplierService {

    @Autowired
    private SupplierRepository supplierRepository;

    public List<Supplier> findAll() {
        return supplierRepository.findAll();
    }

    public Supplier findById(Long id) {
        Optional<Supplier> obj = supplierRepository.findById(id);
        return obj.get();
    }

}
