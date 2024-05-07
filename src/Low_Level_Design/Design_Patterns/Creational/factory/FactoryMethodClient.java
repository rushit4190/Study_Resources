package Low_Level_Design.Design_Patterns.Creational.factory;
//Common interface

import java.util.Scanner;

interface Product {
    void displayInfo();
}

// Concrete Products

class ElectronicsProduct implements Product {
    @Override
    public void displayInfo() {
        System.out.println("This is an Electronics product.");
    }
}

class ClothingProduct implements Product {
    @Override
    public void displayInfo() {
        System.out.println("This is a Clothing product.");
    }
}

class BookProduct implements Product {
    @Override
    public void displayInfo() {
        System.out.println("This is a Book product.");
    }
}

// Creator Interface

interface ProductFactory {
    Product createProduct();
}

//Concrete Creators

class ElectronicsFactory implements ProductFactory {
    @Override
    public Product createProduct() {
        return new ElectronicsProduct();
    }
}

class ClothingFactory implements ProductFactory {
    @Override
    public Product createProduct() {
        return new ClothingProduct();
    }
}

class BookFactory implements ProductFactory {
    @Override
    public Product createProduct() {
        return new BookProduct();
    }
}

//Client Code

public class FactoryMethodClient {
    public static void main(String[] args) throws Exception {

        System.out.println("Enter type of product you wanna buy-");
        System.out.println("Options are Electronics, Clothing and Book");

        Scanner s = new Scanner(System.in);
        String typeOfProduct = s.next();

        ProductFactory productFactory;

        switch(typeOfProduct){
            case "Electronics":
                productFactory = new ElectronicsFactory();
                break;

            case "Clothing":
                productFactory = new ClothingFactory();
                break;

            case "Book":
                productFactory = new BookFactory();
                break;

            default:
                throw new Exception("Invalid input, choose from the above options");
        }

        s.close();

        Product product = productFactory.createProduct();
        product.displayInfo();
    }
}
