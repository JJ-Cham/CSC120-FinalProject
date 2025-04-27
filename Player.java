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
                currentCar.listItems();
    
                if (currentCar.isExit()) {
                    System.out.println("You force open the final door and escape onto the empty platform...");
                    System.out.println("You're free. But you'll never forget the sound of those flickering lights.");
                    System.exit(0);
                }
            } else {
                System.out.println("The way is blocked. You need a " + nextCar.getRequiredItemName() + " to proceed.");
            }
        } else {
            System.out.println("You can't go that way!");
        }
    }
    
    

    public void look() {
        System.out.println(currentCar.getDescription());
        System.out.println("Exits: " + currentCar.getAvailableExits());
        currentCar.listItems();
        randomEvent();
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

    private void randomEvent() {
        double chance = Math.random(); // Random number between 0.0 and 1.0
        if (chance < 0.2) { // 20% chance total
            int event = (int) (Math.random() * 5); // 5 total events (3 spooky + 2 good)
    
            switch (event) {
                case 0:
                    System.out.println("You hear skittering in the dark...");
                    break;
                case 1:
                    System.out.println("The lights flicker... and for a second, everything goes black.");
                    break;
                case 2:
                    System.out.println("A distant metallic thud echoes through the train.");
                    break;
                case 3:
                    System.out.println("You find a half-full bottle of water tucked under a seat.");
                    Game.addTime(15000); // +15 seconds (good reward)
                    System.out.println("You feel a little more refreshed. (+15 seconds!)");
                    break;
                case 4:
                    System.out.println("You find a working flashlight discarded on a seat.");
                    Game.addTime(30000); // +30 seconds (big reward)
                    System.out.println("The path ahead seems a little easier to navigate. (+30 seconds!)");
                    break;
            }
        }
    }
    
    
    
}
