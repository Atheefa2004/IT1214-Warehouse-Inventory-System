import java.util.Scanner;
import java.util.ArrayList;

public class Warehouse {
    public static void main(String[] args) {
        Inventory inventory = new Inventory();
        Scanner sc = new Scanner(System.in);
        int choice = 0;

        while (true) {
            System.out.println("\n===== Warehouse Menu =====");
            System.out.println("1. Add Item");
            System.out.println("2. Remove Item");
            System.out.println("3. Update Quantity");
            System.out.println("4. Search Item by ID");
            System.out.println("5. Search Item by Name");
            System.out.println("6. Display All Items");
            System.out.println("7. Exit");
            System.out.print("Enter choice: ");
            
            choice = sc.nextInt();
            sc.nextLine(); 

            if (choice == 1) {
               
                System.out.print("Enter Item ID: ");
                String id = sc.nextLine();
                System.out.print("Enter Item Name: ");
                String name = sc.nextLine();
                System.out.print("Enter Quantity: ");
                int qty = sc.nextInt();
                System.out.print("Enter Price:Rs. ");
                double price = sc.nextDouble();
                
                Item item = new Item(id, name, qty, price);
                inventory.addItem(item);

            } else if (choice == 2) {
                
                System.out.print("Enter Item ID to remove: ");
                String id = sc.nextLine();
                inventory.removeItem(id);

            } else if (choice == 3) {
                
                System.out.print("Enter Item ID: ");
                String id = sc.nextLine();
                System.out.print("Enter New Quantity: ");
                int newQty = sc.nextInt();
                inventory.updateQuantity(id, newQty);

            } else if (choice == 4) {
             
                System.out.print("Enter Item ID to search: ");
                String id = sc.nextLine();
                Item found = inventory.searchById(id);
                if (found != null) {
                    System.out.println("Found: " + found);
                } else {
                    System.out.println("Item not found!");
                }

            } else if (choice == 5) {
              
                System.out.print("Enter Item Name to search: ");
                String name = sc.nextLine();
                ArrayList<Item> results = inventory.searchByName(name);
                if (results.isEmpty()) {
                    System.out.println("No items found!");
                } else {
                    System.out.println("Found items: ");
                    for (Item item : results) {
                        System.out.println(item);
                    }
                }

            } else if (choice == 6) {
               
                inventory.displayAll();

            } else if (choice == 7) {
                System.out.println("Goodbye!");
                break;

            } else {
                System.out.println("Invalid choice!");
            }
        }
        
       
    }
}