import java.util.ArrayList;

public class Player {
    private CarLocation currentCar;
    private ArrayList<Item> inventory;


    public Player(CarLocation startingCar) {
        this.currentCar = startingCar;
        this.inventory = new ArrayList<>();
    }

    public void move(String direction) {
        CarLocation nextCar = currentCar.getExit(direction);
        if (nextCar != null) {
            if (nextCar.canEnter(this)) {
                currentCar = nextCar;
                System.out.println("You move " + direction + ".");
                System.out.println(currentCar.getDescription());
                System.out.println("Exits: " + currentCar.getAvailableExits());
                currentCar.listItems(); // Show items in new room
            } else {
                System.out.println("The way is blocked. You need a " + nextCar.requiredItemName + " to proceed.");
            }
        } else {
            System.out.println("You can't go that way!");
        }
    }
    

    public void look() {
        System.out.println(currentCar.getDescription());
        System.out.println("Exits: " + currentCar.getAvailableExits());
    }

    public void takeItem(String itemName) {
        if (currentCar.hasItem(itemName)) {
            Item item = currentCar.takeItem(itemName);
            inventory.add(item);
            System.out.println("You picked up: " + item.getName());
        } else {
            System.out.println("No such item here.");
        }
    }
    
    public void showInventory() {
        if (inventory.isEmpty()) {
            System.out.println("Your inventory is empty.");
        } else {
            System.out.println("You are carrying:");
            for (Item item : inventory) {
                System.out.println("- " + item.getName());
            }
        }
    }
    
    public boolean hasItem(String itemName) {
        for (Item item : inventory) {
            if (item.getName().equalsIgnoreCase(itemName)) {
                return true;
            }
        }
        return false;
    }
    
}
