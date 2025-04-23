import java.util.Scanner;

public class Game {
    private Player player;
    private Train train;
    private boolean isRunning;
    private long startTime;
    private long timeLimit = 300_000; // 5 minutes

    public void start() {
        train = new Train();
        player = new Player(train.getStartingCar());
        isRunning = true;
        startTime = System.currentTimeMillis();

        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to Escape the NYC Subway!");
        System.out.println("Type 'look' to see your surroundings, 'go [direction]' to move, or 'quit' to exit.");
        player.look();

        while (isRunning) {
            if (isTimeUp()) {
                System.out.println("⏰ Time's up! You failed to escape the subway...");
                isRunning = false;
                continue;
            }

            System.out.print("> ");
            String input = scanner.nextLine().trim();

            if (input.equalsIgnoreCase("quit")) {
                isRunning = false;
            } else if (input.startsWith("go ")) {
                String direction = input.substring(3);
                player.move(direction);
                showTimeRemaining();
            } else if (input.equalsIgnoreCase("look")) {
                player.look();
                showTimeRemaining();
            } else {
                System.out.println("I don't understand that command.");
            }
        }
        scanner.close();
        System.out.println("Game over!");

        System.out.println("Thanks for playing!");
    }


    private boolean isTimeUp() {
        long currentTime = System.currentTimeMillis();
        return (currentTime - startTime) >= timeLimit;
    }

    private void showTimeRemaining() {
        long timeRemaining = timeLimit - (System.currentTimeMillis() - startTime);
        long minutes = (timeRemaining / 1000) / 60;
        long seconds = (timeRemaining / 1000) % 60;
        System.out.println("⏳ Time remaining: " + minutes + " minutes and " + seconds + " seconds.");
    }

    public static void main(String[] args) {
        new Game().start();
    }
}


