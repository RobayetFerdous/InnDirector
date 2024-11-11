package com.robayet.inndirector.Controller;

import com.robayet.inndirector.Main;
import com.robayet.inndirector.model.RoomInfo;
import com.robayet.inndirector.service.RoomService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class AddRoomController {
    @FXML
    public void clickNewRoom() {
        Main.changeScene("addRoom");
    }
    @FXML
    void clickNewEmployee(ActionEvent event) {
        Main.changeScene("addEmployee");
    }
    @FXML
    void clickViewRoom() {
        Main.changeScene("viewRoomAsAdmin");
    }
    @FXML
    void clickLogout(ActionEvent event) {
        Main.changeScene("login");
    }
    @FXML
    private TextField bedType;

    @FXML
    private TextField cleaningStatus;

    @FXML
    private TextField priceTextField;

    @FXML
    private TextField roomNumber;

    private ObservableList<RoomInfo> roomInfoObservableList;
    @FXML
    void clickAddRoom(ActionEvent event) {
        int number = Integer.parseInt(roomNumber.getText());
        String status = cleaningStatus.getText();
        double price = Double.parseDouble(priceTextField.getText());
        String bed = bedType.getText();

        RoomService roomService = new RoomService();
        roomService.addRoom(new RoomInfo(number,status,price,bed));

        System.out.println("Room added");

        roomInfoObservableList = FXCollections.observableArrayList();
        roomInfoObservableList.clear();
        roomInfoObservableList.addAll(roomService.list());

        roomNumber.clear();
        cleaningStatus.clear();
        priceTextField.clear();
        bedType.clear();
    }
}
