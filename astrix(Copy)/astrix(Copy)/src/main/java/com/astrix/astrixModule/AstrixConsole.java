package com.astrix.astrixModule;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.InputMismatchException;

public class AstrixConsole {
    
    Scanner input = new Scanner(System.in);
    
    public void title(String title) {
        line();
        textCenter(title + "\n");
        line();
    }
    
    public void clear() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
    
    public void pause() {
        System.out.println("\nPress Enter to Continue...");
        
        input.nextLine();
    }
    
    public void doublePause() {
        System.out.println("\nPress Enter to Continue...");
        
        input.nextLine();
        input.nextLine();
    }
    
    public void line() {
        int width = 72;
        
        for(int i = 0; i < width; i++) {
            System.out.print("=");
        }
        System.out.print("\n");
    }
    
    public void textCenter(String text) {
        int width = 72;
        int spaces = (width - text.length())/2;
        
        for(int i = 0; i < spaces; i++) {
            System.out.print(" ");
        }
        System.out.print(text);
    }
    
    public void lineSpacing(int space) {
        for (int i = 0; i < space; i++) {
            System.out.println(" ");
        }
    }
    
    public void showList(ArrayList<String> list) {
        for(int i = 0; i < list.size(); i++) {
            System.out.println((i+1) + ". "+ list.get(i));
        }
    }
    
    public int choose() {
        System.out.println();
        line();
        System.out.print("Choose : ");
        try {
            int select = input.nextInt();
            return select;
        } catch (InputMismatchException e) {
            System.out.println("Invalid Input");
            return 0;
        }
    }
    
    public void loadingBar() {
        int width = 70;
    
        System.out.print("[");
    
        for (int i = 0; i < width; i++) {
            System.out.print("█");
            
            try {
                Thread.sleep(30);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    
        System.out.println("]");
        System.out.println(" ".repeat(34) + "100%");
    }
    
    public void progressBar() {
        int width = 65;
        int lineWidth = 72;
    
        for (int i = 0; i <= 100; i++) {
            int progress = (i * width) / 100;
    
            System.out.print("[");
    
            for (int j = 0; j < width; j++) {
                if (j < progress) {
                    System.out.print("█");
                } else {
                    System.out.print(" ");
                }
            }
    
            System.out.printf("] %3d%%", i);
            System.out.flush();
    
            try {
                Thread.sleep(30);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
    
            if (i < 100) {
                System.out.print("\b".repeat(lineWidth));
            }
        }
    
        System.out.println();
    }
    
    public void installingBar(String appName, double size) {
        int width = 65;
    
        System.out.println("Installing " + appName + " (" + size + " MB)");
    
        for (int i = 0; i <= 100; i++) {
            int progress = (i * width) / 100;
    
            System.out.print("[");
    
            for (int j = 0; j < width; j++) {
                if (j < progress) {
                    System.out.print("█");
                } else {
                    System.out.print(" ");
                }
            }
    
            System.out.printf("] %3d%%", i);
            System.out.flush();
    
            if (i < 100) {
                System.out.print("\b".repeat(72));
            }
    
            try {
                long delay = 10L + (long)(size * 2);
    
                Thread.sleep(delay);
    
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    
        System.out.println();
        System.out.println(appName + " installed successfully!");
    }
}