package com.revature.whatdadogdoin.menus;

import com.revature.whatdadogdoin.exceptions.InvalidRequestException;
import com.revature.whatdadogdoin.exceptions.ResourcePersistenceException;
import com.revature.whatdadogdoin.models.HouseHoldAccount;
import com.revature.whatdadogdoin.services.HouseHoldServices;
import com.revature.whatdadogdoin.util.logging.Logger;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class RegisterMenu extends Menu{

    private HouseHoldServices houseHoldServices = new HouseHoldServices();
    private final Logger logger = Logger.getLogger(true);

    public RegisterMenu(BufferedReader terminalReader) {
        super("Register", "/register", terminalReader);
    }

    @Override
    public void render() throws Exception {
        System.out.println("Choose a username for the household?");
        String houseHoldUserName = terminalReader.readLine();

        System.out.println("What is the name of your household?");
        String houseHoldName = terminalReader.readLine();

        System.out.println("What is your password?");
        String passWord = terminalReader.readLine();

        System.out.println("Re-enter password");
        String passwordCheck = terminalReader.readLine();

        System.out.println("What is your location?");
        String location = terminalReader.readLine();


        if (!passWord.equals(passwordCheck)) {
            System.out.println("Passwords don't match");
            return;
        }


        HouseHoldAccount newHouseHoldAccount = new HouseHoldAccount(houseHoldUserName, houseHoldName, passWord, location);

        try{
            houseHoldServices.registerHouseHoldAccount(newHouseHoldAccount);
        } catch (InvalidRequestException | ResourcePersistenceException e){
            logger.warn(e.getMessage());
        }



    }
}
