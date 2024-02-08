package com.guilherme.administrativemanager.repositories;

import com.guilherme.administrativemanager.entities.SalesOrder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SalesOrderRepository extends JpaRepository<SalesOrder, Long> {

}
