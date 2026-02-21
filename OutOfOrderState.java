public class OutOfOrderState implements VendingMachineState {
    private VendingMachine machine;
    
    public OutOfOrderState(VendingMachine machine) {
        this.machine = machine;
    }
    
    @Override
    public void selectItem() {
        System.out.println("Machine is out of order. Cannot select items.");
    }
    
    @Override
    public void insertCoin(double amount) {
        System.out.println("Machine is out of order. Cannot accept coins.");
    }
    
    @Override
    public void dispenseItem() {
        System.out.println("Machine is out of order. Cannot dispense items.");
    }
    
    @Override
    public void setOutOfOrder() {
        System.out.println("Machine is already out of order.");
    }

    public void repair() {
        System.out.println("Machine has been repaired. Returning to idle state.");
        machine.setState(new IdleState(machine));
    }
}