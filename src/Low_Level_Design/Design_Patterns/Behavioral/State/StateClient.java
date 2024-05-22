package Low_Level_Design.Design_Patterns.Behavioral.State;

//Vending Machine example


//Concrete Context

class VendingMachine {
    private VendingMachineState currentState;

    public VendingMachine() {
        currentState = new NoCoinState(this);
    }

    public void setCurrentState(VendingMachineState state) {
        this.currentState = state;
    }

    public void insertCoin() {
        currentState.insertCoin();
    }

    public void ejectCoin() {
        currentState.ejectCoin();
    }

    public void selectProduct() {
        currentState.selectProduct();
    }

    public void dispenseProduct() {
        currentState.dispenseProduct();
    }
}

//State Interface

abstract class VendingMachineState {
    protected VendingMachine vendingMachine;

    public VendingMachineState(VendingMachine vendingMachine) {
        this.vendingMachine = vendingMachine;
    }

    public abstract void insertCoin();
    public abstract void ejectCoin();
    public abstract void selectProduct();
    public abstract void dispenseProduct();
}

//Concrete States

class NoCoinState extends VendingMachineState {

    public NoCoinState(VendingMachine vendingMachine) {
        super(vendingMachine);
    }

    @Override
    public void insertCoin() {
        System.out.println("Coin inserted.");
        vendingMachine.setCurrentState(new HasCoinState(vendingMachine));
    }

    @Override
    public void ejectCoin() {
        System.out.println("No coin to eject.");
    }

    @Override
    public void selectProduct() {
        System.out.println("Insert coin first.");
    }

    @Override
    public void dispenseProduct() {
        System.out.println("Insert coin and select product first.");
    }
}


class HasCoinState extends VendingMachineState {
    public HasCoinState(VendingMachine vendingMachine) {
        super(vendingMachine);
    }

    @Override
    public void insertCoin() {
        System.out.println("Coin already inserted.");
    }

    @Override
    public void ejectCoin() {
        System.out.println("Coin ejected.");
        vendingMachine.setCurrentState(new NoCoinState(vendingMachine));
    }

    @Override
    public void selectProduct() {
        System.out.println("Product selected.");
        vendingMachine.setCurrentState(new SoldState(vendingMachine));
    }

    @Override
    public void dispenseProduct() {
        System.out.println("Please select a product.");
    }
}

class SoldState extends VendingMachineState {
    public SoldState(VendingMachine vendingMachine) {
        super(vendingMachine);
    }

    @Override
    public void insertCoin() {
        System.out.println("Please wait, dispensing product.");
    }

    @Override
    public void ejectCoin() {
        System.out.println("Sorry, you already selected a product.");
    }

    @Override
    public void selectProduct() {
        System.out.println("Product already selected.");
    }

    @Override
    public void dispenseProduct() {
        System.out.println("Product dispensed. Enjoy!");
        vendingMachine.setCurrentState(new NoCoinState(vendingMachine));
    }
}

class SoldOutState extends VendingMachineState {
    public SoldOutState(VendingMachine vendingMachine) {
        super(vendingMachine);
    }

    @Override
    public void insertCoin() {
        System.out.println("Machine is sold out. Cannot insert coin.");
    }

    @Override
    public void ejectCoin() {
        System.out.println("Machine is sold out. Cannot eject coin.");
    }

    @Override
    public void selectProduct() {
        System.out.println("Machine is sold out. Cannot select product.");
    }

    @Override
    public void dispenseProduct() {
        System.out.println("Machine is sold out. Cannot dispense product.");
    }
}



public class StateClient {
    public static void main(String[] args) {
        VendingMachine vendingMachine = new VendingMachine();

        vendingMachine.insertCoin();
        vendingMachine.selectProduct();
        vendingMachine.dispenseProduct();

        vendingMachine.insertCoin();
        vendingMachine.ejectCoin();
        vendingMachine.selectProduct();
        vendingMachine.insertCoin();
        vendingMachine.selectProduct();
        vendingMachine.dispenseProduct();
    }
}
