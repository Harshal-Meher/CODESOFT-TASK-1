import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {

    public static void main(String[] args) {
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);
        int rangeMin = 1;
        int rangeMax = 100;
        int maxAttempts = 10;
        int round = 1;
        int score = 0;
        boolean playAgain = true;
        System.out.println("Welcome to Guess The Number!");
        System.out.println("I will think of a number between " + rangeMin + " and " + rangeMax + ".");
        System.out.println("You have to guess what it is in " + maxAttempts + " attempts or less.");
        System.out.println("Let's begin!");
        while (playAgain) {
            int number = random.nextInt(rangeMax - rangeMin + 1) + rangeMin;
            int guess = 0;
            int attempts = 0;
            boolean guessed = false;
            System.out.println("\nRound " + round + ":");
            while (attempts < maxAttempts && !guessed) {
                System.out.print("Enter your guess: ");
                guess = scanner.nextInt();
                attempts++;
                if (guess == number) {
                    System.out.println("You got it! The number was " + number + ".");
                    guessed = true;
                } else if (guess < number) {
                    System.out.println("Too low. Try again.");
                } else {
                    System.out.println("Too high. Try again.");
                }
            }
            if (guessed) {
                score += (maxAttempts - attempts + 1);
                System.out.println("Congratulations! You won this round.");
            } else {
                System.out.println("Sorry, you lost this round. The number was " + number + ".");
            }
            System.out.println("Your score is " + score + ".");
            System.out.print("Do you want to play again? (y/n): ");
            char choice = scanner.next().charAt(0);
            if (choice == 'y' || choice == 'Y') {
                round++;
                playAgain = true;
            } else {
                playAgain = false;
                System.out.println("Thank you for playing. Goodbye!");
            }
        }
        scanner.close();
    }
}
