package com.robayet.inndirector.service;

import com.robayet.inndirector.model.UserInfo;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class UserService {
    public void signup(UserInfo userInfo){
        try {
            Connection connection = ConnectionSingleton.getConnection();
            Statement statement = connection.createStatement();
            String query = "INSERT INTO signup VALUE('" + userInfo.getUsername() + "'," + userInfo.getPassword() + ");";
            statement.execute(query);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
