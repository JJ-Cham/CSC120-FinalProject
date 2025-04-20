import java.util.Scanner;

public class Game {
    private Player player;
    private Train train;
    private boolean isRunning;

    public void start() {
        train = new Train();
        player = new Player(train.getStartingCar());
        isRunning = true;

        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to Escape the NYC Subway! You're trapped in a train on the 2 and 5 line on 3-av and 149st and need to find a way out.");
        System.out.println("Type 'look' to see your surroundings, 'go [direction]' to move, or 'quit' to exit the game.");
        System.out.println("You are currently in " + player.getCurrentCar().getDescription() + ".");
        player.look();

        while (isRunning) {
            System.out.print("> ");
            String input = scanner.nextLine().trim();
            if (input.equalsIgnoreCase("quit")) {
                isRunning = false;
            } else if (input.startsWith("go ")) {
                String direction = input.substring(3);
                player.move(direction);
            } else if (input.equalsIgnoreCase("look")) {
                player.look();
            } else {
                System.out.println("I don't understand that command.");
            }
        }

        System.out.println("Thanks for playing!");
    }

    public static void main(String[] args) {
        new Game().start();
    }
}

