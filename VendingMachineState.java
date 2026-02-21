public interface VendingMachineState {
    void selectItem();
    void insertCoin(double amount);
    void dispenseItem();
    void setOutOfOrder();
}