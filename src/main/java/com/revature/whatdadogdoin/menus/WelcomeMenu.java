package com.revature.whatdadogdoin.menus;

import com.revature.whatdadogdoin.models.HouseHoldAccount;
import com.revature.whatdadogdoin.services.HouseHoldServices;
import com.revature.whatdadogdoin.menus.RegisterMenu;
import com.revature.whatdadogdoin.util.logging.Logger;

import java.io.BufferedReader;
import java.io.IOException;

import static com.revature.whatdadogdoin.util.AppState.shutdown;


public class WelcomeMenu extends Menu{

    private HouseHoldServices houseHoldServices;
    private RegisterMenu registerMenu;
    private final Logger logger = Logger.getLogger(true);

    public WelcomeMenu(BufferedReader terminalReader, HouseHoldServices houseHoldServices) {
        super("Welcome","/welcome", terminalReader);
        this.houseHoldServices = houseHoldServices;
        this.registerMenu = new RegisterMenu(terminalReader);
    }

    public void render() throws Exception {

        String welcome = "Welcome to the App!";
        String option1 = "1) Login";
        String option2 = "2) Register";
        String option3 = "3) Add pet";
        String option4 = "4) View all accounts";
        String option5 = "5) Exit the app";


        System.out.printf("%s \n %s \n %s \n %s \n %s \n %s", welcome, option1, option2, option3, option4, option5).println();


        System.out.print("\n Select number from above\n >");
        String userSelection = terminalReader.readLine();

        switch (userSelection) {
            case "1":
                logger.info("User has selected login...");
                break;
            case "2":
                System.out.println("User has selected register...");
                registerMenu.render();
                break;
            case "3":
                System.out.println("User has selected Add pet...");
                break;
            case "4":
                System.out.println("User has selected view accounts...");
                houseHoldServices.readHouseHold();
                break;
            case "5":
                System.out.println("User has selected exit...");
                shutdown();
                logger.info("Application shutting down");
                break;
            default:
                System.out.println("No valid user input provide");
                break;
        }


    }

}


