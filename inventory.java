import java.util.ArrayList;

public class Inventory {
    private ArrayList<Item> items = new ArrayList<>();

   
    public void addItem(Item item) {
        items.add(item);
        System.out.println("Item added!");
    }

   
    public void removeItem(String itemId) {
        boolean found = false;
        for (int i = 0; i < items.size(); i++) {
            if (items.get(i).getItemId().equals(itemId)) {
                items.remove(i);
                System.out.println("Item removed!");
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Item not found!");
        }
    }

  
    public void updateQuantity(String itemId, int newQuantity) {
        boolean found = false;
        for (Item item : items) {
            if (item.getItemId().equals(itemId)) {
                item.setQuantity(newQuantity);
                System.out.println("Quantity updated!");
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Item not found!");
        }
    }

  
    public Item searchById(String itemId) {
        for (Item item : items) {
            if (item.getItemId().equals(itemId)) {
                return item;
            }
        }
        return null;
    }


    public ArrayList<Item> searchByName(String itemName) {
        ArrayList<Item> result = new ArrayList<>();
        for (Item item : items) {
            if (item.getItemName().equalsIgnoreCase(itemName)) {
                result.add(item);
            }
        }
        return result;
    }

    
    public void displayAll() {
        if (items.isEmpty()) {
            System.out.println("Inventory is empty!");
        } else {
            System.out.println("\n--- All Items ---");
            for (Item item : items) {
                System.out.println(item);
            }
        }
    }
}