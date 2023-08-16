import java.util.Scanner;

public class NumberGame {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int min_num = 1;
        int max_num = 100;
        int chances = 10;
        int final_score = 0;
        boolean playAgain = true;

        System.out.println("Welcome in the Number Game!");
        System.out.println("You have " + chances + " chances to guess the number between " + min_num + " and " + max_num + ".");

        while (playAgain) {
            int randomNumber = getRandomNumber(min_num, max_num);
            boolean guessedCorrectly = false;

            for (int i = 0; i < chances; i++) {
                System.out.print("Attempt " + (i + 1) + ": Enter your guess: ");
                int userGuess = sc.nextInt();

                if (userGuess == randomNumber) {
                    System.out.println("Congratulation! You guessed the number!");
                    guessedCorrectly = true;
                    final_score += 1;
                    break;
                } else if (userGuess < randomNumber) {
                    System.out.println("Too low! Try again.");
                } else {
                    System.out.println("Too high! Try again.");
                }
            }

            if (!guessedCorrectly) {
                System.out.println("Sorry, You have used all your chances. The number was: " + randomNumber);
            }

            System.out.print("Do you want to play again? (yes/no): ");
            String playAgainChoice = sc.next();
            playAgain = playAgainChoice.equalsIgnoreCase("yes");
        }

        System.out.println("Game Over! Your final_score is: " + final_score);
        sc.close();
    }

    public static int getRandomNumber(int min_num, int max_num) {
        return (int) (Math.random() * (max_num - min_num + 1) + min_num);
    }
}
