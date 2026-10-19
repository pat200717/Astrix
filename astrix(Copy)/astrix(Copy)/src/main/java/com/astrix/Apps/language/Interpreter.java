package com.astrix.Apps.language;

import java.util.HashMap;

public class Interpreter {
    
    HashMap<String, String> variables = new HashMap<>();
    
    public void clear() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
    
    public void line() {
        int width = 72;
        
        for (int i = 0; i < width; i++) {
            System.out.print("=");
        }
        
        System.out.print("\n");
    }
    
    public void title(String text) {
        int width = 72;
        int space = (width - text.length()) / 2;
        
        line();
        
        for (int i = 0; i < space; i++) {
            System.out.print(" ");
        }
        
        System.out.print(text + "\n");
        line();
    }
    
    public void run(String code) {
        
        String[] lines = code.split("\\n");
        
        boolean hasError = false;
        
        int lineNumber = 1;
        
        // ERROR CHECKING
        for (String line : lines) {
            
            if (checkError(lineNumber, line)) {
                hasError = true;
            }
            
            lineNumber++;
        }
        
        // STOP IF THERE ARE ERRORS
        if (hasError) {
            System.out.println();
            System.out.println("Astrix : Compilation failed.");
            return;
        }
        
        // EXECUTION
        clear();
        title("COMPILER");
        
        lineNumber = 1;
        
        for (String line : lines) {
            
            execute(lineNumber, line);
            
            lineNumber++;
        }
    }
    
    public boolean checkError(int num, String line) {
        
        line = line.trim();
        
        if (line.isEmpty()) {
            return false;
        }
        
        if (line.startsWith("out ")) {
            
            String value = line.substring(4).trim();
            
            if (value.length() < 2 ||
                !value.startsWith("\"") ||
                !value.endsWith("\"")) {
                    
                System.out.println(
                    "Astrix ERROR : Invalid OUT statement"
                );
                
                System.out.println(
                    num + " : " + line
                );
                
                return true;
            }
            
            return false;
        }
        
        System.out.println(
            "Astrix ERROR : Unknown Keyword!"
        );
        
        System.out.println(
            num + " : " + line
        );
        
        return true;
    }
    
    public void execute(int num, String line) {
        
        line = line.trim();
        
        if (line.isEmpty()) {
            return;
        }
        
        if (line.startsWith("out ")) {
            
            String value = line.substring(4).trim();
            
            value = value.substring(1, value.length() - 1);
            
            System.out.println(value);
        }
    }
}