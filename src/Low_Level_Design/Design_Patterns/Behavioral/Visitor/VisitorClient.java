package Low_Level_Design.Design_Patterns.Behavioral.Visitor;

//Shopping cart system

//have a collection of objects with different types (e.g., books, electronics, clothes)
// and you want to perform operations on these objects without changing their classes.(pricing, discount calculation, and tax calculation)


//Element Interface

interface ItemElement {
    void accept(ShoppingCartVisitor visitor);
}

//Concrete Elements

class Book implements ItemElement {
    private String isbn;
    private double price;

    public Book(String isbn, double price) {
        this.isbn = isbn;
        this.price = price;
    }

    public String getIsbn() {
        return isbn;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public void accept(ShoppingCartVisitor visitor) {
        visitor.visit(this);
    }
}

class Electronic implements ItemElement {
    private String model;
    private double price;

    public Electronic(String model, double price) {
        this.model = model;
        this.price = price;
    }

    public String getModel() {
        return model;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public void accept(ShoppingCartVisitor visitor) {
        visitor.visit(this);
    }
}

class Clothing implements ItemElement {
    private String brand;
    private double price;

    public Clothing(String brand, double price) {
        this.brand = brand;
        this.price = price;
    }

    public String getBrand() {
        return brand;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public void accept(ShoppingCartVisitor visitor) {
        visitor.visit(this);
    }
}

//Visitor Interface

interface ShoppingCartVisitor {
    void visit(Book book);
    void visit(Electronic electronic);
    void visit(Clothing clothing);
}

//Concrete Visitor

class ShoppingCartPricingVisitor implements ShoppingCartVisitor {
    private double totalPrice = 0;

    public double getTotalPrice() {
        return totalPrice;
    }

    @Override
    public void visit(Book book) {
        totalPrice += book.getPrice();
    }

    @Override
    public void visit(Electronic electronic) {
        totalPrice += electronic.getPrice() * 1.18; // Adding 18% tax
    }

    @Override
    public void visit(Clothing clothing) {
        totalPrice += clothing.getPrice() * 1.05; // Adding 5% tax
    }
}

class DiscountVisitor implements ShoppingCartVisitor {
    private double totalDiscount = 0;

    public double getTotalDiscount() {
        return totalDiscount;
    }

    @Override
    public void visit(Book book) {
        totalDiscount += book.getPrice() * 0.10; // 10% discount on books
    }

    @Override
    public void visit(Electronic electronic) {
        totalDiscount += electronic.getPrice() * 0.20; // 20% discount on electronics
    }

    @Override
    public void visit(Clothing clothing) {
        totalDiscount += clothing.getPrice() * 0.15; // 15% discount on clothing
    }
}


public class VisitorClient {

    public static void main(String[] args) {
        ItemElement[] items = new ItemElement[]{
                new Book("12345", 20.0),
                new Electronic("Smartphone", 200.0),
                new Clothing("T-Shirt", 30.0)
        };

        // Calculate total price
        ShoppingCartVisitor pricingVisitor = new ShoppingCartPricingVisitor();
        for (ItemElement item : items) {
            item.accept(pricingVisitor);
        }
        System.out.println("Total Price = " + ((ShoppingCartPricingVisitor) pricingVisitor).getTotalPrice());

        // Calculate total discount
        ShoppingCartVisitor discountVisitor = new DiscountVisitor();
        for (ItemElement item : items) {
            item.accept(discountVisitor);
        }
        System.out.println("Total Discount = " + ((DiscountVisitor) discountVisitor).getTotalDiscount());
    }
}
