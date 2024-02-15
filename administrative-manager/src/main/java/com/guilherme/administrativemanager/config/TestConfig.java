package com.guilherme.administrativemanager.config;

import com.guilherme.administrativemanager.entities.*;
import com.guilherme.administrativemanager.repositories.*;
import com.guilherme.administrativemanager.utils.Address;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

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

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private StockRepository stockRepository;

    @Autowired
    private ProductStockRepository productStockRepository;

    @Autowired
    private PurchaseOrderRepository purchaseOrderRepository;

    @Autowired
    private SalesOrderRepository salesOrderRepository;

    @Autowired
    private PurchaseOrderItemRepository purchaseOrderItemRepository;

    @Autowired
    private SalesOrderItemRepository salesOrderItemRepository;

    @Override
    public void run(String... args) throws Exception {

        Department department1 = new Department(null, DepartmentCategory.PROCUREMENT);
        Department department2 = new Department(null, DepartmentCategory.SALES);

        departmentRepository.saveAll(Arrays.asList(department1, department2));

        User user1 = new User(null, "Ada Lovelace", department1);
        User user2 = new User(null, "Alan Turing", department2);

        userRepository.saveAll(Arrays.asList(user1, user2));

        Supplier supplier1 = new Supplier(null, "12-3456789", "Sony", new Address("Main street", 456, "New York", "10001", "USA"));
        Supplier supplier2 = new Supplier(null, "123-45-6789", "Canonical", new Address("Blossom Lane", 456, "Los Angeles", "90001", "USA"));

        supplierRepository.saveAll(Arrays.asList(supplier1, supplier2));

        Client client1 = new Client(null, "12-3456789", "JFA", new Address("Elm Street", 789, "Chicago", "60601", "USA"));
        Client client2 = new Client(null, "123-45-6789", "Joe Ramone", new Address("Maple Avenue", 1011, "Houston", "77001", "USA"));

        clientRepository.saveAll(Arrays.asList(client1, client2));

        Product product1 = new Product(null, "Computer", 1500.00);
        Product product2 = new Product(null, "Boxing Gloves", 50.00);

        productRepository.saveAll(Arrays.asList(product1, product2));

        Stock stock1 = new Stock(null, "Electronics");
        Stock stock2 = new Stock(null, "Sports");

        stockRepository.saveAll(Arrays.asList(stock1, stock2));

        ProductStock productStock1 = new ProductStock(null, product1, stock1, 100);
        ProductStock productStock2 = new ProductStock(null, product2, stock2, 50);

        productStockRepository.saveAll(Arrays.asList(productStock1, productStock2));



        PurchaseOrder purchaseOrder1 = new PurchaseOrder(null, LocalDate.now(), user1, supplier1);
        PurchaseOrder purchaseOrder2 = new PurchaseOrder(null, LocalDate.now(), user1, supplier2);
        purchaseOrderRepository.saveAll(Arrays.asList(purchaseOrder1, purchaseOrder2));
        PurchaseOrderItem purchaseOrderItem1 = new PurchaseOrderItem(purchaseOrder1, product1, 10, product1.getPrice());
        PurchaseOrderItem purchaseOrderItem2 = new PurchaseOrderItem(purchaseOrder1, product2, 20, product2.getPrice());
        PurchaseOrderItem purchaseOrderItem3 = new PurchaseOrderItem(purchaseOrder2, product2, 30, product2.getPrice());
        purchaseOrderItemRepository.saveAll(Arrays.asList(purchaseOrderItem1, purchaseOrderItem2, purchaseOrderItem3));



        SalesOrder salesOrder1 = new SalesOrder(null, LocalDate.now(), user2, client1);
        SalesOrder salesOrder2 = new SalesOrder(null, LocalDate.now(), user2, client2);
        salesOrderRepository.saveAll(Arrays.asList(salesOrder1, salesOrder2));
        SalesOrderItem salesOrderItem1 = new SalesOrderItem(salesOrder1, product1, 10, product1.getPrice());
        SalesOrderItem salesOrderItem2 = new SalesOrderItem(salesOrder1, product2, 20, product2.getPrice());
        SalesOrderItem salesOrderItem3 = new SalesOrderItem(salesOrder2, product2, 30, product2.getPrice());
        salesOrderItemRepository.saveAll(Arrays.asList(salesOrderItem1, salesOrderItem2, salesOrderItem3));



    }
}
