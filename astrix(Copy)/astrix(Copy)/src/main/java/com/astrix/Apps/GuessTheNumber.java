package com.astrix.Apps;

import com.astrix.Apps.Apps;
import com.astrix.astrixModule.AstrixConsole;

import java.util.Random;

public class GuessTheNumber extends Apps {

    AstrixConsole con = new AstrixConsole();
    Random random = new Random();

    public GuessTheNumber() {
        super(false);
    }

    @Override
    public String getName() {
        return "Guess The Number";
    }

    @Override
    public String getCode() {
        return "guess";
    }

    @Override
    public String creatorName() {
        return "Student Developer";
    }

    @Override
    public double sizeFile() {
        return 6;
    }

    @Override
    public String version() {
        return "1.0";
    }

    @Override
    public String description() {
        return "Guess the secret number between 1 and 100.";
    }

    @Override
    public void run() {

        while (true) {

            int secretNumber = random.nextInt(100) + 1;
            int attempts = 7;
            boolean guessed = false;

            while (attempts > 0) {

                con.clear();
                con.title("GUESS THE NUMBER");

                System.out.println("Guess the number between 1 and 100.");
                System.out.println("Attempts left: " + attempts);

                con.lineSpacing(1);

                System.out.println("0. Back to Home Screen");

                int guess = con.choose();

                if (guess == 0) {
                    return;
                }

                if (guess < 1 || guess > 100) {
                    System.out.println("Enter a number between 1 and 100.");
                    con.doublePause();
                    continue;
                }

                if (guess == secretNumber) {

                    guessed = true;

                    con.clear();
                    con.title("GUESS THE NUMBER");

                    System.out.println("🎉 Correct!");
                    System.out.println("The number was: " + secretNumber);

                    break;
                }

                if (guess < secretNumber) {
                    System.out.println("Too low!");
                } else {
                    System.out.println("Too high!");
                }

                attempts--;

                if (attempts > 0) {
                    con.doublePause();
                }
            }

            if (!guessed) {

                con.clear();
                con.title("GUESS THE NUMBER");

                System.out.println("Game Over!");
                System.out.println("The number was: " + secretNumber);
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
}