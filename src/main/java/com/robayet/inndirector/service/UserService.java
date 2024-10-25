package com.robayet.inndirector.service;

import com.robayet.inndirector.model.UserInfo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

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
    public List<UserInfo> list(){
        List<UserInfo> userInfoList = new ArrayList<>();
        try {
            Connection connection = ConnectionSingleton.getConnection();
            Statement statement = connection.createStatement();
            String query = "SELECT * FROM signup;";
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()){
                String username = resultSet.getString("username");
                String password = resultSet.getString("password");

                UserInfo userInfo = new UserInfo(username, password);
                userInfoList.add(userInfo);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return userInfoList;
    }
}
