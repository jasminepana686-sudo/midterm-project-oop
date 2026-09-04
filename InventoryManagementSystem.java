import java.util.*;

public class InventoryManagementSystem{
    private Scanner sc;
    
    private Inventory inventory;

    public InventoryManagementSystem(){
        sc = new Scanner(System.in);
        inventory = new Inventory();
    }

    private void printDivider() {
        System.out.println("-".repeat(44));
    }

    private void printReturningMenu() {
        System.out.println();
        printDivider();
        System.out.println("Returning to Main Menu...");
        printDivider();
        System.out.println();
    }

    private void printCentered(String text, int width) {
        int padding = (width - text.length()) / 2;
        String spaces = " ".repeat(Math.max(padding, 0));
        System.out.println(spaces + text);
    }

    public void addItem(){
        System.out.println();
        
        printDivider();       
        printCentered("ADD NEW ITEM", 44);
        printDivider();

        System.out.println("Please enter the following details:");
        System.out.println("Choose a category: \n- Clothing \n- Electronics \n- Entertainment");
        String category = InputValidator.readCategory(sc, "Category: ");
        String id = InputValidator.readID(sc, "Item ID [e.g., C001]: ");
        String name = InputValidator.readName(sc, "Item Name: ");
        int quantity = InputValidator.readQuantity(sc, "Quantity: ");
        double price = InputValidator.readPrice(sc, "Price: Php ");
        
        Item newItem;

        switch (category) {
            case "clothing":
                newItem = new Clothing(id, name, quantity, price);
                break;
            case "electronics":
                newItem = new Electronics(id, name, quantity, price);
                break;
            case "entertainment":
                newItem = new Entertainment(id, name, quantity, price);
                break;
            default:
                newItem = null; 
        }

        inventory.addItem(newItem);
        printDivider();
        System.out.println("Item added successfully!");
        printDivider();

        printReturningMenu();
    }

    public void updateItem(){
        System.out.println();
        
        printDivider();       
        printCentered("UPDATE ITEM", 44);
        printDivider();
        
        String id = InputValidator.readFindID(sc, "Item ID: ");
        
        Item foundItem = inventory.findItemById(id);
        
        if (foundItem == null) {
            System.out.println("Item not found!");
            printDivider();
            printReturningMenu();
            return;
        }

        System.out.println("Update Quantity or Price?");
        String toUpdate = InputValidator.readQuantityOrPrice(sc, "Update: ");

        if (toUpdate.equals("quantity")){
            int oldQuantity = foundItem.getQuantity();
            int newQuantity = InputValidator.readQuantity(sc, "Updated Quantity: ");
            foundItem.setQuantity(newQuantity);
            System.out.println("Quantity of " + foundItem.getName() + " is updated from " 
                + oldQuantity + " to " + newQuantity);
        } else{
            double oldPrice = foundItem.getPrice();
            double newPrice = InputValidator.readPrice(sc, "Updated Price: Php");
            foundItem.setPrice(newPrice);
            System.out.println("Price of " + foundItem.getName() + " is updated from " 
                + oldPrice + " to " + newPrice);
        }
        printDivider();

        printReturningMenu();
    }

    public void removeItem(){
        System.out.println();
        
        printDivider();       
        printCentered("REMOVE ITEM", 44);
        printDivider();
        
        String id = InputValidator.readFindID(sc, "Item ID: ");

        boolean removed = inventory.removeItem(id);

        if (removed) {
            System.out.println("Item has been removed from the inventory.");
        } else {
            System.out.println("Item not found!");
        }
        printDivider();

        printReturningMenu();

    }

    public void displayByCategory(){
        System.out.println();
        
        printDivider();       
        printCentered("ITEMS BY CATEGORY", 44);
        printDivider();
        
        String category = InputValidator.readCategory(sc, "Category [Clothing/Electronics/Entertainment]: ");
        
        List<Item> filtered = inventory.getItemsByCategory(category);

        if (filtered.isEmpty()) {
            System.out.println("No items found in this category.");
            printDivider();
            printReturningMenu();
            return;
        }

        System.out.println();
        System.out.println("-".repeat(60));
        System.out.println(filtered.get(0).getCategory() + " Items:");
        System.out.println("=".repeat(60));
        System.out.printf("%-10s %-15s %-10s %-10s%n",
                "ID", "Name", "Quantity", "Price");
        System.out.println("=".repeat(60));
        for (Item item : filtered) {
            System.out.printf("%-10s %-15s %-10d %-10.2f%n",
                item.getId(), item.getName(), item.getQuantity(), item.getPrice());
        }
        System.out.println("-".repeat(60));

        printReturningMenu();
    }

