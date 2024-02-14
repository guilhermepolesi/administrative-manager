package com.guilherme.administrativemanager.repositories;

import com.guilherme.administrativemanager.entities.SalesOrderItem;
import com.guilherme.administrativemanager.entities.pk.SalesOrderItemPK;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SalesOrderItemRepository extends JpaRepository<SalesOrderItem, SalesOrderItemPK> {

}
