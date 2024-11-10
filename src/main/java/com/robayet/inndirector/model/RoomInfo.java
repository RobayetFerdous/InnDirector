package com.robayet.inndirector.model;

public class RoomInfo {
    private int number;
    private String status;
    private double price;
    private String bed;

    public RoomInfo(int number, String status, double price, String bed) {
        this.number = number;
        this.status = status;
        this.price = price;
        this.bed = bed;
    }

    public RoomInfo(int number, String status) {
        this.number = number;
        this.status=status;
    }


    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getBed() {
        return bed;
    }

    public void setBed(String bed) {
        this.bed = bed;
    }
}
