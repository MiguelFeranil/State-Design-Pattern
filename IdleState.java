public class IdleState implements VendingMachineState {
    private VendingMachine machine;
    
    public IdleState(VendingMachine machine) {
        this.machine = machine;
    }
    
    @Override
    public void selectItem() {
        if (machine.hasItem()) {
            System.out.println("Item selected. Please insert coins.");
            machine.setState(new ItemSelectedState(machine));
        } else {
            System.out.println("Out of stock. Please try another item or come back later.");
        }
    }
    
    @Override
    public void insertCoin(double amount) {
        System.out.println("Please select an item first.");
    }
    
    @Override
    public void dispenseItem() {
        System.out.println("No item selected. Please select an item first.");
    }
    
    @Override
    public void setOutOfOrder() {
        System.out.println("Machine is now out of order.");
        machine.setState(new OutOfOrderState(machine));
    }
}