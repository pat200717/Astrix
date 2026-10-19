package com.astrix.Apps;

import com.astrix.Apps.Apps;
import com.astrix.astrixModule.AstrixConsole;

import java.util.Random;

public class LuckyCoin extends Apps {

    AstrixConsole con = new AstrixConsole();
    Random random = new Random();

    private int credits = 100;

    public LuckyCoin() {
        super(false);
    }

    @Override
    public String getName() {
        return "Lucky Coin";
    }

    @Override
    public String getCode() {
        return "coin";
    }

    @Override
    public String creatorName() {
        return "Student Developer";
    }

    @Override
    public double sizeFile() {
        return 4;
    }

    @Override
    public String version() {
        return "1.0";
    }

    @Override
    public String description() {
        return "A virtual coin-flip betting game using Astrix Credits.";
    }

    @Override
    public void run() {

        while (true) {

            if (credits <= 0) {

                con.clear();
                con.title("LUCKY COIN");

                System.out.println("You have no credits left.");
                System.out.println();
                System.out.println("1. Reset Credits");
                System.out.println("2. Back to Home Screen");

                int reset = con.choose();

                if (reset == 1) {
                    credits = 100;
                    continue;
                }

                if (reset == 2) {
                    return;
                }

                System.out.println("Invalid Input");
                con.doublePause();
                continue;
            }

            con.clear();
            con.title("LUCKY COIN");

            System.out.println("Credits: " + credits);
            System.out.println();

            System.out.println("1. Heads");
            System.out.println("2. Tails");
            System.out.println("3. Back to Home Screen");

            int choice = con.choose();

            if (choice == 3) {
                return;
            }

            if (choice < 1 || choice > 3) {
                System.out.println("Invalid Input");
                con.doublePause();
                continue;
            }

            con.clear();
            con.title("LUCKY COIN");

            System.out.println("Credits: " + credits);
            System.out.println();
            System.out.println("Enter your bet:");
            System.out.println("Maximum: " + credits);

            int bet = con.choose();

            if (bet < 1 || bet > credits) {
                System.out.println("Invalid bet.");
                con.doublePause();
                continue;
            }

            int result = random.nextInt(2) + 1;

            con.clear();
            con.title("LUCKY COIN");

            System.out.println("Flipping coin...");
            con.doublePause();

            if (result == choice) {

                credits += bet;

                System.out.println("🪙 The coin landed on "
                        + (result == 1 ? "Heads!" : "Tails!"));

                System.out.println("You won " + bet + " credits!");

            } else {

                credits -= bet;

                System.out.println("🪙 The coin landed on "
                        + (result == 1 ? "Heads!" : "Tails!"));

                System.out.println("You lost " + bet + " credits.");
            }

            System.out.println();
            System.out.println("Credits: " + credits);

            con.lineSpacing(2);

            System.out.println("1. Play Again");
            System.out.println("2. Back to Home Screen");

            int next = con.choose();

            if (next == 1) {
                continue;
            }

            if (next == 2) {
                return;
            }

            System.out.println("Invalid Input");
            con.doublePause();
        }
    }
}