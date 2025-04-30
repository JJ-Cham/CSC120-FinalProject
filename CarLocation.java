import java.util.HashMap;
import java.util.ArrayList;


public class CarLocation {
    private String description;
    private HashMap<String, CarLocation> exits;
    private ArrayList<Item> items; 
    private boolean isLocked = false;
    private String requiredItemName = "";
    private boolean isExit = false;
    private boolean hasPuzzle = false;
    private String puzzleAnswer = "";
    private boolean puzzleSolved = false;




    public CarLocation(String description) {
        this.description = description;
        this.exits = new HashMap<>();
        this.items = new ArrayList<>();
    }

    public void addExit(String direction, CarLocation neighbor) {
        exits.put(direction, neighbor);
    }

    public CarLocation getExit(String direction) {
        return exits.get(direction);
    }

    public String getDescription() {
        return description;
    }

    public String getAvailableExits() {
        return String.join(", ", exits.keySet());
    }
    public void addItem(Item item) {
        items.add(item);
    }
    
    public boolean hasItem(String itemName) {
        for (Item item : items) {
            if (item.getName().equalsIgnoreCase(itemName)) {
                return true;
            }
        }
        return false;
    }
    
    public Item takeItem(String itemName) {
        for (Item item : items) {
            if (item.getName().equalsIgnoreCase(itemName)) {
                items.remove(item);
                return item;
            }
        }
        return null;
    }
    
    public void listItems() {
        if (items.isEmpty()) {
            System.out.println("There are no items here.");
        } else {
            System.out.println("You see:");
            for (Item item : items) {
                System.out.println("- " + item.getName() + ": " + item.getDescription());
            }
        }
    }
    public void lock(String requiredItemName) {
        isLocked = true;
        this.requiredItemName = requiredItemName;
    }
    
    public boolean canEnter(Player player) {
        if (!isLocked) {
            return true;
        }
        return player.hasItem(requiredItemName);
    }

    public void setExit(boolean isExit) {
        this.isExit = isExit;
    }
    
    public boolean isExit() {
        return isExit;
    }

    public String getRequiredItemName() {
        return requiredItemName;
    }

    public void setPuzzle(String answer) {
        hasPuzzle = true;
        puzzleAnswer = answer.toLowerCase();
    }
    
    public boolean hasPuzzle() {
        return hasPuzzle && !puzzleSolved;
    }
    
    public boolean solvePuzzle(String attempt) {
        if (puzzleAnswer.equals(attempt.toLowerCase())) {
            puzzleSolved = true;
            return true;
        }
        return false;
    }
    
    
    
    
}

// This class represents a location in the subway train. Each location has a description and exits to other locations.
// The exits are stored in a HashMap where the key is the direction (e.g., "forward", "backward") and the value is the neighboring CarLocation object.
// The class provides methods to add exits, get the description of the location, and get the available exits from that location.
// The CarLocation class is used in the Player and Train classes to manage the player's current location and the train's structure.

