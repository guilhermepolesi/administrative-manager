package com.guilherme.administrativemanager.repositories;

import com.guilherme.administrativemanager.entities.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SupplierRepository extends JpaRepository<Supplier, Long> {

}
