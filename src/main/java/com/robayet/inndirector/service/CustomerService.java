package com.robayet.inndirector.service;

import com.robayet.inndirector.model.CustomerInfo;
import com.robayet.inndirector.model.UserInfo;
import javafx.collections.ObservableList;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CustomerService {
    public void addCustomer(CustomerInfo customerInfo){
        try {
            Connection connection = ConnectionSingleton.getConnection();
            Statement statement = connection.createStatement();
            String query = "INSERT INTO customer VALUE('" + customerInfo.getName() + "','" + customerInfo.getNumber() + "','" + customerInfo.getGender() + "','" + customerInfo.getDate() + "');";
            statement.execute(query);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public List<CustomerInfo> list(){
        List<CustomerInfo> customerInfoList = new ArrayList<>();
        try {
            Connection connection = ConnectionSingleton.getConnection();
            Statement statement = connection.createStatement();
            String query = "SELECT * FROM customer;";
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()){
                String name = resultSet.getString("name");
                String number = resultSet.getString("number");
                String gender = resultSet.getString("gender");
                String date = resultSet.getString("date");

                CustomerInfo customerInfo = new CustomerInfo(name,number,gender,date);
                customerInfoList.add(customerInfo);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return customerInfoList;
    }
}
