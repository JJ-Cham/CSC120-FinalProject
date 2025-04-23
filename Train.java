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

