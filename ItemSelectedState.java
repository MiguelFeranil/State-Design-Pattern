public class ItemSelectedState implements VendingMachineState {
    private VendingMachine machine;
    private static final double ITEM_PRICE = 1.50; // Fixed price for simplicity
    
    public ItemSelectedState(VendingMachine machine) {
        this.machine = machine;
    }
    
    @Override
    public void selectItem() {
        System.out.println("Item already selected. Please insert coins or dispense.");
    }
    
    @Override
    public void insertCoin(double amount) {
        if (amount > 0) {
            machine.increaseBalance(amount);
            System.out.println("Inserted: $" + amount + ", Total: $" + machine.getBalance());
            
            if (machine.getBalance() >= ITEM_PRICE) {
                System.out.println("Sufficient funds. You can now dispense the item.");
            } else {
                System.out.println("Insufficient funds. Please insert $" + 
                    (ITEM_PRICE - machine.getBalance()) + " more.");
            }
        } else {
            System.out.println("Invalid coin amount.");
        }
    }
    
    @Override
    public void dispenseItem() {
        if (machine.getBalance() >= ITEM_PRICE) {
            if (machine.hasItem()) {
                System.out.println("Dispensing item...");
                machine.decreaseInventory();
                double change = machine.getBalance() - ITEM_PRICE;
                machine.resetBalance();
                
                if (change > 0) {
                    System.out.println("Please collect your change: $" + change);
                }
                
                System.out.println("Thank you for your purchase!");
                machine.setState(new IdleState(machine));
            } else {
                System.out.println("Sorry, item is out of stock.");
                System.out.println("Please collect your refund: $" + machine.getBalance());
                machine.resetBalance();
                machine.setState(new IdleState(machine));
            }
        } else {
            System.out.println("Insufficient funds. Please insert $" + 
                (ITEM_PRICE - machine.getBalance()) + " more.");
        }
    }
    
    @Override
    public void setOutOfOrder() {
        System.out.println("Machine is now out of order.");
        if (machine.getBalance() > 0) {
            System.out.println("Please collect your refund: $" + machine.getBalance());
            machine.resetBalance();
        }
        machine.setState(new OutOfOrderState(machine));
    }
}