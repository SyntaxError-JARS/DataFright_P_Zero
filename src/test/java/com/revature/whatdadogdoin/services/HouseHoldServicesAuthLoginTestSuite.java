package com.revature.whatdadogdoin.services;

import com.revature.whatdadogdoin.daos.HouseHoldDao;
import com.revature.whatdadogdoin.models.HouseHoldAccount;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.naming.AuthenticationException;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class HouseHoldServicesAuthLoginTestSuite {

    HouseHoldServices sut;
    HouseHoldDao tut;

    @BeforeEach
    public void testPrep(){
        sut = new HouseHoldServices();
        tut = new HouseHoldDao();
    }

    @Test
    public void testValidPasswordUsernameLogin_returnString() throws AuthenticationException {

        HouseHoldAccount actualResult = tut.authenticateAccount("mattman", "pasw0rd");

        System.out.println("");
        System.out.println(actualResult);
    }

}
