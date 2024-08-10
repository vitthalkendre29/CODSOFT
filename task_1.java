import java.util.Scanner;

public class task_1 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int no_win = 0;
        int roundNumber = 1;
        String againplay = "yes"; // Corrected variable type and initialization

        while (againplay.equals("yes")) {
            // Creating random number
            double randomnum = (Math.random() * 100) + 1;
            // Converting double to int
            int numberToGuess = (int) randomnum;
            int maxAttempts = 10;
            int attempts = 0;

            System.out.println("\n--- Round " + roundNumber + " ---");
            System.out.println("I'm thinking of a number between 1 and 100.");
            System.out.println("You have " + maxAttempts + " attempts to guess it.");

            while (attempts < maxAttempts) {
                System.out.print("Enter your guess: ");
                int userGuess;

                try {
                    userGuess = Integer.parseInt(input.nextLine());
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input. Please enter an integer.");
                    continue;
                }

                attempts++;

                if (userGuess < numberToGuess) {
                    System.out.println("Too low!");
                } else if (userGuess > numberToGuess) {
                    System.out.println("Too high!");
                } else {
                    System.out.println("Congratulations! You guessed the number in " + attempts + " attempts.");
                    no_win += maxAttempts - attempts + 1;
                    break;
                }
            }

            if (attempts == maxAttempts) {
                System.out.println("Sorry, you've used all " + maxAttempts + " attempts. The correct number was " + numberToGuess + ".");
            }

            System.out.print("Do you want to play another round? (yes/no): ");
            againplay = input.nextLine().trim().toLowerCase();  // Ensure consistent input

            roundNumber++;
        }

        System.out.println("Game over! Your final score is: " + no_win);
        input.close();
    }
}
