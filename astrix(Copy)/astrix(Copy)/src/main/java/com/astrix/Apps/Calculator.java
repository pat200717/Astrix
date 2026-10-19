package com.astrix.Apps;

import com.astrix.astrixModule.AstrixConsole;

public class Calculator extends Apps {

    AstrixConsole con = new AstrixConsole();

    public Calculator() {
        super(false);
    }

    @Override
    public String getName() {
        return "Calculator";
    }

    @Override
    public String creatorName() {
        return "Jerry D. Tagle";
    }

    @Override
    public double sizeFile() {
        return 18;
    }

    @Override
    public String version() {
        return "1.0";
    }

    @Override
    public String description() {
        return "The Calculator is a Java module that performs basic operations such as addition, subtraction, multiplication, and division. The user chooses an operation, enters two numbers, and the program displays the result. It also has Back and Exit options for easy navigation.";
    }

    @Override
    public String getCode() {
        return "calc";
    }

    @Override
    public void run() {

        while (true) {

            con.clear();
            con.title("CALCULATOR");

            System.out.println("1. Addition");
            System.out.println("2. Subtraction");
            System.out.println("3. Multiplication");
            System.out.println("4. Division");
            System.out.println("5. Back to Home Screen");

            int choice = con.choose();

            if (choice == 5) {
                return;
            }

            if (choice < 1 || choice > 5) {
                System.out.println("Invalid Input");
                con.doublePause();
                continue;
            }

            con.clear();
            con.title("CALCULATOR");

            System.out.println("Enter first number:");
            int num1 = con.choose();

            System.out.println("Enter second number:");
            int num2 = con.choose();

            int result = 0;

            switch (choice) {

                case 1:
                    result = num1 + num2;
                    break;

                case 2:
                    result = num1 - num2;
                    break;

                case 3:
                    result = num1 * num2;
                    break;

                case 4:

                    if (num2 == 0) {
                        System.out.println();
                        System.out.println("Cannot divide by zero!");
                        con.doublePause();
                        continue;
                    }

                    result = num1 / num2;
                    break;
            }

            con.clear();
            con.title("CALCULATOR");

            System.out.println("First Number  : " + num1);
            System.out.println("Second Number : " + num2);
            System.out.println("Result        : " + result);

            con.lineSpacing(2);

            System.out.println("1. Calculate Again");
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