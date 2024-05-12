package Low_Level_Design.Design_Patterns.Structural.Flyweight;

import java.util.HashMap;
import java.util.Map;

// Flyweight interface
interface Product {
    void display(double price);
}

// Concrete flyweight class representing a product
//Contains name and description which is shared between many products

class ConcreteProduct implements Product {
    private String name;
    private String description;

    public ConcreteProduct(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public void display(double price) {
        System.out.println("Product: " + name);
        System.out.println("Description: " + description);
        System.out.println("Price: $" + price);
        System.out.println("-------------------------");
    }
}

// Flyweight factory to manage flyweight objects
//For re-using already instantiated objects, saving memory

class ProductFactory {
    private static Map<String, Product> products = new HashMap<>();

    // Get or create a flyweight product
    public static Product getProduct(String name, String description) {
        // Check if product already exists in the map
        Product product = products.get(name);

        // If product doesn't exist, create a new one and store it in the map
        if (product == null) {
            product = new ConcreteProduct(name, description);
            products.put(name, product);
        }

        return product;
    }
}

// Context class to create the final product with extrinsic fields
// This type of objects can be created in large numbers
// as they contain just one field and one reference field, hence small in size.


class Context {
    private Product product;
    private double price;

    public Context(String name, String description, double price) {
        // Create or retrieve the flyweight product
        this.product = ProductFactory.getProduct(name, description);
        this.price = price;
    }

    public void displayProduct() {
        // Display product information with extrinsic field (price)
        product.display(price);
    }
}


public class FlyWeightClient {

    public static void main(String[] args) {
        // Products data
        String[][] productsData = {
                {"Laptop", "High-performance laptop", "1200.00"},
                {"Phone", "Smartphone with advanced features", "800.00"},
                {"Tablet", "Portable tablet device", "500.00"},
                {"Laptop", "Basic laptop for everyday use", "700.00"}
        };

        // Display products with prices
        for (String[] data : productsData) {
            String name = data[0];
            String description = data[1];
            double price = Double.parseDouble(data[2]);

            // Create a new product context
            Context context = new Context(name, description, price);

            // Display product information
            context.displayProduct();
        }
    }
}
