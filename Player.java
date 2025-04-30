import java.util.ArrayList;

public class Player {
    //Attributes
    private CarLocation currentCar;
    private ArrayList<Item> inventory;

    /**
     * Constructor for the Player class.
     * Initializes the player with a starting car location and an empty inventory.
     * @param startingCar The initial car location of the player.
     */
    public Player(CarLocation startingCar) {
        this.currentCar = startingCar;
        this.inventory = new ArrayList<>();
    }


    /**
     * Moves the player to a new car location based on the specified direction.
     * Handles logic for blocked exits, item requirements, and escape scenarios.
     * @param direction The direction in which the player wants to move.
     */
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
        if (currentCar.isExit()) {
            if (Game.getTimeRemaining() > 60000) {
                System.out.println("You escape with time to spare. You're a pro survivor.");
                Game.addScore(20);
            } else if (Game.getTimeRemaining() > 0) {
                System.out.println("You escape just in time, panting as the doors slam behind you.");
                Game.addScore(10);
            } else {
                System.out.println("You failed to escape in time.");
                Game.addScore(0);
            }
        
            System.out.println("Final Score: " + Game.getScore());
            System.exit(0);
        }

        if (currentCar.isExit()) {
            long timeLeft = Game.getTimeRemaining();
        
            if (timeLeft > 120000) {
                System.out.println("You escaped with time to spare. You remain calm as you walk into the light.");
            } else if (timeLeft > 0) {
                System.out.println("You escape just as the lights cut out. That was close.");
            } else {
                System.out.println("⏰ You were too late... the doors jam shut behind you.");
            }
        
            System.out.println("Final Score: " + Game.getScore());
            System.exit(0);
        }
        
    }
    
    /**
     * Displays the current car's description, available exits, and items.
     * Also triggers a random event for added immersion.
     */
    public void look() {
        System.out.println(currentCar.getDescription());
        System.out.println("Exits: " + currentCar.getAvailableExits());
        currentCar.listItems();
        randomEvent();
    }

    /**
    * Allows the player to pick up an item from the current car and apply score effects.
    * @param itemName The name of the item to take.
    */
    public void takeItem(String itemName) {
        if (currentCar.hasItem(itemName)) {
           Item item = currentCar.takeItem(itemName); // ✅ make sure this line exists
           inventory.add(item);
           System.out.println("You picked up: " + item.getName());

        // Scoring logic
        if (item.getName().equalsIgnoreCase("Crowbar") || item.getName().equalsIgnoreCase("Key")) {
            Game.addScore(10);  // Reward for real item
        } else {
            System.out.println("It seems useless...");
            Game.addScore(-5);  // Penalty for fake item
        }

    } else {
        System.out.println("There is no item named '" + itemName + "' here.");
    }
}


     /**
     * Displays the player's current inventory of items.
     */
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
    
    /**
     * Checks if the player has a specific item in their inventory.
     * @param itemName The name of the item to check for.
     * @return true if the item is found, false otherwise.
     */
    public boolean hasItem(String itemName) {
        for (Item item : inventory) {
            if (item.getName().equalsIgnoreCase(itemName)) {
                return true;
            }
        }
        return false;
    }

    /**
    * Gets the current CarLocation the player is in.
    * @return the current car location.
    */
    public CarLocation getCurrentCar() {
       return currentCar;
   }


    /**
    * Triggers a random event with a 20% chance when the player interacts with a train car.
    * The event can be suspenseful (spooky) or beneficial (granting bonuses like extra time).
    * Events include sounds, environmental changes, or finding useful items.
    */
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
