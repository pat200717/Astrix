package com.astrix.Apps;

import com.astrix.Apps.language.AstrixStudio;
import com.astrix.astrixModule.*;

import java.util.ArrayList;

public class AppManager {
    
    AstrixConsole con = new AstrixConsole();
    
    private ArrayList<Apps> apps = new ArrayList<>();
    
    public ArrayList <Apps> getApps() {
        return apps;
    }
    
    public AppManager() {
        apps.add(new Calculator());
        apps.add(new AstrixStudio());
        apps.add(new TicTacToe());
        apps.add(new RockPaperScissors());
        apps.add(new GuessTheNumber());
        apps.add(new LuckyCoin());
        apps.add(new PersonalityTest());
    }
    
    public int size() {
        return apps.size();
    }
    
    public String getName(int index) {
        return apps.get(index).getName();
    }
    
    public void showApps() {
        int i = 0;
        for (Apps app : apps)  {
            if (app.isInstalled()) {
                System.out.println("\033[32m" + (i + 1) + ". " + app.getName() + " [INSTALLED]\033[0m");
            } else {
                System.out.println((i + 1) + ". " + app.getName() + " [INSTALL]");
            }
            i++;
        }
    }
    
    public void showAppDetails(String code) {
        con.clear();
        
        for (Apps app : apps) {
            if (app.getCode().equals(code)) {
                con.title(app.getName());
                System.out.println("Creator : " + app.creatorName());
                System.out.println("App Size : " + app.sizeFile() + "mb");
                System.out.println("Version : " + app.version());
                System.out.println("Description : " + app.description());
                
                con.lineSpacing(2);
                
                System.out.println("1. Install");
                System.out.println("2. Back");
                
                int select = con.choose();
                
                if (select < 1 || select > 2) {
                    System.out.println("Invalid Input");
                    con.doublePause();
                    return;
                }
                
                if (select == 2) {
                    return;
                }
                
                if (select == 1) {
                    if (app.isInstalled()) {
                        System.out.println(app.getName() + " is already installed.");
                        con.doublePause();
                        return;
                    }
                    
                    con.clear();
                    
                    con.title(app.getName());
                    
                    con.installingBar(app.getName(), app.sizeFile());
                    
                    app.install();
                    
                    con.lineSpacing(2);
                    
                    System.out.println("1. Back");
                    
                    int choice = con.choose();
                    
                    if (choice < 1 || choice > 1) {
                        System.out.println("Invalid Input");
                        con.doublePause();
                        return;
                    }
                    
                    if (choice == 1) {
                        return;
                    }
                }
                
                return;
            }
        }
    }
    
    public void run(int choice) {
        apps.get(choice - 1).run();
    }
}