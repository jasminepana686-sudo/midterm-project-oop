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
                System.out.println("Invalid category! Must be clothing, electronics, or entertainment.");
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
            } else {
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
            try {
                quantity = Integer.parseInt(input);
                if (input.matches("0\\d+")) {
                    System.out.println("Input cannot have leading zeros.");
                } else if (quantity > 0) {
                    valid = true;
                } else {
                    System.out.println("Invalid Quantity!");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid Quantity!");
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
            try {
                price = Double.parseDouble(input);
                if (input.matches("0\\d+")) {
                    System.out.println("Input cannot have leading zeros.");
                } else if (price > 0) {
                    valid = true;
                } else {
                    System.out.println("Invalid Price! Must be greater than 0.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid Price! Please enter a valid number.");
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