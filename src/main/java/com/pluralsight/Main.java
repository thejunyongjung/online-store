package com.pluralsight;
import java.util.ArrayList;
import java.io.FileReader;
import java.io.IOException;
import java.io.BufferedReader;

public class Main {
    public static void main(String[] args) {

        // Create an empty ArrayList
        ArrayList<Product> items = new ArrayList<>();

        // Open and read CSV file
        try (BufferedReader br = new BufferedReader(new FileReader("src/main/resources/Products.csv")))
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

        // Display all products
        for (Product item : items) {
            System.out.println(item);
        }

    }
}
