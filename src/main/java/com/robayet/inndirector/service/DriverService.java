package com.robayet.inndirector.service;

import com.robayet.inndirector.model.DriverInfo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DriverService {
    public void addDriver(DriverInfo driverInfo){
        try {
            Connection connection = ConnectionSingleton.getConnection();
            Statement statement = connection.createStatement();
            //insert into driver value('jowel','011325235','bmw-i8');
            String query = "insert into driver value('" + driverInfo.getName() + "','" + driverInfo.getPhone() + "','" + driverInfo.getCar() + "');";
            statement.execute(query);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public List<DriverInfo> list(){
        List<DriverInfo> driverInfoList = new ArrayList<>();
        try {
            Connection connection = ConnectionSingleton.getConnection();
            Statement statement = connection.createStatement();
            String query = "select * from driver;";
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                String drivername = resultSet.getString("name");
                String driverNumber = resultSet.getString("phone");
                String carModel = resultSet.getString("car");

                DriverInfo driverInfo = new DriverInfo(drivername,driverNumber,carModel);
                driverInfoList.add(driverInfo);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return driverInfoList;
    }
}
