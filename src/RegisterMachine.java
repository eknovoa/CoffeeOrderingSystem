import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;

public class RegisterMachine {

    double amount = 0.0;

    //Constructor
    public RegisterMachine() {}

    public static Map<String, Double> initializeMenu(Map<String, Double> menu) {
        menu.put("drip brew", 1.25);
        menu.put("americano", 1.50);
        menu.put("cortado", 2.00);
        menu.put("cold brew", 2.75);
        menu.put("kyoto cold brew", 2.50);
        menu.put("nitro cold brew", 3.25);
        menu.put("chai tea latte", 3.50);
        menu.put("oat milk", 0.50);
        menu.put("almond milk", 0.50);
        menu.put("soy milk", 0.50);
        menu.put("extra shot", 0.75);

        return menu;
    }

    public void printMenu() {
        System.out.println();
        System.out.println(
                "Drip Brew\t\t\t$1.25\nAmericano\t\t\t$1.50\nCortado\t\t\t\t$2.00\nCold Brew\t\t\t$2.75\nKyoto Cold Brew\t\t$2.50\nNitro Cold Brew\t\t$3.25\nChai Tea Latte\t\t$3.50\n"
        );
    }

    public void printAddOns() {
        System.out.println("Extras:\nOat Milk\t\t\t$0.50\nAlmond Milk\t\t\t$0.50\nSoy Milk\t\t\t$0.50\nExtra Shot\t\t\t$0.75\n");
    }

    public void addItem (String item, Map<String, Double> menu) {
        if (menu.containsKey(item)) {
            amount += menu.get(item);
        }
        else {
            System.out.println("Type in order again.");
        }
    }

    public void removeItem (String item, Map<String, Double> menu) {
        Double value = menu.get(item);
        amount -= value;
    }

    public void cancelOrder() {
        amount = 0;
    }

    public double calculateTotal() {
        amount += amount * 0.0825;
        return amount ;
    }

    public void applyDiscount() {}

    public void printTotal() {
        DecimalFormat df = new DecimalFormat("###.##");
        System.out.println("Total Amount: $" + df.format(calculateTotal()));
    }
}


//TODO I want to be able to change my file of inventory so that if I run out of items and someone asks for it I can say I am so sorry I am out
//or I only have one left?
//be able to generate a recommendation if a customer orders something we are out of but need to make sure we have at least 1 left before recommending.
