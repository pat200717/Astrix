package com.astrix.astrixModule;

import com.astrix.Apps.*;
import com.astrix.astrixModule.*;

import java.util.ArrayList;

public class AstrixManager {
    AstrixConsole con = new AstrixConsole();
    AppManager appManager = new AppManager();
    AccountManager accManager = new AccountManager();
    
    ArrayList <String> homeMenu = new ArrayList<>();
    ArrayList <Apps> appList = new ArrayList<>();
    
    public ArrayList<Apps> getApps() {
        return appList;
    }
    
    public AstrixManager() {
        homeMenu.add("Apps");
        homeMenu.add("Astrix Store");
        homeMenu.add("Settings");
        homeMenu.add("Shutdown");
    }
    
    public void run() {
        con.title("ASTRIX");
        con.lineSpacing(10);
        
        con.loadingBar();
        
        homeScreen();
    }
    
    public void homeScreen() {
        
        while (true) {
            con.clear();
            con.title("ASTRIX HOME SCREEN");
            con.showList(homeMenu);
            int select = con.choose();
            
            if (select < 1 || select > homeMenu.size()) {
                con.doublePause();
                continue;
            }
                
            switch (homeMenu.get(select - 1)) {
                case "Apps":
                apps();
                break;
                
                case "Astrix Store":
                astrixStore();
                break;
                
                case "Settings":
                settings();
                break;
                
                case "Shutdown":
                shutdown();
                break;
                
            }
        }
    }
    
    public void installApp(int choice) {

        ArrayList<Apps> storeApps = appManager.getApps();

        if (choice < 1 || choice > storeApps.size()) {
            System.out.println("Invalid app.");
            return;
        }

        Apps app = storeApps.get(choice - 1);

        if (app.isInstalled()) {
            System.out.println(app.getName() + " is already installed.");
            return;
        }

        app.install();

        appList.add(app);

        System.out.println(app.getName() + " installed!");
    }
    
    public void apps() {
        con.clear();
        con.title("APPS");
        
        if (appList.isEmpty()) {
            System.out.println(" NO APPS INSTALLED! ");
            con.doublePause();
            return;
        } else {
            for (int i = 0; i < appList.size(); i++) {
                System.out.println((i + 1) + ". " + appList.get(i).getName());
            }
        }
        con.lineSpacing(2);
        System.out.print("0. Back");
        
        int select = con.choose();
        
        if (select == 0 ) {
            homeScreen();
            return;
        }
        
        openApp(select);
    }
    
    public void openApp(int choice) {

        if (appList.isEmpty()) {
            System.out.println("No Apps Installed Yet.");
            return;
        }

        if (choice < 1 || choice > appList.size()) {
            System.out.println("Invalid app.");
            return;
        }

        Apps app = appList.get(choice - 1);

        app.run();
    }
    
    
    public void astrixStore() {
        con.clear();
        con.title("ASTRIX STORE");
        
        appManager.showApps();
        
        con.lineSpacing(2);
        System.out.println("0. Back");
        int select = con.choose();
        
        if (select == 0) {
            homeScreen();
            return;
        }
        
        if (select < 1 || select > appManager.getApps().size()) {
            System.out.println("Invalid Input");
            con.doublePause();
            return;
        }
        
        Apps app = appManager.getApps().get(select - 1);
        String code = app.getCode();
        
        appManager.showAppDetails(code);
        
        if (app.isInstalled() && !appList.contains(app)) {
            appList.add(app);
        }
    }
    
    public void settings() {
        con.clear();
        con.title("SETTINGS");
        
        System.out.println("1. Account");
        System.out.println("2. About");
        System.out.println("3. Back");
        
        int select = con.choose();
        
        if (select < 1 || select > 3) {
            System.out.println("Invalid Input");
            settings(); 
            return;
        } else if (select == 1 ) {
            accManager.run();
            return;
        } else if (select == 2 ) {
            about();
            return;
        } else if (select == 3 ) {
            homeScreen();
        }
    }
    
    public void about() {
        con.clear();
        con.title("ABOUT ASTRIX");
        System.out.println("Company Name : Astrix");
        System.out.println("Founder : Jhon Faith P. Cañon");
         
        con.lineSpacing(2);
        con.doublePause();
        con.clear();
        
        con.title("MEMBER $ ROLES");
        System.out.println("Meet our Seniors & Junior Programmers");
        System.out.println("Senior Head Java Programmer : Jhon Faith P. Cañon");
        System.out.println("Senior Java Programmer : Luis R. Cabanos");
        System.out.println("Senior Java Programmer : Patricia M. Velasco");
        con.lineSpacing(2);
        
        System.out.println("Junior Java Programmer : Jerry D. Tagle Jr.");
        System.out.println("Junior Java Programmer : John Rafael V. Esquillo");
        
        con.lineSpacing(2);
        con.pause();
        con.clear();
        
        con.title("DESCRIPTION");
        System.out.println("You may have seen and used countless devices in your life. But have you ever used a cellphone made entirely in Java?");
        System.out.println();
        System.out.println("Welcome to Astrix, where we bring the concept of a functional cellphone into the world of programming. Today, we will demonstrate our Java-based cellphone, featuring a sign-in system, settings, games, and application.");
        System.out.println();
        System.out.println("This project shows how Java can be used to combine different programming concepts and turn them into an interactive and functional application. So, without further ado, let us explore what Astrix has to offer. ");
        
        con.pause();
        return;
    }
    
    public void shutdown() {
        con.clear();
        con.title("SHUTTING DOWN");
        con.lineSpacing(10);
        
        con.loadingBar();
        
        con.clear();
    }
}
