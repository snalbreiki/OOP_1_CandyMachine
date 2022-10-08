public class Dispenser {
    private int numberOfItems;
    private int cost;
    //method to get number of items in dispenser
    public int getCount(){
        return numberOfItems;
    }
    //method to get product cost
    public int getProductCost(){
        return cost;
    }
    //method to set number of items to specific amount
    public void setNumberOfItems(int setItems){
        numberOfItems += setItems;
    }
    //method to set cost of product to specific amount
    public void setProductCost(int setCost){
        cost += setCost;
    }
    //method to deduct one item per sale
    public void makeSale(){
        numberOfItems--;
    }
}
