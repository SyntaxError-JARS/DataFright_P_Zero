package com.revature.whatdadogdoin.services;

import com.revature.whatdadogdoin.daos.HouseHoldDao;
import com.revature.whatdadogdoin.models.HouseHoldAccount;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class HouseHoldAccountUpdateTestSuite {

    HouseHoldDao sut;

    @BeforeEach
    public void testPrep() {
        sut = new HouseHoldDao();
    }

    @Test
    public void testValidUpdateToHouseHoldAccount_returnTrue() {

        HouseHoldAccount actualResults = sut.returnUpdate("name", "test", "test_test");
        System.out.println(actualResults);

    }

}
