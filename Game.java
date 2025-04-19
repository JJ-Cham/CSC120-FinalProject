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
        System.out.println("Welcome to Escape the NYC Subway!");
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

