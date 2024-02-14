package com.guilherme.administrativemanager.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.guilherme.administrativemanager.entities.pk.SalesOrderItemPK;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "tb_sales_order_item")
public class SalesOrderItem implements Serializable {

    private static final long serialVersionUID = 1L;

    @EmbeddedId
    private SalesOrderItemPK id = new SalesOrderItemPK();

    private Integer quantity;
    private Double price;

    public SalesOrderItem() {
    }

    public SalesOrderItem(SalesOrder salesOrder, Product product, Integer quantity, Double price) {
        id.setSalesOrder(salesOrder);
        id.setProduct(product);
        this.quantity = quantity;
        this.price = price;
    }

    @JsonIgnore
    public SalesOrder getSalesOrder(){
        return id.getSalesOrder();
    }

    public void setSalesOrder(SalesOrder salesOrder){
        id.setSalesOrder(salesOrder);
    }

    public Product getProduct() {
        return id.getProduct();
    }

    public void setProduct(Product product) {
        id.setProduct(product);
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getSubTotal() {
        return price * quantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SalesOrderItem that)) return false;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
    
}
