package com.guilherme.administrativemanager.config;

import com.guilherme.administrativemanager.entities.*;
import com.guilherme.administrativemanager.repositories.ClientRepository;
import com.guilherme.administrativemanager.repositories.DepartmentRepository;
import com.guilherme.administrativemanager.repositories.SupplierRepository;
import com.guilherme.administrativemanager.repositories.UserRepository;
import com.guilherme.administrativemanager.utils.Address;
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

    @Autowired
    private SupplierRepository supplierRepository;

    @Autowired
    private ClientRepository clientRepository;


    @Override
    public void run(String... args) throws Exception {

        Department department1 = new Department(null, DepartmentCategory.PROCUREMENT);
        Department department2 = new Department(null, DepartmentCategory.SALES);

        departmentRepository.saveAll(Arrays.asList(department1, department2));

        User user1 = new User(null, "12-3456789", "Ada Lovelace", new Department(department1.getId(), department1.getDepartmentCategory()));
        User user2 = new User(null, "123-45-6789", "Alan Turing", new Department(department2.getId(), department2.getDepartmentCategory()));

        userRepository.saveAll(Arrays.asList(user1, user2));

        Supplier supplier1 = new Supplier(null, "12-3456789", "Sony", new Address("Main street", 456, "New York", "10001", "USA"));
        Supplier supplier2 = new Supplier(null, "123-45-6789", "Canonical", new Address("Blossom Lane", 456, "Los Angeles", "90001", "USA"));

        supplierRepository.saveAll(Arrays.asList(supplier1, supplier2));

        Client client1 = new Client(null, "12-3456789", "JFA", new Address("Elm Street", 789, "Chicago", "60601", "USA"));
        Client client2 = new Client(null, "123-45-6789", "Joe Ramone", new Address("Maple Avenue", 1011, "Houston", "77001", "USA"));

        clientRepository.saveAll(Arrays.asList(client1, client2));

    }
}