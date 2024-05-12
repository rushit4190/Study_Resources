package Low_Level_Design.Design_Patterns.Structural.Decorator;

//Warranty and discount decorators


// The component interface defines operations that can be altered by decorators.

interface Product {
    String getDescription();
    double getPrice();
    double getDiscountRate();
    double getShippingCost(); // New method for shipping cost
    int getWarrantyYears();   // New method for warranty years
    double getGiftWrapperCost(); // New method for gift wrapper cost
}

// Concrete components provide default implementations for the
// operations. There might be several variations of these
// classes in a program.

class BasicProduct implements Product {
    private String description;
    private double price;

    public BasicProduct(String description, double price) {
        this.description = description;
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public double getPrice() {
        return price;
    }

    public double getDiscountRate() {
        return 0; // Default discount rate for products without discount
    }

    public double getShippingCost() {
        return 0; // Default shipping cost for products without additional shipping
    }

    public int getWarrantyYears() {
        return 0; // Default warranty years for products without warranty
    }

    public double getGiftWrapperCost() {
        return 0; // Default gift wrapper cost for products without gift wrapper
    }
}

// The base decorator class follows the same interface as the
// other components. The primary purpose of this class is to
// define the wrapping interface for all concrete decorators.
// The default implementation of the wrapping code might include
// a field for storing a wrapped component and the means to
// initialize it.

abstract class ProductDecorator implements Product {
    private Product product;

    public ProductDecorator(Product product) {
        this.product = product;
    }

    public String getDescription() {
        return product.getDescription();
    }

    // The base decorator simply delegates all work to the
    // wrapped component. Extra behaviors can be added in
    // concrete decorators.

    public double getPrice() {
        return product.getPrice();
    }

    public double getDiscountRate() {
        return product.getDiscountRate();
    }

    public double getShippingCost() {
        return product.getShippingCost();
    }

    public int getWarrantyYears() {
        return product.getWarrantyYears();
    }

    public double getGiftWrapperCost() {
        return product.getGiftWrapperCost();
    }
}



class DiscountDecorator extends ProductDecorator {
    private double discountRate;

    public DiscountDecorator(Product product, double discountRate) {
        super(product);
        this.discountRate = discountRate;
    }

    public String getDescription() {
        return super.getDescription() + " + Discount (" + (discountRate * 100) + "%)";
    }

    // Concrete decorators may call the parent implementation the operation instead of calling the wrapped object
    // directly. This approach simplifies extension of decorator classes.
    // Concrete decorators must call methods on the wrapped object,but may add something of their own to the result. Decorators
    // can execute the added behavior either before or after the call to a wrapped object.

    public double getPrice() {
        return super.getPrice() * (1 - discountRate);
    }

    public double getDiscountRate() {
        return discountRate;
    }
}

// You can wrap objects in several layers of decorators.

class ShippingDecorator extends ProductDecorator {
    private double shippingCost;

    public ShippingDecorator(Product product, double shippingCost) {
        super(product);
        this.shippingCost = shippingCost;
    }

    public String getDescription() {
        return super.getDescription() + " + Shipping";
    }

    public double getPrice() {
        return super.getPrice() + shippingCost;
    }

    public double getShippingCost() {
        return shippingCost;
    }
}

class WarrantyDecorator extends ProductDecorator {
    private int warrantyYears;

    public WarrantyDecorator(Product product, int warrantyYears) {
        super(product);
        this.warrantyYears = warrantyYears;
    }

    public String getDescription() {
        return super.getDescription() + " + Warranty (" + warrantyYears + " years)";
    }

    public double getPrice() {
        return super.getPrice(); // No additional cost for warranty
    }

    public int getWarrantyYears() {
        return warrantyYears;
    }
}

class GiftWrapperDecorator extends ProductDecorator {
    private double wrapperCost;

    public GiftWrapperDecorator(Product product, double wrapperCost) {
        super(product);
        this.wrapperCost = wrapperCost;
    }

    public String getDescription() {
        return super.getDescription() + " + Gift Wrapper";
    }

    public double getPrice() {
        return super.getPrice() + wrapperCost;
    }

    public double getGiftWrapperCost() {
        return wrapperCost;
    }
}


// Usage Example
public class DecoratorClient {

    public static void main(String[] args) {
        // Creating a basic product
        Product basicProduct = new BasicProduct("Laptop", 50000.0);

        // Adding decorators

        Product discountedProduct = new DiscountDecorator(basicProduct, 0.1); // 10% discount
        Product shippingProduct = new ShippingDecorator(discountedProduct, 200.0); // 200 rupee shipping cost
        Product warrantyProduct = new WarrantyDecorator(shippingProduct, 2); // 2-year warranty
        Product giftWrapperProduct = new GiftWrapperDecorator(warrantyProduct, 100.0); // 100 rupee gift wrapper cost

        // basicProduct variable now contains :
        // GiftWrapper > Warrant > Shipping > Discount > Basic Product
        //stacking of new behaviors without changing the Basic Product

        // Checking out
        System.out.println("Description: " + giftWrapperProduct.getDescription());
        System.out.println("Total Price: Rs." + giftWrapperProduct.getPrice());
        System.out.println("Discount Rate: " + (discountedProduct.getDiscountRate() * 100) + "%");
        System.out.println("Shipping Cost: Rs." + shippingProduct.getShippingCost());
        System.out.println("Warranty Years: " + warrantyProduct.getWarrantyYears());
        System.out.println("Gift Wrapper Cost: Rs." + giftWrapperProduct.getGiftWrapperCost());

        //alternative approach with stacking of decorators

        Product basicProduct1 = new GiftWrapperDecorator(new WarrantyDecorator(new BasicProduct("Laptop", 50000), 2), 100.0);
        System.out.println("Description" + basicProduct1.getDescription());

    }
}
