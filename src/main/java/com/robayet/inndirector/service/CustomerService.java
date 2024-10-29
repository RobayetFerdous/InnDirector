package com.robayet.inndirector.service;

import com.robayet.inndirector.model.CustomerInfo;
import com.robayet.inndirector.model.UserInfo;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

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
}
