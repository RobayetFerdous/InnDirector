package com.robayet.inndirector.Controller;

import com.robayet.inndirector.Main;
import com.robayet.inndirector.model.RoomInfo;
import com.robayet.inndirector.service.RoomService;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import java.net.URL;
import java.util.ResourceBundle;

public class ViewRoomController implements Initializable {
    @FXML
    public void clickLogout(){
        Main.changeScene("login");
    }
    @FXML
    public void clickNewCustomer(){
        Main.changeScene("newCustomerForm");
    }
    @FXML
    public void clickCheckOut(){
        Main.changeScene("checkOut");
    }
    @FXML
    public void clickCustomerInfo(){
        Main.changeScene("customerInfo");
    }
    @FXML
    private TableColumn<RoomInfo, String> BedType;

    @FXML
    private TableColumn<RoomInfo, String> cleaningStatus;

    @FXML
    private TableColumn<RoomInfo, Number> priceTextField;

    @FXML
    private TableView<RoomInfo> roomInfoTableView;

    @FXML
    private TableColumn<RoomInfo, Number> roomNumber;

    private ObservableList<RoomInfo> roomInfoObservableList;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        roomNumber.setCellValueFactory(c->new SimpleIntegerProperty(c.getValue().getNumber()));
        cleaningStatus.setCellValueFactory(c->new SimpleStringProperty(c.getValue().getStatus()));
        priceTextField.setCellValueFactory(c->new SimpleDoubleProperty(c.getValue().getPrice()));
        BedType.setCellValueFactory(c->new SimpleStringProperty(c.getValue().getBed()));
        roomInfoObservableList = FXCollections.observableArrayList();
        RoomService roomService = new RoomService();
        roomInfoObservableList.addAll(roomService.list());
        roomInfoTableView.setItems(roomInfoObservableList);
    }
}
