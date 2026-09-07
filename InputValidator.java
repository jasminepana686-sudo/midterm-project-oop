import java.util.*;

public class InputValidator {

    public static String readCategory(Scanner sc, String prompt){
        String input = "";
        boolean valid = false;
        while(!valid){
            System.out.print(prompt);
            input = sc.nextLine().trim().toLowerCase();

            if (input.isEmpty()){
                System.out.println("Input cannot be empty. Please try again.");
            } else if (!input.equals("clothing") && !input.equals("electronics") && !input.equals("entertainment")){
                System.out.println("Category '" + input + "' does not exist! Must be Clothing, Electronics, or Entertainment.");
            } else {
                valid = true;
            }
        }
        return input;
    }

    public static String readID(Scanner sc, String prompt){
        String input = "";
        boolean valid = false;
        while(!valid){
            System.out.print(prompt);
            input = sc.nextLine().trim();

            if (input.isEmpty()){
                System.out.println("Input cannot be empty. Please try again.");
            } else if (!input.matches("^[CET]\\d{3}$")){
                System.out.println("Invalid ID format! Must be like C001, E001, or T001.");
            } else {
                valid = true;
            }
        }
        return input;
    }

    public static String readName(Scanner sc, String prompt){
        String input = "";
        boolean valid = false;
        while(!valid){
            System.out.print(prompt);
            input = sc.nextLine().trim();

            if (input.isEmpty()){
                System.out.println("Input cannot be empty. Please try again.");
            } else if (!input.matches("[a-zA-Z0-9 ]+")) {
                System.out.println("Invalid name! Use letters, numbers, and spaces only.");
            } else if (input.length() > 20) {
                System.out.println("Name too long! Max 20 characters.");
            }else {
                valid = true;
            }
        }
        return input;
    }

    public static int readQuantity(Scanner sc, String prompt){
        int quantity = -1;
        boolean valid = false;
        while (!valid) {
            System.out.print(prompt);
            String input = sc.nextLine().trim();

            if (!input.matches("0|[1-9]\\d*")) {
                System.out.println("Invalid Quantity! Use whole numbers only, e.g. 10.");
            } else {
                quantity = Integer.parseInt(input);
                if (quantity >= 0 && quantity <= 10000) {
                    valid = true;
                } else {
                    System.out.println("Invalid Quantity! Must be a number between 0 and 10,000.");
                }
            }
        }
        return quantity;
    }

    public static double readPrice(Scanner sc, String prompt){
        double price = -1;
        boolean valid = false;
        while (!valid) {
            System.out.print(prompt);
            String input = sc.nextLine().trim();

            if (!input.matches("(0|[1-9]\\d*)(\\.\\d+)?")) {
                System.out.println("Invalid Price! Use digits only, e.g. 9.99 or 100.");
            } else {
                price = Double.parseDouble(input);
                if (price > 0 && price <= 1000000) {
                    valid = true;
                } else {
                    System.out.println("Invalid Price! Must be a number between 0 and 1,000,000.");
                }
            }
        }
        return price;
    }

    public static String readFindID(Scanner sc, String prompt){
        String input = "";
        boolean valid = false;

        while (!valid) {
            System.out.print(prompt);
            input = sc.nextLine().trim().toUpperCase();

            if (input.isEmpty()) {
                System.out.println("Input cannot be empty. Please try again.");
            } else {
                valid = true;
            }
        }

        return input;
    }

    public static String readQuantityOrPrice(Scanner sc, String prompt){
        String input = "";
        boolean valid = false;
        while(!valid){
            System.out.print(prompt);
            input = sc.nextLine().trim().toLowerCase();

            if (input.isEmpty()){
                System.out.println("Input cannot be empty. Please try again.");
            } else if (!input.equals("quantity") && !input.equals("price")){
                System.out.println("Invalid input! Must be Quantity or Price only.");
            } else {
                valid = true;
            }
        }
        return input;
    }

    public static String readSortOrder(Scanner sc, String prompt){
        String input = "";
        boolean valid = false;
        while(!valid){
            System.out.print(prompt);
            input = sc.nextLine().trim().toLowerCase();

            if (input.isEmpty()){
                System.out.println("Input cannot be empty. Please try again.");
            } else if (!input.equals("ascending") && !input.equals("descending")){
                System.out.println("Invalid input! Must be Ascending or Descending only.");
            } else {
                valid = true;
            }
        }
        return input;
    }

}