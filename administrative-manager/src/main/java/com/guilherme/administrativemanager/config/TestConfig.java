package com.guilherme.administrativemanager.config;

import com.guilherme.administrativemanager.entities.Department;
import com.guilherme.administrativemanager.entities.DepartmentCategory;
import com.guilherme.administrativemanager.repositories.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.Arrays;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    @Autowired
    private DepartmentRepository departmentRepository;


    @Override
    public void run(String... args) throws Exception {

        Department department1 = new Department(null, DepartmentCategory.PROCUREMENT);
        Department department2 = new Department(null, DepartmentCategory.SALES);

        departmentRepository.saveAll(Arrays.asList(department1, department2));

    }
}
