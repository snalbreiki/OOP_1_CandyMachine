import java.util.Scanner;

public class CandyMachine {
    CashRegister cRegister= new CashRegister();
    Dispenser candy= new Dispenser();
    Dispenser chips = new Dispenser();
    Dispenser gum = new Dispenser();
    Dispenser cookies = new Dispenser();

    public CandyMachine() {
        candy.setNumberOfItems(5);
        candy.setProductCost(2);
        chips.setNumberOfItems(10);
        chips.setProductCost(3);
        gum.setNumberOfItems(10);
        gum.setProductCost(1);
        cookies.setNumberOfItems(2);
        cookies.setProductCost(10);
        cRegister.setCashOnHand(0);
    }

    public void showSelection() {
        System.out.println("=-=-= _ . CaNdY mAcHiNe . _ =-=-=");
        System.out.println("Please select an option");
        System.out.println("[0] Add money");
        System.out.println("[1] Candy:   AED" + candy.getProductCost());
        System.out.println("[2] Chips:   AED" + chips.getProductCost());
        System.out.println("[3] Gum:     AED" + gum.getProductCost());
        System.out.println("[4] Cookies: AED" + cookies.getProductCost());
        System.out.println("[9] Exit");
        System.out.println("**Current Balance: (" + cRegister.getCashOnHand() + ")**");
    }

    public void makeSelection() { //The program starts by calling this method
        Scanner cin = new Scanner(System.in);
        showSelection();
        System.out.println("Enter Selection:");
        int choice = cin.nextInt();

        switch (choice) {
            case 0:
                System.out.print("Enter amount: ");
                int addAmount = cin.nextInt();
                cRegister.acceptAmount(addAmount);
                System.out.printf("- Amount [aed %d] added!\n",addAmount);
                break;
            case 1:
                System.out.println("You selected: candy");
                sellProduct(candy, cRegister);
                break;
            case 2:
                sellProduct(chips, cRegister);
                System.out.println("You selected: Chips");
                break;
            case 3:
                System.out.println("You selected: Gum");
                sellProduct(gum, cRegister);
                break;
            case 4:
                System.out.println("You selected: Cookies");
                sellProduct(cookies, cRegister);
                break;
            case 9:
                System.out.println("Exiting program...");
                System.exit(0);
            default:
                System.out.println("- Error.. Please enter valid input");
        }
        makeSelection();

    }

    private void sellProduct(Dispenser product, CashRegister cRegister){
        if (product.getCount() > 0) {
            if (product.getProductCost() < cRegister.getCashOnHand()) {
                cRegister.returnChange(product.getProductCost());
                product.makeSale();
            } else {
                System.out.println("--not enough balance--\n");
            }
        }
        else{
            System.out.println("--product not available--\n");
        }
        makeSelection();
    }
}