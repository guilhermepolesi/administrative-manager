package com.guilherme.administrativemanager.repositories;

import com.guilherme.administrativemanager.entities.PurchaseOrder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PurchaseOrderRepository extends JpaRepository<PurchaseOrder, Long> {

}
