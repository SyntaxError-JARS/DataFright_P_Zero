package com.revature.whatdadogdoin.util;

import com.revature.whatdadogdoin.menus.RegisterMenu;
import com.revature.whatdadogdoin.menus.WelcomeMenu;
import com.revature.whatdadogdoin.services.HouseHoldServices;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class AppState {

    private static boolean isRunning;
    private WelcomeMenu welcomeMenu;
    private RegisterMenu registerMenu;

    //private final MenuRouter router;

    public AppState() {
        System.out.println("Generating instance of AppState");
        isRunning = true;
        BufferedReader terminalReader = new BufferedReader(new InputStreamReader(System.in));
        HouseHoldServices houseHoldServices = new HouseHoldServices();

        this.welcomeMenu = new WelcomeMenu(terminalReader, houseHoldServices);
        this.registerMenu = new RegisterMenu(terminalReader);

    }

    public void startup(){
        try {
            while (isRunning) {
                System.out.println("App successfully started");
                welcomeMenu.render();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void shutdown(){
        isRunning = false;
        System.out.println("App shutting down");
    }

}
