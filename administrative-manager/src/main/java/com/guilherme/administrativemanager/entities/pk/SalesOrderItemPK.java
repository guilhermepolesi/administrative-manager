package com.guilherme.administrativemanager.entities.pk;

import com.guilherme.administrativemanager.entities.Product;
import com.guilherme.administrativemanager.entities.SalesOrder;
import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class SalesOrderItemPK implements Serializable {

    private static final long serialVersionUID = 1L;

    @ManyToOne
    @JoinColumn(name = "sales_order_id")
    private SalesOrder salesOrder;

    @ManyToOne
    @JoinColumn(name = "sales_product_id")
    private Product product;

    public SalesOrder getSalesOrder() {
        return salesOrder;
    }

    public void setSalesOrder(SalesOrder salesOrder) {
        this.salesOrder = salesOrder;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SalesOrderItemPK that)) return false;
        return Objects.equals(salesOrder, that.salesOrder) && Objects.equals(product, that.product);
    }

    @Override
    public int hashCode() {
        return Objects.hash(salesOrder, product);
    }
}
