package com.revature.whatdadogdoin.services;

import com.revature.whatdadogdoin.daos.HouseHoldDao;
import com.revature.whatdadogdoin.models.HouseHoldAccount;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

public class HouseHoldServicesTestSuite {

    HouseHoldServices sut;
    HouseHoldDao mockHouseHoldDoa;

    @BeforeEach
    public void testPrep(){
        mockHouseHoldDoa = mock(HouseHoldDao.class);
        sut = new HouseHoldServices();
    }


    @Test
    public void test_validateInput_givenValidAccount_returnTrue(){

        HouseHoldAccount account = new HouseHoldAccount("valid", "valid", "valid", "valid");

        boolean actualResult = sut.validateHouseHoldAccount(account);

        Assertions.assertTrue(actualResult);

    }

    @Test
    public void test_create_givenValidUser_returnsAccount(){

            HouseHoldAccount account = new HouseHoldAccount("test", "test", "test", "test");
        when(mockHouseHoldDoa.create(account)).thenReturn(account);

        HouseHoldAccount actualAccount = mockHouseHoldDoa.create(account);

        Assertions.assertEquals("test", actualAccount.getHouseHoldUsername());
        Assertions.assertEquals("test", actualAccount.getHouseHoldName());
        Assertions.assertEquals("test", actualAccount.getPassWord());
        Assertions.assertEquals("test", actualAccount.getLocation());
        verify(mockHouseHoldDoa, times(1)).create(account);

    }

}
