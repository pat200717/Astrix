package com.astrix.astrixModule;

import java.util.HashMap;
import java.util.Scanner;

public class AccountManager {

    AstrixConsole con = new AstrixConsole();

    private HashMap<String, String> users = new HashMap<>();
    
    public Scanner sc = new Scanner(System.in);
    
    public void run() {
        accountMenu();
    }

    public void accountMenu() {

        while (true) {

            con.clear();
            con.title("ASTRIX ACCOUNT");

            System.out.println("1. Sign Up");
            System.out.println("2. Sign In");
            System.out.println("3. Back");

            int select = con.choose();

            if (select < 1 || select > 3) {
                System.out.println("Invalid Input");
                con.doublePause();
                continue;
            }

            switch (select) {

                case 1:
                    signUp();
                    break;

                case 2:
                    signIn();
                    break;

                case 3:
                    return;
            }
        }
    }

    public void signUp() {

        con.clear();
        con.title("SIGN UP");

        System.out.print("Username : ");
        String username = sc.nextLine();

        if (users.containsKey(username)) {
            System.out.println("Username already exists!");
            con.doublePause();
            return;
        }

        System.out.print("Password : ");
        String password = sc.nextLine();

        users.put(username, password);

        System.out.println();
        System.out.println("Account created successfully!");
        con.doublePause();
    }

    public void signIn() {

        con.clear();
        con.title("SIGN IN");

        System.out.print("Username : ");
        String username = sc.nextLine();

        System.out.print("Password : ");
        String password = sc.nextLine();

        if (users.containsKey(username)
                && users.get(username).equals(password)) {

            System.out.println();
            System.out.println("Login successful!");
            System.out.println("Welcome, " + username + "!");

        } else {

            System.out.println();
            System.out.println("Invalid username or password.");
        }

        con.doublePause();
    }
}