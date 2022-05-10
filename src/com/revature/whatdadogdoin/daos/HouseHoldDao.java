package com.revature.whatdadogdoin.daos;

import com.revature.whatdadogdoin.models.HouseHoldAccount;
import com.revature.whatdadogdoin.util.ConnectionFactory;

import java.io.*;
import java.sql.*;

public class HouseHoldDao implements Crundable<HouseHoldAccount> {


    @Override
    public HouseHoldAccount create(HouseHoldAccount newHouseHoldAccount) {
        System.out.println(newHouseHoldAccount);

        try (Connection conn = ConnectionFactory.getInstance().getConnection();) {

            String sql = "insert into household_account values (?, ?, ?, ?)";

            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, newHouseHoldAccount.getHouseHoldUsername());
            ps.setString(2, newHouseHoldAccount.getHouseHoldName());
            ps.setString(3, newHouseHoldAccount.getPassWord());
            ps.setString(4, newHouseHoldAccount.getLocation());

            int checkInsert = ps.executeUpdate();

            if (checkInsert == 0){
                throw new RuntimeException();
            }

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return newHouseHoldAccount;
    }

    @Override
    public HouseHoldAccount[] findAll() throws IOException {


        HouseHoldAccount[] accounts = new HouseHoldAccount[10];

        int index = 0;

        try (Connection conn = ConnectionFactory.getInstance().getConnection();) {

            String sql = "select * from household_account";
            Statement s = conn.createStatement();

            ResultSet rs = s.executeQuery(sql);

            while (rs.next()) {

                HouseHoldAccount houseHoldAccount = new HouseHoldAccount();

                houseHoldAccount.setHouseHoldUsername(rs.getString("household_username"));
                houseHoldAccount.setHouseHoldName(rs.getString("household_name"));
                houseHoldAccount.setPassWord(rs.getString("password"));
                houseHoldAccount.setLocation(rs.getString("location"));

                System.out.println("Inserted account into index " + index);
                accounts[index] = houseHoldAccount;
                index++;
                System.out.println("Going to the next line for our following index");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }


        System.out.println("returning account info");
        return accounts;
    }

    @Override
    public HouseHoldAccount findById(String username) {

        try(Connection conn = ConnectionFactory.getInstance().getConnection();){

            String sql = "select * from household_account where household_username = ?";

            PreparedStatement ps = conn.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            HouseHoldAccount houseHoldAccount = new HouseHoldAccount();

            houseHoldAccount.setHouseHoldUsername(rs.getString("household_username"));
            houseHoldAccount.setHouseHoldName(rs.getString("household_name"));
            houseHoldAccount.setPassWord(rs.getString("password"));
            houseHoldAccount.setLocation(rs.getString("location"));

            return houseHoldAccount;

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }


    }

    @Override
    public boolean update(HouseHoldAccount updatedObj) {
        return false;
    }

    @Override
    public boolean delete(String id) {
        return false;
    }
}
