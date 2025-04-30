import java.util.ArrayList;

public class Train {

    //Attributes
    private ArrayList<CarLocation> cars;


    /**
     * Constructor for the Train class.
     * Initializes the train with a list of car locations and sets up the train layout.
     */
    public Train() {
        cars = new ArrayList<>();
        setupTrain();
    }

    /**
     * Sets up the train layout with cars, exits, and items.
     * Creates a series of connected car locations and places items in them.
     */
    private void setupTrain() {
        // Create Cars
        CarLocation car1 = new CarLocation("a dirty, graffiti-covered subway car");
        CarLocation car2 = new CarLocation("a flickering light car with debris scattered around");
        CarLocation car3 = new CarLocation("a wrecked car with doors jammed shut");
        CarLocation car4 = new CarLocation("a car with sparking wires and caved-in ceiling");
        CarLocation exitDoor = new CarLocation("the exit door leading to freedom... maybe");

        exitDoor.setExit(true);

    
        // Add exits
        car1.addExit("forward", car2);
        car2.addExit("backward", car1);
        car2.addExit("forward", car3);
        car3.addExit("backward", car2);
        car3.addExit("forward", car4);
        car4.addExit("backward", car3);
        car4.addExit("forward", exitDoor);
        exitDoor.addExit("backward", car4);
    
        // Create items
        Item crowbar = new Item("Crowbar", "A rusty crowbar, might pry open a stuck door.");
        Item gum = new Item("Old Gum", "Someone stuck this under a seat. Ew.");
        Item key = new Item("Key", "A small key. Looks like it could open a lock.");
        Item bottle = new Item("Water Bottle", "Half full. Or half empty.");
    
        // Place items
        car2.addItem(crowbar);
        car2.addItem(gum);     // fake
        car4.addItem(key);
        car4.addItem(bottle);  // fake
    
        // Locked rooms
        car3.lock("Crowbar");   // needs crowbar to enter
        exitDoor.lock("Key");   // needs key to enter
    
        // Add to train
        cars.add(car1);
        cars.add(car2);
        cars.add(car3);
        cars.add(car4);
        cars.add(exitDoor);
        car3.setPuzzle("729"); // Room requires player to solve "729" (like a code)


    }    
    
    /**
     * Returns the list of car locations in the train.
     * @return ArrayList of CarLocation objects representing the train's cars.
     */
    public CarLocation getStartingCar() {
        return cars.get(0);
    }
}

