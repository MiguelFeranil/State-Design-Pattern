public class VendingMachine {
    private VendingMachineState state;
    private int inventory;
    private double balance;
    
    public VendingMachine(int initialInventory) {
        this.inventory = initialInventory;
        this.balance = 0.0;
        this.state = new IdleState(this);
    }
    
    public void setState(VendingMachineState state) {
        this.state = state;
    }
    
    public VendingMachineState getState() {
        return state;
    }
    
    public boolean hasItem() {
        return inventory > 0;
    }
    
    public void decreaseInventory() {
        if (inventory > 0) {
            inventory--;
        }
    }
    
    public void increaseBalance(double amount) {
        this.balance += amount;
    }
    
    public double getBalance() {
        return balance;
    }
    
    public void resetBalance() {
        this.balance = 0.0;
    }
    
    public int getInventory() {
        return inventory;
    }
    
    public void refill(int count) {
        inventory += count;
        System.out.println("Machine refilled. Current inventory: " + inventory);
    }
    
    // Delegate methods to current state
    public void selectItem() {
        state.selectItem();
    }
    
    public void insertCoin(double amount) {
        state.insertCoin(amount);
    }
    
    public void dispenseItem() {
        state.dispenseItem();
    }
    
    public void setOutOfOrder() {
        state.setOutOfOrder();
    }
}