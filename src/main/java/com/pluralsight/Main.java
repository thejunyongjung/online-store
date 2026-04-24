package com.pluralsight;
import java.util.ArrayList;
import java.io.FileReader;
import java.io.IOException;
import java.io.BufferedReader;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Calling loadProducts
        ArrayList<Product> items = loadProducts("src/main/resources/Products.csv");

        // Home Screen
        boolean running = true;
        while (running) {
            System.out.println();
            System.out.println("==============================");
            System.out.println("     Welcome to the Store!     ");
            System.out.println("==============================");
            System.out.println("1. Display Products");
            System.out.println("2. Display Cart");
            System.out.println("3. Exit");
            System.out.println("==============================");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    displayProducts(items, scanner);
                    break;
                case 2:
                    break;
                case 3:
                    System.out.println();
                    System.out.println("Exiting...");
                    running = false;
                    break;
                default:
                    System.out.println();
                    System.out.println("Invalid choice. Going back to the Home Screen.");
                    break;
            }
        }
        System.out.println();
        System.out.println("Goodbye!");
        scanner.close();
    }

    private static void displayProducts(ArrayList<Product> items, Scanner scanner) {
        System.out.println();
        System.out.println("==============================");
        System.out.println("       Products Screen        ");
        System.out.println("==============================");
        for (Product product : items) {
            System.out.println(product);
        }

        while (true) {
            System.out.println("==============================");
            System.out.println("1. Search by Name");
            System.out.println("2. Search by Price");
            System.out.println("3. Search by Department");
            System.out.println("4. Add to Cart");
            System.out.println("0. Back to Home Screen");
            System.out.println("==============================");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1: // Search by Name
                    searchByName(items, scanner);
                    break;
                case 2: // Search by Price
                    searchByPrice(items, scanner);
                    break;
                case 3: // Search by Department
                    searchByDepartment(items, scanner);
                    break;
                case 4: // Add to Cart
                    break;
                case 0: // Back to Home Screen
                    System.out.println();
                    System.out.println("Going back to Home Screen!");
                    return;
                default:
                    System.out.println();
                    System.out.println("Invalid choice. Please try again.");
            }
        }

    }

    public static void searchByName(ArrayList<Product> items, Scanner scanner) {

        while (true) {
            System.out.println();
            System.out.print("Enter the product name to search: ");
            String name = scanner.nextLine().trim();

            if (name.isEmpty()) {
                System.out.println();
                System.out.println("Invalid product name!");
                continue;
            } else {
                boolean found = false;
                for (Product item : items) {
                    if (item.getName().toLowerCase().contains(name.toLowerCase())) {
                        System.out.println();
                        System.out.println("Item Found - " + item);
                        found = true;
                    }
                }
                if (!found) {
                    System.out.println();
                    System.out.println("Invalid product name!");
                }
            }
            if (!continueSearch(scanner)) { return; }
        }
    }

    public static void searchByPrice(ArrayList<Product> items, Scanner scanner) {

        while (true) {
            System.out.println();
            System.out.println("Enter the product price to search: ");
            double price = scanner.nextDouble();
            scanner.nextLine();

            if (price <= 0) {
                System.out.println();
                System.out.println("Invalid product price. Please try again.");
                continue;
            } else {
                boolean found = false;
                for (Product item : items) {
                    if (price >= item.getPrice()) {
                        System.out.println();
                        System.out.println("Item Found - " + item);
                        found = true;
                    }
                }
                if (!found) {
                    System.out.println();
                    System.out.println("Invalid product price. Please try again.");
                }
            }
            if (!continueSearch(scanner)) { return; }
        }
    }

    public static void searchByDepartment(ArrayList<Product> items, Scanner scanner) {
        while (true) {
            System.out.println();
            System.out.println("Enter the product department to search: ");
            String department = scanner.nextLine().trim();

            if (department.isEmpty()) {
                System.out.println();
                System.out.println("Invalid product department. Please try again.");
                continue;
            } else {
                boolean found = false;
                for (Product item : items) {
                    if (item.getDepartment().toLowerCase().contains(department.toLowerCase())) {
                        System.out.println();
                        System.out.println("Item Found - " + item);
                        found = true;
                    }
                }
                if (!found) {
                    System.out.println();
                    System.out.println("Invalid product department. Please try again.");
                }
            }
            if (!continueSearch(scanner)) { return; }
        }
    }

    public static ArrayList<Product> loadProducts(String filePath) {
        // Create an empty ArrayList
        ArrayList<Product> items = new ArrayList<>();

        // Open and read CSV file
        try (BufferedReader br = new BufferedReader(new FileReader(filePath)))
        {
            // Skip the header line
            br.readLine();

            String line;

            // Read each line until the end of the file
            while ((line = br.readLine()) != null) {
                String[] tokens = line.split("\\|");

                // Parse each value into each data type
                String sku = tokens[0];
                String name = tokens[1];
                double price = Double.parseDouble(tokens[2]);
                String department = tokens[3];

                // Create a Product object and add it to the ArrayList
                items.add(new Product(sku, name, price, department));
            }
        } catch (IOException e) {
            System.out.println("Error reading file");
        }
        return items;
    }

    public static boolean continueSearch(Scanner scanner) {
        System.out.println();
        System.out.print("Do you want to continue to search? (y/n): ");
        String answer = scanner.nextLine().trim();

        switch (answer) {
            case "y":
            case "Y":
                return true;
            case "n":
            case "N":
                System.out.println();
                System.out.println("Going back to Product Screen!");
                return false;
            default:
                System.out.println("Invalid choice. Please try again.");
                return continueSearch(scanner);
        }
    }
}
