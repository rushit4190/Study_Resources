package Low_Level_Design.Design_Patterns.Creational.abstract_factory;

import java.util.Scanner;


// Each distinct product of a product family should have a base
// interface. All variants of the product must implement this
// interface.

interface Account{
    void displayAccountInfo();
}

// Concrete products are created by corresponding concrete
// factories.

class PrimeAccount implements Account{

    @Override
    public void displayAccountInfo() {
        System.out.println("This is a prime account");
    }
}

class NonPrimeAccount implements Account{

    @Override
    public void displayAccountInfo() {
        System.out.println("This is a non-prime account");
    }
}


interface Deals{
    void displayDeals();
}

class PrimeDeals implements Deals{

    @Override
    public void displayDeals() {
        System.out.println("These are prime deals for you");
    }
}

class NonPrimeDeals implements Deals{

    @Override
    public void displayDeals() {
        System.out.println("These are non-prime deals for you");
    }
}


// The abstract factory interface declares a set of methods that
// return different abstract products. These products are called
// a family and are related by a high-level theme or concept.
// Products of one family are usually able to collaborate among
// themselves. A family of products may have several variants,
// but the products of one variant are incompatible with the
// products of another variant.

interface AccountTypeFactory {
    Account createAccount();
    Deals createDeals();
}


// Concrete factories produce a family of products that belong
// to a single variant. The factory guarantees that the
// resulting products are compatible. Signatures of the concrete
// factory's methods return an abstract product, while inside
// the method a concrete product is instantiated.

class PrimeAccountFactory implements AccountTypeFactory {

    @Override
    public Account createAccount() {
        return new PrimeAccount();
    }

    @Override
    public Deals createDeals() {
        return new PrimeDeals();
    }
}

// Each concrete factory has a corresponding product variant.
class NonPrimeAccountFactory implements AccountTypeFactory {

    @Override
    public Account createAccount() {
        return new NonPrimeAccount();
    }

    @Override
    public Deals createDeals() {
        return new NonPrimeDeals();
    }
}

// The client code works with factories and products only
// through abstract types: AccountTypeFactory, Account and Deals. This
// lets you pass any factory or product subclass to the client
// code without breaking it.

class AbstractFactoryWorker {
    private AccountTypeFactory factory;
    private Account account;
    private Deals deals;

    AbstractFactoryWorker(AccountTypeFactory accountTypeFactory) {
        this.factory = accountTypeFactory;
        this.account = factory.createAccount(); // Move initialization to constructor
        this.deals = factory.createDeals(); // Move initialization to constructor
    }

    public void displayAccountInfo() {
        account.displayAccountInfo();
    }

    public void displayDeals() {
        deals.displayDeals();
    }
}

// The application picks the factory type depending on the
// client requirement and creates it
// at runtime (usually at the initialization stage).

public class AbstractFactoryClient{

    public static void main(String[] args) throws Exception {

        System.out.println("What type of account do you want? \n 1. Prime \n 2. Non-Prime");

        Scanner s = new Scanner(System.in);
        int typeOfAccount = s.nextInt();

        AccountTypeFactory accountTypeFactory; //abstract factory

        switch (typeOfAccount) {

            case 1:
                accountTypeFactory = new PrimeAccountFactory();
                break;

            case 2:
                accountTypeFactory = new NonPrimeAccountFactory();
                break;

            default:
                throw new Exception("Invalid input, choose from the above options");
        }

        s.close();

        AbstractFactoryWorker factoryWorker = new AbstractFactoryWorker(accountTypeFactory);

        factoryWorker.displayAccountInfo(); // Display account info
        factoryWorker.displayDeals(); // Display deals
    }
}