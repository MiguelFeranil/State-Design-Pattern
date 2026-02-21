public class DispensingState implements VendingMachineState {
    private VendingMachine machine;
    
    public DispensingState(VendingMachine machine) {
        this.machine = machine;
        dispenseItem();
    }
    
    @Override
    public void selectItem() {
        System.out.println("Currently dispensing. Please wait...");
    }
    
    @Override
    public void insertCoin(double amount) {
        System.out.println("Currently dispensing. Cannot accept coins.");
    }
    
    @Override
    public void dispenseItem() {
        if (machine.hasItem()) {
            System.out.println("Dispensing item...");
            machine.decreaseInventory();

            try {
                Thread.sleep(2000); 
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            
            System.out.println("Item dispensed successfully!");
            
            machine.setState(new IdleState(machine));
        } else {
            System.out.println("Out of stock!");
            machine.setState(new OutOfOrderState(machine));
        }
    }
    
    @Override
    public void setOutOfOrder() {
        System.out.println("Machine is out of order during dispensing. Please contact support.");
        machine.setState(new OutOfOrderState(machine));
    }
}