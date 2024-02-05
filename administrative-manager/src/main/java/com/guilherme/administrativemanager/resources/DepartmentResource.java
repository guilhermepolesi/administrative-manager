package com.guilherme.administrativemanager.resources;

import com.guilherme.administrativemanager.entities.Department;
import com.guilherme.administrativemanager.entities.DepartmentCategory;
import com.guilherme.administrativemanager.services.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/department")
public class DepartmentResource {

    @Autowired
    private DepartmentService departmentService;
    @GetMapping
    public ResponseEntity<List<Department>> findAll() {
        List<Department> list = departmentService.findAll();

        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Department> findById(@PathVariable Long id) {
        Department obj = departmentService.findById(id);
        return ResponseEntity.ok().body(obj);
    }

}
