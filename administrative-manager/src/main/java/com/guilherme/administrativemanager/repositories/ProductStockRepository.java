package com.guilherme.administrativemanager.repositories;

import com.guilherme.administrativemanager.entities.ProductStock;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductStockRepository extends JpaRepository<ProductStock, Long> {

}