    public void displayAll(){
        System.out.println();
        
        System.out.println("-".repeat(60));       
        printCentered("ALL ITEMS IN INVENTORY", 60);
        
        List<Item> all = inventory.getAllItems();

        if (all.isEmpty()) {
            System.out.println("No items in the inventory.");
            printDivider();
            printReturningMenu();
            return;
        }

        System.out.println("=".repeat(60));
        System.out.printf("%-10s %-15s %-10s %-10s %-15s%n",
                "ID", "Name", "Quantity", "Price", "Category");
        System.out.println("=".repeat(60));
        for (Item item : all) {
            System.out.printf("%-10s %-15s %-10d %-10.2f %-15s%n",
                    item.getId(), item.getName(), item.getQuantity(), item.getPrice(), item.getCategory());
        }
        System.out.println("-".repeat(60));
        
        printReturningMenu();
    }

    public void searchItem(){
        System.out.println();
        
        printDivider();       
        printCentered("SEARCH ITEM", 44);
        printDivider();

        String id = InputValidator.readFindID(sc, "Item ID: ");
        
        Item foundItem = inventory.findItemById(id);
        
        if (foundItem == null) {
            System.out.println("Item not found!");
            return;
        }

        System.out.println();
        printDivider();
        System.out.println("Item Found:");
        printDivider();
        System.out.println("ID       : " + foundItem.getId());
        System.out.println("Name     : " + foundItem.getName());
        System.out.println("Quantity : " + foundItem.getQuantity());
        System.out.println("Price    : " + foundItem.getPrice());
        System.out.println("Category : " + foundItem.getCategory());
        printDivider();
        
        printReturningMenu();
    }

    public void sortItems(){
        System.out.println();
        
        printDivider();       
        printCentered("SORTED ITEMS", 44);
        printDivider();
        
        List<Item> all = inventory.getAllItems();

        if (all.isEmpty()) {
            System.out.println("No items in the inventory.");
            return;
        }

        String sortField = InputValidator.readQuantityOrPrice(sc, "Sort by [Quantity/Price]: ");
        String sortOrder = InputValidator.readSortOrder(sc, "Sort order [Ascending/Descending]: ");

        Comparator<Item> comparator;

        if (sortField.equals("quantity")) {
            comparator = Comparator.comparingInt(Item::getQuantity);
        } else {
            comparator = Comparator.comparingDouble(Item::getPrice);
        }

        if (sortOrder.equals("descending")) {
            comparator = comparator.reversed();
        }

        all.sort(comparator);

        System.out.println();
        System.out.println("-".repeat(60));
        System.out.println("Sorted Items:");
        System.out.println("=".repeat(60));
        System.out.printf("%-10s %-15s %-10s %-10s %-15s%n",
                "ID", "Name", "Quantity", "Price", "Category");
        System.out.println("=".repeat(60));
        for (Item item : all) {
            System.out.printf("%-10s %-15s %-10d %-10.2f %-15s%n",
                    item.getId(), item.getName(), item.getQuantity(), item.getPrice(), item.getCategory());
        }
        System.out.println("-".repeat(60));
        
        printReturningMenu();
    }

    public void displayLowStock(){
        System.out.println();
        
        printDivider();       
        printCentered("LOW STOCK ITEMS", 44);
        printDivider();
        
        List<Item> lowStockItems = inventory.getLowStockItems();
        
        if (lowStockItems.isEmpty()) {
            System.out.println("No items with low stock.");
            return;
        }

        System.out.println();
        System.out.println("-".repeat(70));
        System.out.println("Low Stock Items:");
        System.out.println("=".repeat(70));
        System.out.printf("%-10s %-15s %-10s %-10s %-15s%n",
                "ID", "Name", "Quantity", "Price", "Category");
        System.out.println("=".repeat(70));
        for (Item item : lowStockItems) {
            System.out.printf("%-10s %-15s %-10d %-10.2f %-15s%n",
                    item.getId(), item.getName(), item.getQuantity(), item.getPrice(), item.getCategory());
        }
        System.out.println("-".repeat(70));

        printReturningMenu();
    }
}