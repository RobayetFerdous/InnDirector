package com.robayet.inndirector.Controller;

import com.robayet.inndirector.Main;
import com.robayet.inndirector.model.RoomInfo;
import com.robayet.inndirector.service.DateAndTimeService;
import com.robayet.inndirector.service.RoomService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class CheckOutController implements Initializable {
    @FXML
    public void clickLogout(){
        Main.changeScene("login");
    }
    @FXML
    public void clickNewCustomer(){
        Main.changeScene("newCustomerForm");
    }
    @FXML
    public void clickRoom(){
        Main.changeScene("viewRoom");
    }
    @FXML
    public void clickCustomerInfo(){
        Main.changeScene("customerInfo");
    }
    @FXML
    private ChoiceBox<Integer> roomCoiceBox;
    @FXML
    private Label dateTextField;
    @FXML
    void clickCheckOut(ActionEvent event) {

    }
    private ObservableList<Integer> integerObservableList;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        DateAndTimeService dateAndTimeService = new DateAndTimeService();
        String date = dateAndTimeService.getCurrentDataAndTime();

        dateTextField.setText(date);

        //choice box
        RoomService roomService = new RoomService();
        List<RoomInfo> roomInfoList = roomService.list();

        List<Integer> roomNumbers = new ArrayList<>();
        for (RoomInfo room : roomInfoList){
            roomNumbers.add(room.getNumber());
        }

        integerObservableList = FXCollections.observableArrayList();
        integerObservableList.addAll(roomNumbers);
        roomCoiceBox.setItems(integerObservableList);

    }
}
