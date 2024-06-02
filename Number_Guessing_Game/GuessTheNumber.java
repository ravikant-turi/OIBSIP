import java.util.Random;
import java.util.Scanner;

public class GuessTheNumber {
    private static final int MAX_ATTEMPTS = 10;
    private static final int NUMBER_RANGE = 100;
    private static final int POINTS_PER_GUESS = 10;

    private Random random;
    private Scanner scanner;
    private int totalScore;

    public GuessTheNumber() {
        random = new Random();
        scanner = new Scanner(System.in);
        totalScore = 0;
    }

    public void startGame() {
        System.out.println("Welcome to Guess the Number Game!");
        boolean keepPlaying = true;

        while (keepPlaying) {
            playRound();
            System.out.println("Your current score is: " + totalScore);

            System.out.print("Do you want to play another round? (yes/no): ");
            String response = scanner.next();
            keepPlaying = response.equalsIgnoreCase("yes");
        }

        System.out.println("Thank you for playing! Your final score is: " + totalScore);
    }

    private void playRound() {
        int targetNumber = random.nextInt(NUMBER_RANGE) + 1;
        int attempts = 0;
        boolean guessedCorrectly = false;

        System.out.println("A new number has been generated between 1 and " + NUMBER_RANGE + ". Try to guess it!");

        while (attempts < MAX_ATTEMPTS && !guessedCorrectly) {
            System.out.print("Enter your guess (attempt " + (attempts + 1) + " of " + MAX_ATTEMPTS + "): ");
            int guess = scanner.nextInt();
            attempts++;

            if (guess < targetNumber) {
                System.out.println("The number is higher than " + guess);
            } else if (guess > targetNumber) {
                System.out.println("The number is lower than " + guess);
            } else {
                System.out.println("Congratulations! You guessed the number in " + attempts + " attempts.");
                guessedCorrectly = true;
                totalScore += calculatePoints(attempts);
            }
        }

        if (!guessedCorrectly) {
            System.out.println("You've used all attempts. The number was " + targetNumber);
        }
    }

    private int calculatePoints(int attempts) {
        return (MAX_ATTEMPTS - attempts + 1) * POINTS_PER_GUESS;
    }

    public static void main(String[] args) {
        GuessTheNumber game = new GuessTheNumber();
        game.startGame();
    }
}
