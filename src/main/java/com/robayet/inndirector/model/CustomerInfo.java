package com.robayet.inndirector.model;

public class CustomerInfo {
    private String name;
    private String number;
    private String gender;
    private String date;

    public CustomerInfo(String name, String number, String gender, String date) {
        this.name = name;
        this.number = number;
        this.gender = gender;
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
