package com.guilherme.administrativemanager.resources;

import com.guilherme.administrativemanager.entities.Department;
import com.guilherme.administrativemanager.entities.DepartmentCategory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/department")
public class DepartmentResource {

    @GetMapping
    public ResponseEntity<Department> findAll() {
        Department department = new Department(1L, DepartmentCategory.PROCUREMENT);
        return ResponseEntity.ok().body(department);
    }

}
