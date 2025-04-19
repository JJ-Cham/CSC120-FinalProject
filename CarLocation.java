import java.util.HashMap;


    public class CarLocation {
    private String description;
    private HashMap<String, CarLocation> exits;

    public CarLocation(String description) {
        this.description = description;
        this.exits = new HashMap<>();
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
}

// This class represents a location in the subway train. Each location has a description and exits to other locations.
// The exits are stored in a HashMap where the key is the direction (e.g., "forward", "backward") and the value is the neighboring CarLocation object.
// The class provides methods to add exits, get the description of the location, and get the available exits from that location.
// The CarLocation class is used in the Player and Train classes to manage the player's current location and the train's structure.
  public static void main(String[] args) {
        // Create a new CarLocation object and add exits to it
        CarLocation car1 = new CarLocation("a dirty, graffiti-covered subway car");
        CarLocation car2 = new CarLocation("a car with flickering lights and shattered windows");
        car1.addExit("forward", car2);
        
        // Print the description and available exits of the first car
        System.out.println(car1.getDescription());
        System.out.println("Exits: " + car1.getAvailableExits());
    }

