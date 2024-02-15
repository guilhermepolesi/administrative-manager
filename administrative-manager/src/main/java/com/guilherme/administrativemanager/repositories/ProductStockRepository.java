package com.guilherme.administrativemanager.repositories;

import com.guilherme.administrativemanager.entities.ProductStock;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProductStockRepository extends JpaRepository<ProductStock, Long> {
    Optional<ProductStock> findByProductIdAndStockId(Long productId, Long stockId);
}
