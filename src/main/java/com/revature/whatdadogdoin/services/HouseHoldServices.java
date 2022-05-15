package com.revature.whatdadogdoin.services;

import com.revature.whatdadogdoin.daos.HouseHoldDao;
import com.revature.whatdadogdoin.exceptions.InvalidRequestException;
import com.revature.whatdadogdoin.exceptions.ResourcePersistenceException;
import com.revature.whatdadogdoin.models.HouseHoldAccount;
import com.revature.whatdadogdoin.excetpion.AuthenticationException;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class HouseHoldServices {

    private HouseHoldDao houseHoldDao = new HouseHoldDao();

    public void readHouseHold() {
        System.out.println("Begin reading accounts in our file database");

        HouseHoldAccount[] accounts = new HouseHoldAccount[0];
        try {
            accounts = houseHoldDao.findAll();
            System.out.println("All trainers have been found here are the results: \n");


            for (int i = 0; i < accounts.length; i++) {
                HouseHoldAccount account = accounts[i];
                if (account != null){
                    System.out.println(account.toString());
                }
            }

        } catch (IOException | NullPointerException e) {
            e.printStackTrace();
        }

    }

    public boolean registerHouseHoldAccount(HouseHoldAccount newHouseHoldAccount){
        if(!validateHouseHoldAccount(newHouseHoldAccount)){
            System.out.println("User was not validated");
            throw new InvalidRequestException("User input was not validated, either empty string or null values");
        }

        HouseHoldAccount persistedHouseHoldAccount = houseHoldDao.create(newHouseHoldAccount);

        if (persistedHouseHoldAccount == null){
            throw new ResourcePersistenceException("Trainer was not persisted to the database upon registration");
        }

        return true;
    }

    public boolean validateHouseHoldAccount(HouseHoldAccount newHouseHoldAccount){
        if(newHouseHoldAccount == null) return false;
        if (newHouseHoldAccount.getHouseHoldUsername() == null || newHouseHoldAccount.getHouseHoldUsername().trim().equals("")) return false;
        if (newHouseHoldAccount.getHouseHoldName() == null || newHouseHoldAccount.getHouseHoldName().trim().equals("")) return false;
        if (newHouseHoldAccount.getPassWord() == null || newHouseHoldAccount.getPassWord().trim().equals("")) return false;
        //if (newHouseHoldAccount.getLocation() == null || newHouseHoldAccount.getLocation().trim().equals("")) // return false; dont need to check if locaion is null, it can be null

        return true;
    }

    public HouseHoldAccount authenticateAccount(String username, String password) throws AuthenticationException {

        if (password == null || password.trim().equals("") || username == null || username.trim().equals("")) {
            throw new InvalidRequestException("Either username or password is an invalid entry. Please try logging in again");
        }

        HouseHoldAccount authenticatedAccount = houseHoldDao.authenticateAccount(username, password);

        if (authenticatedAccount == null){
            throw new AuthenticationException("Unauthenticated user, information provided was not consistent with our database.");
        }

        return authenticatedAccount;
    }
}
