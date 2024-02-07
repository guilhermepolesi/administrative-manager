package com.guilherme.administrativemanager.repositories;

import com.guilherme.administrativemanager.entities.Stock;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StockRepository extends JpaRepository<Stock, Long> {

}
