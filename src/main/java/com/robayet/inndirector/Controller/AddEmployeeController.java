package com.robayet.inndirector.Controller;

import com.robayet.inndirector.Main;
import com.robayet.inndirector.model.DriverInfo;
import com.robayet.inndirector.service.DriverService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class AddEmployeeController {

    @FXML
    private TextField carField;

    @FXML
    private TextField nameField;

    @FXML
    private TextField phoneField;

    @FXML
    public void clickLogout() {
        Main.changeScene("login");
    }

    @FXML
    public void clickNewRoom() {
        Main.changeScene("addRoom");
    }

    @FXML
    void clickViewRoom() {
        Main.changeScene("viewRoomAsAdmin");
    }

    private ObservableList<DriverInfo> driverInfoObservableList;
    @FXML
    void clickadd(ActionEvent event) {
        String driverName = nameField.getText();
        String driverNumber = phoneField.getText();
        String carModel = carField.getText();

        DriverService driverService = new DriverService();
        driverService.addDriver(new DriverInfo(driverName,driverNumber,carModel));

        System.out.println("Driver added");

        driverInfoObservableList = FXCollections.observableArrayList();
        driverInfoObservableList.clear();
        driverInfoObservableList.addAll(driverService.list());

        carField.clear();
        nameField.clear();
        phoneField.clear();
    }

}
