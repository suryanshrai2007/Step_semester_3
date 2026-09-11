package programming_fundamentals.class_problems;

import java.util.Random;

public class RockPaperScissorsGame {

    static String[] moves = {"Rock", "Paper", "Scissors"};

    static String generateComputerMove() {
        Random random = new Random();
        int index = random.nextInt(3);
        return moves[index];
    }

    static String playRound(String playerMove, String computerMove) {
        if (playerMove.equals(computerMove)) {
            return "Draw";
        }

        if ((playerMove.equals("Rock") && computerMove.equals("Scissors"))
                || (playerMove.equals("Paper") && computerMove.equals("Rock"))
                || (playerMove.equals("Scissors") && computerMove.equals("Paper"))) {
            return "Player Wins";
        }

        return "Computer Wins";
    }

    public static void main(String[] args) {
        String[] playerMoves = {"Rock", "Paper", "Scissors", "Rock", "Paper"};
        int totalRounds = playerMoves.length;

        int wins = 0;
        int losses = 0;
        int draws = 0;

        System.out.println("Round | Player Move | Computer Move | Result");

        for (int round = 1; round <= totalRounds; round++) {
            String playerMove = playerMoves[round - 1];
            String computerMove = generateComputerMove();
            String result = playRound(playerMove, computerMove);

            System.out.println(round + " | " + playerMove + " | " + computerMove + " | " + result);

            if (result.equals("Player Wins")) {
                wins++;
            } else if (result.equals("Computer Wins")) {
                losses++;
            } else {
                draws++;
            }
        }

        double winPercentage = (wins * 100.0) / totalRounds;

        System.out.println("Wins: " + wins + " | Losses: " + losses + " | Draws: " + draws
                + " | Win % = " + winPercentage + "%");
    }
}