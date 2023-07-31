import java.util.Scanner;
import java.util.Random;

public class main {
    public static void main(String[] args) {
        String[] choices = { "rock", "paper", "scissors" };
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        System.out.println("Let's play Rock-Paper-Scissors!");
        System.out.println("Enter your choice: rock, paper, or scissors");

        while (true) {
            String playerChoice = scanner.next().toLowerCase();
            if (!isValidChoice(playerChoice)) {
                System.out.println("Invalid choice. Please choose 'rock', 'paper', or 'scissors'.");
                continue;
            }

            int computerChoiceIndex = random.nextInt(choices.length);
            String computerChoice = choices[computerChoiceIndex];

            System.out.println("Computer chooses: " + computerChoice);
            System.out.println(determineWinner(playerChoice, computerChoice));

            System.out.println("Play again? (yes/no)");
            String playAgain = scanner.next().toLowerCase();
            if (!playAgain.equals("yes")) {
                break;
            }
        }

        System.out.println("Thanks for playing!");
        scanner.close();
    }

    private static boolean isValidChoice(String choice) {
        return choice.equals("rock") || choice.equals("paper") || choice.equals("scissors");
    }

    private static String determineWinner(String playerChoice, String computerChoice) {
        if (playerChoice.equals(computerChoice)) {
            return "It's a tie!";
        } else if ((playerChoice.equals("rock") && computerChoice.equals("scissors")) ||
                   (playerChoice.equals("paper") && computerChoice.equals("rock")) ||
                   (playerChoice.equals("scissors") && computerChoice.equals("paper"))) {
            return "You win!";
        } else {
            return "Computer wins!";
        }
    }
}
