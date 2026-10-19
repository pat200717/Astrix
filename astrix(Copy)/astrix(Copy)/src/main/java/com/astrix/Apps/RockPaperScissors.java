package com.astrix.Apps;

import com.astrix.astrixModule.AstrixConsole;

import java.util.Random;

public class RockPaperScissors extends Apps {

    AstrixConsole con = new AstrixConsole();

    private static final String[] MOVES = {
        "Rock",
        "Paper",
        "Scissors"
    };

    private final Random random = new Random();

    private int playerWins;
    private int computerWins;
    private int ties;

    public RockPaperScissors() {
        super(false);
    }

    @Override
    public String getName() {
        return "Rock Paper Scissors";
    }

    @Override
    public String getCode() {
        return "rps";
    }

    @Override
    public String creatorName() {
        return "John Rafael Esquillo";
    }

    @Override
    public double sizeFile() {
        return 4.0;
    }

    @Override
    public String version() {
        return "1.0";
    }

    @Override
    public String description() {
        return "A classic Rock Paper Scissors game against the computer.";
    }

    @Override
    public void run() {

        while (true) {

            playerWins = 0;
            computerWins = 0;
            ties = 0;

            for (int round = 1; round <= 3; round++) {

                con.clear();
                con.title("ROCK PAPER SCISSORS");

                System.out.println("ROUND " + round + " OF 3");
                System.out.println();

                System.out.println("1. Rock");
                System.out.println("2. Paper");
                System.out.println("3. Scissors");
                System.out.println("4. Exit");

                int choice = readChoice();

                if (choice == 4) {
                    return;
                }

                playRound(choice);

                if (round < 3) {
                    con.doublePause();
                }
            }

            con.clear();
            con.title("SERIES RESULTS");

            System.out.println("You      : " + playerWins);
            System.out.println("Computer : " + computerWins);
            System.out.println("Ties     : " + ties);

            con.lineSpacing(1);

            if (playerWins > computerWins) {
                System.out.println("You won the series!");
            } else if (computerWins > playerWins) {
                System.out.println("Computer won the series!");
            } else {
                System.out.println("It's an overall tie!");
            }

            con.lineSpacing(2);

            System.out.println("1. Play Again");
            System.out.println("2. Back to Home Screen");

            int choice = con.choose();

            if (choice == 1) {
                continue;
            }

            if (choice == 2) {
                return;
            }

            System.out.println("Invalid Input");
            con.doublePause();
        }
    }

    private int readChoice() {

        while (true) {

            int choice = con.choose();

            if (choice >= 1 && choice <= 4) {
                return choice;
            }

            System.out.println("Please choose 1, 2, 3, or 4.");
            con.doublePause();
        }
    }

    private void playRound(int choice) {

        String playerMove = MOVES[choice - 1];
        String computerMove = MOVES[random.nextInt(3)];

        System.out.println();
        System.out.println("You chose      : " + playerMove);
        System.out.println("Computer chose : " + computerMove);

        if (playerMove.equals(computerMove)) {

            System.out.println("It's a tie!");
            ties++;

        } else if (beats(playerMove, computerMove)) {

            System.out.println("You win this round!");
            playerWins++;

        } else {

            System.out.println("Computer wins this round!");
            computerWins++;
        }
    }

    private boolean beats(String player, String computer) {

        return (player.equals("Rock") && computer.equals("Scissors"))
                || (player.equals("Scissors") && computer.equals("Paper"))
                || (player.equals("Paper") && computer.equals("Rock"));
    }
}