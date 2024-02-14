package com.guilherme.administrativemanager.entities;

import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "tb_purchase_order")
public class PurchaseOrder implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate date;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    @ManyToOne
    @JoinColumn(name = "supplier_id")
    private Supplier supplier;
    @OneToMany(mappedBy = "id.purchaseOrder")
    private Set<PurchaseOrderItem> purchaseOrderItems = new HashSet<>();

    public PurchaseOrder() {
    }

    public PurchaseOrder(Long id, LocalDate date, User user, Supplier supplier) {
        this.id = id;
        this.date = date;
        this.user = user;
        this.supplier = supplier;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Supplier getSupplier() {
        return supplier;
    }

    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }

    public Set<PurchaseOrderItem> getPurchaseOrderItems() {
        return purchaseOrderItems;
    }

    public Double getTotal() {
        double sum = 0.0;
        for (PurchaseOrderItem x : purchaseOrderItems) {
            sum += x.getSubTotal();
        }
        return sum;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PurchaseOrder that)) return false;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
