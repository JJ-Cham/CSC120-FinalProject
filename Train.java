import java.util.ArrayList;

public class Train {
    private ArrayList<CarLocation> cars;

    public Train() {
        cars = new ArrayList<>();
        setupTrain();
    }

    private void setupTrain() {
        CarLocation car1 = new CarLocation("a dirty, graffiti-covered subway car");
        CarLocation car2 = new CarLocation("a car with flickering lights and shattered windows");
        CarLocation car3 = new CarLocation("a wrecked car filled with abandoned luggage");

        car1.addExit("forward", car2);
        car2.addExit("backward", car1);
        car2.addExit("forward", car3);
        car3.addExit("backward", car2);

        cars.add(car1);
        cars.add(car2);
        cars.add(car3);
    }

    public CarLocation getStartingCar() {
        return cars.get(0);
    }
}

public static void main(String[] args) {
    // Create a new Train object and get the starting car
    Train train = new Train();
    CarLocation startingCar = train.getStartingCar();
    
    // Print the description of the starting car
    System.out.println("Starting car: " + startingCar.getDescription());
}
// Print the available exits from the starting car
    System.out.println("Exits: " + startingCar.getAvailableExits());
}
