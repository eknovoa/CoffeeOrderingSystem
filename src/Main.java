import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    //main program
    public static void welcomeGreeting() {
        System.out.println("Hello! Welcome to Lola's Coffee");
        System.out.println();
        System.out.println("What can I get started for you today?");

    }

    public static void printOptions() {
        System.out.println("(1) I need to see the menu.");
        System.out.println("(2) I know what I want.");
        System.out.println("(3) Sorry, I don't want anything anymore.");
    }

    public static void addingOn(Map<String,Double> menu, RegisterMachine registerMachine) {
        Scanner scanner = new Scanner(System.in);
            registerMachine.printAddOns();
            System.out.println("What would you like?");
            String addOnSelection = scanner.nextLine();
            registerMachine.addItem(addOnSelection, menu);
            System.out.println("Is that all?  Yes or No");
            String continuedResponse = scanner.nextLine();
            while (continuedResponse.equalsIgnoreCase("no")) {
                System.out.println("What else can I get for you?");
                String newItem = scanner.nextLine();
                registerMachine.addItem(newItem, menu);
                System.out.println("Is that all?  Yes or No");
                continuedResponse = scanner.nextLine();
            }
    }


    public static void main(String[] args){
        RegisterMachine registerMachine = new RegisterMachine();
        Map<String, Double> menu = new HashMap<>();
        menu = registerMachine.initializeMenu(menu);
        Scanner scanner = new Scanner(System.in);
        welcomeGreeting();
        printOptions();
        String choice = scanner.nextLine();
        if (choice.equals("1")) {
            System.out.println("Here is the menu.");
            registerMachine.printMenu();
            System.out.println("Type \'OK\' when you are ready to order or type \'exit\'.");
            String customerSelection = scanner.nextLine();
            if (customerSelection.equalsIgnoreCase("OK")) {
                System.out.println("What can I get for you? Just type in the name of your drink.");
                String orderSelection = scanner.nextLine();
                registerMachine.addItem(orderSelection, menu);
                System.out.println("Would you like to make any substitutions or add-ons?");
                String addOnResponse = scanner.nextLine();
                if (addOnResponse.equalsIgnoreCase("Yes")){
                    addingOn(menu, registerMachine);
                }
                System.out.println("Will this complete your order?  Yes, No, Help");
                String doneSelection = scanner.nextLine();
                while (doneSelection.equalsIgnoreCase("no")) {
                    System.out.println("What else can I get for you?");
                    String order = scanner.nextLine();
                    registerMachine.addItem(order, menu);
                    System.out.println("Would you like to make any substitutions or add-ons?");
                    addOnResponse = scanner.nextLine();
                    if (addOnResponse.equalsIgnoreCase("Yes")){
                        addingOn(menu, registerMachine);
                    }
                    System.out.println("Will this complete your order?  Yes, No, Help");
                    doneSelection = scanner.nextLine();
                }
                if (doneSelection.equalsIgnoreCase("Help")) {
                    System.out.println("(1) I would like to remove an item from my order.");
                    System.out.println("(2) I would like to cancel my entire order.");
                    String helpSelection = scanner.nextLine();
                    if (helpSelection.equals("1")) {
                        System.out.println("Okay what item would you like to remove? Type in same name from menu.");
                        String remove = scanner.nextLine();
                        registerMachine.removeItem(remove, menu);
                        System.out.println("Would you like to remove another item?");
                        String removeAgain = scanner.nextLine();
                        while(removeAgain.equalsIgnoreCase("Yes")) {
                            System.out.println("Okay what item would you like to remove? Type in same name from menu.");
                            remove = scanner.nextLine();
                            registerMachine.removeItem(remove, menu);
                            System.out.println("Would you like to remove another item?");
                            removeAgain = scanner.nextLine();
                        }
                    }
                    else if (helpSelection.equals("2")) {
                        registerMachine.cancelOrder();
                        System.out.println("Your order has been canceled.");
                        System.out.println("Thanks for coming to Lola's Coffee!");
                        System.exit(5);
                    }
                }
                System.out.println();
                registerMachine.printTotal();
                System.out.println("Thanks for coming to Lola's Coffee!");
            }
            else if (customerSelection.equalsIgnoreCase("exit")) {
                System.out.println("Thanks for coming to Lola's Coffee!");
            }
        }
        else if (choice.equals("2")){
                System.out.println("What can I get for you? Just type in the name of your drink.");
                String orderSelection = scanner.nextLine();
                int count = 0;
                    String sorryMessage = "Sorry we do not currently serve that drink. Is there something else I can get you?";
                    while (!menu.containsKey(orderSelection)) {
                        if (count < 3) {
                            System.out.println(sorryMessage);
                            orderSelection = scanner.nextLine();
                        }
                        if (count == 3) {
                            sorryMessage = "Would you like to see the menu?";
                            System.out.println(sorryMessage);
                            String seeMenu = scanner.nextLine();
                            if (seeMenu.equalsIgnoreCase("Yes")) {
                                registerMachine.printMenu();
                                System.out.println("What would you like?");
                            }
                            System.out.println("Okay no problem! Please let me know what I can get you.");
                            orderSelection = scanner.nextLine();
                        }
                        if (count >= 4) {
                            sorryMessage = "I'm sorry I am afraid we don't have what you are looking for.";
                            System.out.println(sorryMessage);
                            System.out.println("Thanks for coming to Lola's Coffee!");
                            System.exit(2);
                        }
                        count++;
                    }
                registerMachine.addItem(orderSelection, menu);
                System.out.println("Would you like to make any substitutions or add-ons?");
                String addOnResponse = scanner.nextLine();
                if (addOnResponse.equalsIgnoreCase("Yes")){
                    addingOn(menu, registerMachine);
                }
                System.out.println("Will this complete your order?  Yes, No, Help");
                String doneSelection = scanner.nextLine();
                while (doneSelection.equalsIgnoreCase("no")) {
                    System.out.println("What else can I get for you?");
                    String order = scanner.nextLine();
                    registerMachine.addItem(order, menu);
                    System.out.println("Would you like to make any substitutions or add-ons?");
                    addOnResponse = scanner.nextLine();
                    if (addOnResponse.equalsIgnoreCase("Yes")){
                        addingOn(menu, registerMachine);
                    }
                    System.out.println("Will this complete your order?  Yes, No, Help");
                    doneSelection = scanner.nextLine();
                }
            if (doneSelection.equalsIgnoreCase("Help")) {
                System.out.println("(1) I would like to remove an item from my order.");
                System.out.println("(2) I would like to cancel my entire order.");
                String helpSelection = scanner.nextLine();
                if (helpSelection.equals("1")) {
                    System.out.println("Okay what item would you like to remove? Type in same name from menu.");
                    String remove = scanner.nextLine();
                    registerMachine.removeItem(remove, menu);
                    System.out.println("Would you like to remove another item?");
                    String removeAgain = scanner.nextLine();
                    while(removeAgain.equalsIgnoreCase("Yes")) {
                        System.out.println("Okay what item would you like to remove? Type in same name from menu.");
                        remove = scanner.nextLine();
                        registerMachine.removeItem(remove, menu);
                        System.out.println("Would you like to remove another item?");
                        removeAgain = scanner.nextLine();
                    }
                }
                else if (helpSelection.equals("2")) {
                    registerMachine.cancelOrder();
                    System.out.println("Your order has been canceled.");
                    System.out.println("Thanks for coming to Lola's Coffee!");
                    System.exit(5);
                }
            }
            System.out.println();
                registerMachine.printTotal();
                System.out.println("Thanks for coming to Lola's Coffee!");
        }
        else if (choice.equals("3")) {
            System.out.println("Thanks for coming to Lola's Coffee!");
        }
        else {
            System.out.println("Please make a valid choice: 1-3");
            printOptions();
        }

    }
}
