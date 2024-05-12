package Low_Level_Design.Design_Patterns.Structural.Proxy;



import java.util.HashMap;
import java.util.Map;

// Subject interface
interface ProductService {
    Product getProductDetails(String productId);
}

// Real subject providing actual product information
class RealProductService implements ProductService {
    private Map<String, Product> productDetails;

    public RealProductService() {
        // Initialize product details
        productDetails = new HashMap<>();
        productDetails.put("p1", new Product("p1", "Product 1", "Description 1", 100.0));
        productDetails.put("p2", new Product("p2", "Product 2", "Description 2", 200.0));
        productDetails.put("p3", new Product("p3", "Product 3", "Description 3", 300.0));
    }

    public Product getProductDetails(String productId) {
        // Simulate fetching product details from a database
        // Here, we are using a simple map for demonstration
        return productDetails.get(productId);
    }
}

// Proxy class providing controlled access and caching
class ProductServiceProxy implements ProductService {
    private RealProductService realProductService;
    private Map<String, Product> cache;

    public ProductServiceProxy() {
        this.realProductService = new RealProductService();
        this.cache = new HashMap<>();
    }

    public Product getProductDetails(String productId) {
        // Check if product details are in the cache
        Product product = cache.get(productId);

        if (product == null) {
            // If not in cache, fetch from the real service and cache it
            product = realProductService.getProductDetails(productId);
            cache.put(productId, product);
            System.out.println("Product details fetched from database and cached for product " + productId);
        } else {
            System.out.println("Product details fetched from cache for product " + productId);
        }

        return product;
    }
}

// Product class
class Product {
    private String productId;
    private String name;
    private String description;
    private double price;

    public Product(String productId, String name, String description, double price) {
        this.productId = productId;
        this.name = name;
        this.description = description;
        this.price = price;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

}

// Client code

public class ProxyClient {

    public static void main(String[] args) {
        // Create a proxy
        ProductService productService = new ProductServiceProxy();

        // Request product details
        Product product1 = productService.getProductDetails("p1");
        System.out.println(product1.getName() + " - " + product1.getPrice());

        // Request product details again (should be fetched from cache)
        Product product2 = productService.getProductDetails("p1");
        System.out.println(product2.getName() + " - " + product2.getPrice());

        // Request another product details (not in cache)
        Product product3 = productService.getProductDetails("p2");
        System.out.println(product3.getName() + " - " + product3.getPrice());
    }
}
