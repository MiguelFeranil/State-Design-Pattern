public class VendingMachineDemo {
    public static void main(String[] args) {
        System.out.println("=== Vending Machine State Pattern Demo ===\n");
        
        VendingMachine machine = new VendingMachine(3);

        System.out.println("--- Scenario 1: Normal Operation ---");
        machine.selectItem();
        machine.insertCoin(1.00);
        machine.insertCoin(0.50);
        machine.dispenseItem();
        
        System.out.println("\n--- Scenario 2: Insufficient Funds ---");
        machine.selectItem();
        machine.insertCoin(1.00);
        machine.dispenseItem(); 
        machine.insertCoin(0.50); 
        machine.dispenseItem(); 
        
        System.out.println("\n--- Scenario 3: Out of Order ---");
        machine.setOutOfOrder();
        machine.selectItem(); 
        machine.insertCoin(1.00); 
        
        if (machine.getState() instanceof OutOfOrderState) {
            ((OutOfOrderState) machine.getState()).repair();
        }
        
        System.out.println("\n--- Scenario 4: Refill and Continue ---");
        machine.refill(2);
        machine.selectItem();
        machine.insertCoin(2.00);
        machine.dispenseItem();
        
        System.out.println("\n--- Scenario 5: Invalid Operations ---");
        machine.insertCoin(1.00);
        machine.dispenseItem();
        machine.selectItem();
        machine.selectItem(); 
    }
}