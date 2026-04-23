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
}
