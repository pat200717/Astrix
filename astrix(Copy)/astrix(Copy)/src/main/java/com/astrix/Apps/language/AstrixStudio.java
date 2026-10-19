package com.astrix.Apps.language;

import java.util.ArrayList;
import java.util.Scanner;

import com.astrix.astrixModule.AstrixConsole;
import com.astrix.Apps.*;

public class AstrixStudio extends Apps {

    Scanner input = new Scanner(System.in);
    AstrixConsole con = new AstrixConsole();

    public AstrixStudio() {
        super(false);
    }

    @Override
    public String getName() {
        return "Astrix Studio";
    }

    @Override
    public String creatorName() {
        return "Jhon Faith P. Cañon";
    }

    @Override
    public double sizeFile() {
        return 15.5;
    }

    @Override
    public String version() {
        return "1.15.0 Alpha";
    }

    @Override
    public String description() {
        return "Astrix Studio is a simple code editor for the Astrix programming language. It allows users to write, edit, and run Astrix programs in an easy-to-use console environment.";
    }

    @Override
    public String getCode() {
        return "ALang";
    }

    @Override
    public void run() {

        con.clear();

        con.title("ASTRIX STUDIO");

        System.out.println("Write your Astrix program.");
        System.out.println("Type RUN to execute.");
        System.out.println();

        ArrayList<String> code = new ArrayList<>();

        while (true) {

            System.out.print(">>> ");

            String line = input.nextLine();

            if (line.equalsIgnoreCase("RUN")) {
                break;
            }

            code.add(line);
        }

        StringBuilder program = new StringBuilder();

        for (String line : code) {
            program.append(line).append("\n");
        }

        Interpreter interpreter = new Interpreter();

        interpreter.run(program.toString());

        con.pause();
    }
}