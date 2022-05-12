package com.revature.whatdadogdoin.services;

import com.revature.whatdadogdoin.daos.HouseHoldDao;
import com.revature.whatdadogdoin.models.HouseHoldAccount;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class HouseHoldServicesTestSuite {

    HouseHoldServices sut;
    HouseHoldDao tut;

    @BeforeEach
    public void testPrep(){
        sut = new HouseHoldServices();
    }

    @BeforeEach
    public void testPrep2(){
        tut = new HouseHoldDao();
    }

    @Test
    public void test_validateInput_givenValidAccount_returnTrue(){

        HouseHoldAccount account = new HouseHoldAccount("valid", "valid", "valid", "valid");

        boolean actualResult = sut.validateHouseHoldAccount(account);

        Assertions.assertTrue(actualResult);

    }

    @Test
    public void test_create_givenValidUser_returnsAccount(){

        HouseHoldAccount account = new HouseHoldAccount("valid", "valid", "valid", "valid");

        HouseHoldAccount actualAccount = tut.create(account);

        Assertions.assertEquals("valid", actualAccount.getHouseHoldUsername());
        Assertions.assertEquals("valid", actualAccount.getHouseHoldName());
        Assertions.assertEquals("valid", actualAccount.getPassWord());
        Assertions.assertEquals("valid", actualAccount.getLocation());

    }

}
