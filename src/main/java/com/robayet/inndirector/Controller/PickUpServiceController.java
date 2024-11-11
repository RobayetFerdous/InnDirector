package com.robayet.inndirector.Controller;

import com.robayet.inndirector.Main;
import com.robayet.inndirector.model.DriverInfo;
import com.robayet.inndirector.service.DriverService;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import java.net.URL;
import java.util.MissingFormatArgumentException;
import java.util.ResourceBundle;

public class PickUpServiceController implements Initializable {

    @FXML
    private TableColumn<DriverInfo, String> carColumn;

    @FXML
    private TableView<DriverInfo> driverTableView;

    @FXML
    private TableColumn<DriverInfo, String> nameColumn;

    @FXML
    private TableColumn<DriverInfo, String> phoneColumn;

    @FXML
    void clickCheckOut(ActionEvent event) {
        Main.changeScene("checkOut");
    }

    @FXML
    void clickCustomerInfo(ActionEvent event) {
        Main.changeScene("customerInfo");
    }

    @FXML
    void clickLogout(ActionEvent event) {
        Main.changeScene("login");
    }

    @FXML
    void clickNewCustomer(ActionEvent event) {
        Main.changeScene("addCustomer");
    }

    @FXML
    void clickRoom(ActionEvent event) {
        Main.changeScene("viewRoom");
    }

    @FXML
    void clickUpdateRoom(ActionEvent event) {
        Main.changeScene("updateRoom");
    }
    private ObservableList<DriverInfo> driverInfoObservableList;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        nameColumn.setCellValueFactory(c->new SimpleStringProperty(c.getValue().getName()));
        phoneColumn.setCellValueFactory(c->new SimpleStringProperty(c.getValue().getPhone()));
        carColumn.setCellValueFactory(c->new SimpleStringProperty(c.getValue().getCar()));
        driverInfoObservableList = FXCollections.observableArrayList();
        DriverService driverService = new DriverService();
        driverInfoObservableList.addAll(driverService.list());
        driverTableView.setItems(driverInfoObservableList);
    }
}
