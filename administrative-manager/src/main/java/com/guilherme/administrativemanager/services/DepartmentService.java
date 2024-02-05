package com.guilherme.administrativemanager.services;

import com.guilherme.administrativemanager.entities.Department;
import com.guilherme.administrativemanager.repositories.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    public List<Department> findAll() {
        return departmentRepository.findAll();
    }

    public Department findById(Long id) {
        Optional<Department> obj = departmentRepository.findById(id);
        return obj.get();
    }

}
