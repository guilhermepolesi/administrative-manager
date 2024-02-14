package com.guilherme.administrativemanager.repositories;

import com.guilherme.administrativemanager.entities.PurchaseOrderItem;
import com.guilherme.administrativemanager.entities.pk.PurchaseOrderItemPK;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PurchaseOrderItemRepository extends JpaRepository<PurchaseOrderItem, PurchaseOrderItemPK> {

}
