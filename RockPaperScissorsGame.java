import java.util.Random;
import java.util.Scanner;

public class RockPaperScissorsGame {

    static final int TOTAL_ROUNDS = 5;

    // Decides the result of one round
    public static String playRound(String playerMove, String computerMove) {

        if (playerMove.equalsIgnoreCase(computerMove)) {
            return "Draw";
        }

        if ((playerMove.equalsIgnoreCase("Rock") &&
             computerMove.equalsIgnoreCase("Scissors")) ||
            (playerMove.equalsIgnoreCase("Paper") &&
             computerMove.equalsIgnoreCase("Rock")) ||
            (playerMove.equalsIgnoreCase("Scissors") &&
             computerMove.equalsIgnoreCase("Paper"))) {

            return "Player Wins";
        }

        return "Computer Wins";
    }

    // Generates computer's random move
    public static String generateComputerMove(Random random) {

        int choice = random.nextInt(3);

        if (choice == 0) {
            return "Rock";
        } else if (choice == 1) {
            return "Paper";
        } else {
            return "Scissors";
        }
    }

    // Takes and validates player's input
    public static String getPlayerMove(Scanner scanner) {

        while (true) {

            System.out.print("Enter Rock, Paper or Scissors: ");
            String playerMove = scanner.nextLine();

            if (playerMove.equalsIgnoreCase("Rock") ||
                playerMove.equalsIgnoreCase("Paper") ||
                playerMove.equalsIgnoreCase("Scissors")) {

                return playerMove;
            }

            System.out.println("Invalid move. Try again.");
        }
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int playerWins = 0;
        int computerWins = 0;
        int draws = 0;

        System.out.println("=== Rock-Paper-Scissors Game ===");

        for (int round = 1; round <= TOTAL_ROUNDS; round++) {

            System.out.println("\nRound " + round);

            String playerMove = getPlayerMove(scanner);
            String computerMove = generateComputerMove(random);

            String result = playRound(playerMove, computerMove);

            if (result.equals("Player Wins")) {
                playerWins++;
            } else if (result.equals("Computer Wins")) {
                computerWins++;
            } else {
                draws++;
            }

            System.out.println("Player Move   : " + playerMove);
            System.out.println("Computer Move : " + computerMove);
            System.out.println("Result        : " + result);
        }

        double winPercentage =
                (playerWins * 100.0) / TOTAL_ROUNDS;

        System.out.println("\n=== Final Summary ===");
        System.out.println("Wins           : " + playerWins);
        System.out.println("Losses         : " + computerWins);
        System.out.println("Draws          : " + draws);
        System.out.printf("Win Percentage : %.1f%%%n", winPercentage);

        scanner.close();
    }
}