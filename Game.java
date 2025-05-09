import java.util.Scanner;

public class Game {

    //Attributes
    private Player player;
    private Train train;
    private boolean isRunning;
    private static long startTime;
    private static long timeLimit = 420_000; // 7 minutes
    private static int score = 0;

    /**
     * 
     * Constructor for the Game class.
     * Initializes the game with a new train and player.
     */
    public void start() {
        train = new Train();
        player = new Player(train.getStartingCar());
        isRunning = true;
        startTime = System.currentTimeMillis();

                  // ASCII banner

        System.out.println("'########:'########:::::'###::::'########::'########::'########:'########:::");
        System.out.println("... ##..:: ##.... ##:::'## ##::: ##.... ##: ##.... ##: ##.....:: ##.... ##:");
        System.out.println("::: ##:::: ##:::: ##::'##:. ##:: ##:::: ##: ##:::: ##: ##::::::: ##:::: ##:.");
        System.out.println("::: ##:::: ########::'##:::. ##: ########:: ########:: ######::: ##:::: ##::");
        System.out.println("::: ##:::: ##.. ##::: #########: ##.....::: ##.....::: ##...:::: ##:::: ##::");
        System.out.println("::: ##:::: ##::. ##:: ##.... ##: ##:::::::: ##:::::::: ##::::::: ##:::: ##:");
        System.out.println("::: ##:::: ##:::. ##: ##:::: ##: ##:::::::: ##:::::::: ########: ########::");
        System.out.println(":::..:::::..:::::..::..:::::..::..:::::::::..:::::::::........::........:::");
        System.out.println();

                    
                

        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to Escape the NYC Subway!");
        System.out.println("Type 'look' to see your surroundings, 'go [direction]' to move, or 'quit' to exit.");
        System.out.println("You wake up on a stalled subway train somewhere under the Bronx.");
        System.out.println("You're alone. The doors are jammed. The lights are flickering.");
        System.out.println("Find a way through the train... before time runs out.");
        System.out.println("You're trapped on the 2/5 line at 3rd Ave 149th St.\n");

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
            if (input.startsWith("take ")) {
                String itemName = input.substring(5);
                player.takeItem(itemName);
                showTimeRemaining();
            } else if (input.equalsIgnoreCase("inventory")) {
                player.showInventory();
                showTimeRemaining();
            }
            else if (input.startsWith("solve ")) {
                String attempt = input.substring(6);
                if (player.getCurrentCar().hasPuzzle()) {
                    boolean success = player.getCurrentCar().solvePuzzle(attempt);
                    if (success) {
                        System.out.println("You solved the puzzle!");
                        Game.addScore(15);
                    } else {
                        System.out.println("That’s not the correct solution.");
                        Game.addScore(-2);
                    }
                } else {
                    System.out.println("There’s no puzzle here to solve.");
                }
            }            
            
        }
        scanner.close();
        System.out.println("Game over!");

        System.out.println("Thanks for playing!");
    }

    /**
     * Checks if the time limit has been reached.
     * @return true if time is up, false otherwise.
     */
    private boolean isTimeUp() {
        long currentTime = System.currentTimeMillis();
        if ((currentTime - startTime) >= timeLimit) {
            System.out.println("⏰ Time's up! The train grinds to life... but you're still inside.");
            System.out.println("Maybe next time you'll escape.");
            return true;
        }
        return false;

    }

    /**
     * Displays the time remaining in the game.
     */
    private void showTimeRemaining() {
        long timeRemaining = timeLimit - (System.currentTimeMillis() - startTime);
        long minutes = (timeRemaining / 1000) / 60;
        long seconds = (timeRemaining / 1000) % 60;
        System.out.println("⏳ Time remaining: " + minutes + " minutes and " + seconds + " seconds.");
    }

    /**
     * Adds time to the time limit.
     * @param millis the amount of time in milliseconds to add.
     */
    public static void addTime(long millis) {
        timeLimit += millis;
    }

    /**
     * Adjusts the player's score by the given amount.
     * @param points the number of points to add or subtract.
     */

    public static void addScore(int points) {
        score += points;
    }
    
    /**
     * Retrieves the current player score.
     * @return the player's score.
     */
    public static int getScore() {
        return score;
    }

    /**
     * Retrieves the time remaining in the game.
     * @return the time remaining in milliseconds.
     */
    public static long getTimeRemaining() {
        return timeLimit - (System.currentTimeMillis() - startTime);
    }
    
    

    public static void main(String[] args) {
        new Game().start();
    }
}


