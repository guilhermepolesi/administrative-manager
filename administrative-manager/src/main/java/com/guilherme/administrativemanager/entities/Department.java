package com.guilherme.administrativemanager.entities;

import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;

public class Department implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private Long id;
    private DepartmentCategory departmentCategory;

    public Department() {
    }

    public Department(Long id, DepartmentCategory departmentCategory) {
        this.id = id;
        this.departmentCategory = departmentCategory;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public DepartmentCategory getDepartmentCategory() {
        return departmentCategory;
    }

    public void setDepartmentCategory(DepartmentCategory departmentCategory) {
        this.departmentCategory = departmentCategory;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Department that = (Department) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
