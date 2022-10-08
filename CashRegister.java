public class CashRegister {
    private  int cashOnHand; //Storing cash on register
    //method to get the cash in the register
    public int getCashOnHand(){
        return cashOnHand;
    }
    //method to set the cash in the register to amount in
    public void setCashOnHand(int cashIn){
        cashOnHand = cashIn;
    }
    //Method to receives the amount deposited by the customer and updates the amount in the register
    public void acceptAmount(int amountIn){
        cashOnHand += amountIn;
    }
    //Method to deduct the amount deposited by the customer and updates the amount in the register
    public void returnChange(int amountCost){
        //CashRegister a = new CashRegister();
        cashOnHand -= amountCost;
    }
}