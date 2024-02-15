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

    public Supplier insert(Supplier obj) {
        return supplierRepository.save(obj);
    }

    public List<Supplier> findAll() {
        return supplierRepository.findAll();
    }

    public Supplier findById(Long id) {
        Optional<Supplier> obj = supplierRepository.findById(id);
        return obj.get();
    }

    public Supplier update(Long id, Supplier obj) {
        Supplier entity = supplierRepository.getReferenceById(id);
        updateData(entity, obj);
        return supplierRepository.save(entity);
    }

    private void updateData(Supplier entity, Supplier obj) {
        entity.setEinSsn(obj.getEinSsn());
        entity.setName(obj.getName());
        entity.setAddress(obj.getAddress());
    }

    public void delete(Long id) {
        supplierRepository.deleteById(id);
    }

}
