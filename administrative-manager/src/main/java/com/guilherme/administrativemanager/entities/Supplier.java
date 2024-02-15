package com.guilherme.administrativemanager.entities;

import com.guilherme.administrativemanager.utils.Address;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "tb_supplier")
public class Supplier implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String einSsn;
    private String name;
    @Embedded
    private Address address;

    public Supplier() {
    }

    public Supplier(Long id, String einSsn, String name, Address address) {
        this.id = id;
        this.einSsn = einSsn;
        this.name = name;
        this.address = address;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEinSsn() {
        return einSsn;
    }

    public void setEinSsn(String einSsn) {
        this.einSsn = einSsn;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Supplier supplier = (Supplier) o;
        return Objects.equals(id, supplier.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}
