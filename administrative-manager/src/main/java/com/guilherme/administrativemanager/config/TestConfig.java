package com.guilherme.administrativemanager.config;

import com.guilherme.administrativemanager.entities.Department;
import com.guilherme.administrativemanager.entities.DepartmentCategory;
import com.guilherme.administrativemanager.entities.User;
import com.guilherme.administrativemanager.repositories.DepartmentRepository;
import com.guilherme.administrativemanager.repositories.UserRepository;
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

    @Autowired
    private UserRepository userRepository;


    @Override
    public void run(String... args) throws Exception {

        Department department1 = new Department(null, DepartmentCategory.PROCUREMENT);
        Department department2 = new Department(null, DepartmentCategory.SALES);

        departmentRepository.saveAll(Arrays.asList(department1, department2));

        User user1 = new User(null, "568.987.600-98", "Ada Lovelace", new Department(department1.getId(), department1.getDepartmentCategory()));
        User user2 = new User(null, "878.546.232-99", "Alan Turing", new Department(department2.getId(), department2.getDepartmentCategory()));

        userRepository.saveAll(Arrays.asList(user1, user2));

    }
}
