package Low_Level_Design.Design_Patterns.Structural.Facade;

// Subsystem: Inventory Management
class InventoryManagement {
    public void checkStockAvailability(String productId) {
        // Check stock availability logic
        System.out.println("Checking stock availability for product: " + productId);
    }
}

// Subsystem: Order Processing
class OrderProcessing {
    public void createOrder(String productId, int quantity) {
        // Create order logic
        System.out.println("Creating order for product: " + productId + ", Quantity: " + quantity);
    }
}

// Subsystem: Payment Processing
class PaymentProcessing {
    public void processPayment(String orderId, double amount) {
        // Process payment logic
        System.out.println("Processing payment for order: " + orderId + ", Amount: $" + amount);
    }
}

// Facade
class ECommerceFacade {
    private InventoryManagement inventoryManagement;
    private OrderProcessing orderProcessing;
    private PaymentProcessing paymentProcessing;

    public ECommerceFacade() {
        this.inventoryManagement = new InventoryManagement();
        this.orderProcessing = new OrderProcessing();
        this.paymentProcessing = new PaymentProcessing();
    }

    public void purchaseProduct(String productId, int quantity) {
        // Check stock availability
        inventoryManagement.checkStockAvailability(productId);

        // Create order
        orderProcessing.createOrder(productId, quantity);

        // Process payment
        paymentProcessing.processPayment("order123", calculateTotalAmount(productId, quantity));
    }

    private double calculateTotalAmount(String productId, int quantity) {
        // Logic to calculate total amount based on product price and quantity
        double price = 10.99; // Example product price
        return price * quantity;
    }
}


public class FacadeClient {

    public static void main(String[] args) {
        // Client interacts with the facade to purchase a product
        ECommerceFacade ecommerceFacade = new ECommerceFacade();
        ecommerceFacade.purchaseProduct("product123", 2);
    }
}
