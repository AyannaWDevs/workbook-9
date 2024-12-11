package com.pluralsight.NorthwindTradersSpringboot;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class SimpleProductDao implements ProductDao {
    private List<Product> employees; // Named 'employees' as per the instructions

    // Constructor
    public SimpleProductDao() {
        this.employees = new ArrayList<>();
        // sample products
        employees.add(new Product(1, "Laptop", "Electronics", 1200.50));
        employees.add(new Product(2, "Desk Chair", "Furniture", 150.99));
        employees.add(new Product(3, "Notebook", "Stationery", 5.25));
    }

    @Override
    public void add(Product product) {
        employees.add(product); // Using 'employees' to store products
    }

    @Override
    public List<Product> getAll() {
        return new ArrayList<>(employees); // Returning a copy of 'employees'
    }
}

}
