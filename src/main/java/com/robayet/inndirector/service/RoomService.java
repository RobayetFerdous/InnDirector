package com.robayet.inndirector.service;

import com.robayet.inndirector.model.CustomerInfo;
import com.robayet.inndirector.model.RoomInfo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class RoomService {
    public void addRoom(RoomInfo roomInfo){
        try {
            Connection connection = ConnectionSingleton.getConnection();
            Statement statement = connection.createStatement();
            String query = "INSERT INTO room VALUE(" + roomInfo.getNumber() + ",'" + roomInfo.getStatus() + "'," + roomInfo.getPrice() + ",'" + roomInfo.getBed() + "');";
            statement.execute(query);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public List<RoomInfo> list(){
        List<RoomInfo> roomInfoList = new ArrayList<>();
        try {
            Connection connection = ConnectionSingleton.getConnection();
            Statement statement = connection.createStatement();
            String query = "SELECT * FROM room;";
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()){
                int number = Integer.parseInt(resultSet.getString("number"));
                String status = resultSet.getString("status");
                double price = Double.parseDouble(resultSet.getString("price"));
                String bed = resultSet.getString("bed");

                RoomInfo roomInfo = new RoomInfo(number,status,price,bed);
                roomInfoList.add(roomInfo);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return roomInfoList;
    }
    public void updateRoom(RoomInfo roomInfo) {
        try {
            Connection connection = ConnectionSingleton.getConnection();
            Statement statement = connection.createStatement();
            //UPDATE room SET status = 'dirty' WHERE number = 102;
            String query = "UPDATE room SET status = '"+ roomInfo.getStatus() +"' WHERE number = "+ roomInfo.getNumber() +";";
            statement.execute(query);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public void adminUpdateRoom(RoomInfo roomInfo) {
        try {
            Connection connection = ConnectionSingleton.getConnection();
            Statement statement = connection.createStatement();
            //update room set status='dirty',price=1500,bed='double' where number=101;
            String query = "UPDATE room SET status = '"+ roomInfo.getStatus() +"', price = "+ roomInfo.getPrice() + ", bed ='"+ roomInfo.getBed() +"' WHERE number = "+ roomInfo.getNumber() +";";
            statement.execute(query);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
