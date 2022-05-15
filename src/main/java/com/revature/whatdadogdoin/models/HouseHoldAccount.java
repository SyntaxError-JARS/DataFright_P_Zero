package com.revature.whatdadogdoin.models;

public class HouseHoldAccount {

    private String houseHoldUsername;
    private String houseHoldName;
    private String passWord;
    private String location;

    public HouseHoldAccount(){
        super();
    }

    public HouseHoldAccount(String houseHoldUsername, String houseHoldName, String passWord, String location){
        super();
        this.houseHoldUsername = houseHoldUsername;
        this.houseHoldName = houseHoldName;
        this.passWord = passWord;
        this.location = location;

    }

    public String getHouseHoldUsername() { return houseHoldUsername; }

    public void setHouseHoldUsername(String houseHoldUsername) { this.houseHoldUsername = houseHoldUsername; }

    public String getHouseHoldName(){ return houseHoldName;}

    public void setHouseHoldName(String houseHoldName) { this.houseHoldName = houseHoldName; }

    public String getPassWord() {return passWord;}

    public void setPassWord(String passWord) { this.passWord = passWord; }

    public String getLocation() {return location;}

    public void setLocation(String location) { this.location = location; }



    @Override
    public String toString() {
        return "HouseHoldAccount{" +
                "Username = '" + houseHoldUsername + '\'' +
                ", Household Name = '" + houseHoldName + '\'' +
                ", Password = '" + "*********" + '\'' +
                ", Location = '" + location + '\'' +
                '}';
    }



}
