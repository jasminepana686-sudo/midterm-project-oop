import java.util.*;

public class Main{
    private static final Scanner sc = new Scanner(System.in);

    private static void printDivider() {
        System.out.println("-".repeat(44));
    }
    
    public static void main(String[] args){
        InventoryManagementSystem system = new InventoryManagementSystem();

        printDivider();
        System.out.println("Welcome to the Inventory Management System");
        printDivider();

        boolean running = true;

        while(running) {
            printMenu();
            int choice = readMenu();
            printDivider();
            
            switch(choice){
                case 1:
                    system.addItem();
                    break;
                case 2:
                    system.updateItem();
                    break;
                case 3:
                    system.removeItem();
                    break;
                case 4:
                    system.displayByCategory();
                    break;
                case 5:
                    system.displayAll();
                    break;
                case 6:
                    system.searchItem();
                    break;
                case 7:
                    system.sortItems();
                    break;
                case 8:
                    system.displayLowStock();
                    break;
                case 9:
                    System.out.println();
                    printDivider();
                    System.out.println("Exiting the system. Goodbye!");
                    printDivider();
                    running = false;
                    break;
            }
        }
    }

    public static void printMenu() {
        System.out.println();
        printDivider();
        System.out.println("Menu");
        printDivider();
        System.out.println("1) Add Item");
        System.out.println("2) Update Item");
        System.out.println("3) Remove Item");
        System.out.println("4) Display Items by Category");
        System.out.println("5) Display All Items");
        System.out.println("6) Search Items");
        System.out.println("7) Sort Items");
        System.out.println("8) Display Low Stock Items");
        System.out.println("9) Exit");
        printDivider();
    }

    public static int readMenu() {
        int choice = -1;
        boolean valid = false;

        while (!valid) {
            System.out.print("Enter the number of your choice: ");
            String input = sc.nextLine().trim();
            try {
                choice = Integer.parseInt(input);
                if (input.matches("0\\d+")) {
                    System.out.println("Input cannot have leading zeros.");
                } else if (choice >= 1 && choice <= 9) {
                    valid = true;
                } else {
                    printDivider();
                    System.out.println("Invalid input! Please enter a number between 1 and 9.");
                    printDivider();
                }
            } catch (NumberFormatException e) {
                printDivider();
                System.out.println("Invalid input! Please enter a number between 1 and 9.");
                printDivider();
            }
        }
        return choice;
    }
}