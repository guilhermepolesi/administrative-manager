package com.guilherme.administrativemanager.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.guilherme.administrativemanager.entities.pk.PurchaseOrderItemPK;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "tb_purchase_order_item")
public class PurchaseOrderItem implements Serializable {

    private static final long serialVersionUID = 1L;

    @EmbeddedId
    private PurchaseOrderItemPK id = new PurchaseOrderItemPK();

    private Integer quantity;
    private Double price;

    public PurchaseOrderItem() {
    }

    public PurchaseOrderItem(PurchaseOrder purchaseOrder, Product product, Integer quantity, Double price) {
        id.setPurchaseOrder(purchaseOrder);
        id.setProduct(product);
        this.quantity = quantity;
        this.price = price;
    }

    @JsonIgnore
    public PurchaseOrder getPurchaseOrder() {
        return id.getPurchaseOrder();
    }

    public void setPurchaseOrder(PurchaseOrder purchaseOrder) {
        id.setPurchaseOrder(purchaseOrder);
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
        if (!(o instanceof PurchaseOrderItem that)) return false;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
