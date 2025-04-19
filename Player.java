public class Player {
    private CarLocation currentCar;

    public Player(CarLocation startingCar) {
        this.currentCar = startingCar;
    }

    public void move(String direction) {
        CarLocation nextCar = currentCar.getExit(direction);
        if (nextCar != null) {
            currentCar = nextCar;
            System.out.println("You move " + direction + ".");
            System.out.println(currentCar.getDescription());
            System.out.println("Exits: " + currentCar.getAvailableExits());
        } else {
            System.out.println("You can't go that way!");
        }
    }

    public void look() {
        System.out.println(currentCar.getDescription());
        System.out.println("Exits: " + currentCar.getAvailableExits());
    }
}

 public static void main(String[] args) {
        // Create a new Player object and set the starting car
        CarLocation startingCar = new CarLocation("a dirty, graffiti-covered subway car");
        Player player = new Player(startingCar);
        
        // Print the initial description and available exits
        player.look();
        
        // Simulate moving in a direction (e.g., "forward")
        player.move("forward");
    }