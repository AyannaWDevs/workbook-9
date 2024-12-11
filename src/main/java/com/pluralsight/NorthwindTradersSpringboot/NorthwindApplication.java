package com.pluralsight.NorthwindTradersSpringboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;
import java.util.List;

@SpringBootApplication
public class NorthwindApplication implements CommandLineRunner {

    @Autowired
    private ProductDao productDao; // injects bean here

    @Override
    public void run(String... args) { //handles command line arguments passed

        Scanner scanner = new Scanner(System.in);
        boolean isRunning = true;

        while (isRunning) {
            System.out.println("\nNorthwind Application Menu:");
            System.out.println("1. List Employees");
            System.out.println("2. Add Employee");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> listEmployees();
                case 2 -> addEmployee(scanner);
                case 3 -> {
                    System.out.println("Exiting the application. Goodbye!");
                    isRunning = false;
                }
                default -> System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private void listEmployees() {
        List<Product> employees = productDao.getAll();
        if (employees.isEmpty()) {
            System.out.println("No employees found.");
        } else {
            System.out.println("\nEmployees:");
            employees.forEach(System.out::println);
        }
    }

    private void addEmployee(Scanner scanner) {
        System.out.print("Enter employee ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter employee name: ");
        String name = scanner.nextLine();

        System.out.print("Enter employee category: ");
        String category = scanner.nextLine();

        System.out.print("Enter employee price: ");
        double price = scanner.nextDouble();

        Product newEmployee = new Product(id, name, category, price);
        productDao.add(newEmployee);
        System.out.println("Employee added successfully!");
    }
}
