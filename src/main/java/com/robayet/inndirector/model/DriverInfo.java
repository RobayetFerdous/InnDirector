package com.robayet.inndirector.model;

public class DriverInfo {
    private String name;
    private String phone;
    private String car;

    public DriverInfo(String name, String phone, String car) {
        this.name = name;
        this.phone = phone;
        this.car = car;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCar() {
        return car;
    }

    public void setCar(String car) {
        this.car = car;
    }
}
