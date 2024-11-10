package com.robayet.inndirector.Controller;

import com.robayet.inndirector.Main;
import com.robayet.inndirector.model.RoomInfo;
import com.robayet.inndirector.service.RoomService;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

import java.net.URL;
import java.util.MissingFormatArgumentException;
import java.util.ResourceBundle;

public class UpdateRoomController implements Initializable {
    @FXML
    public void clickLogout() {
        Main.changeScene("login");
    }

    @FXML
    public void clickNewCustomer() {
        Main.changeScene("newCustomerForm");
    }

    @FXML
    public void clickRoom() {
        Main.changeScene("viewRoom");
    }

    @FXML
    public void clickCheckOut() {
        Main.changeScene("checkOut");
    }
    @FXML
    public void clickCustomerInfo(){
        Main.changeScene("customerInfo");
    }
    @FXML
    private TableColumn<RoomInfo, String> cleaningStatusColumn;

    @FXML
    private TextField cleantingStatusField;

    @FXML
    private TableColumn<RoomInfo, Number> roomNumberColumn;

    @FXML
    private TextField roomNumberField;

    @FXML
    private TableView<RoomInfo> roomUpdateTableView;

    private ObservableList<RoomInfo> currentTableData = roomUpdateTableView.getItems();
    @FXML
    void clickUpdate(ActionEvent event) {

        int currentRoomNumber = Integer.parseInt(roomNumberField.getText());
        for (RoomInfo info : currentTableData){
            if (info.getNumber() == currentRoomNumber){
                info.setStatus(cleantingStatusField.getText());

                roomUpdateTableView.setItems(currentTableData);
                roomUpdateTableView.refresh();
                break;
            }
        }
    }
    @FXML
    void clickRow(MouseEvent event){
        RoomInfo click = roomUpdateTableView.getSelectionModel().getSelectedItem();
        roomNumberField.setText(String.valueOf(click.getNumber()));
        cleantingStatusField.setText(click.getStatus());
    }
    private ObservableList<RoomInfo> roomInfoObservableList;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        roomNumberColumn.setCellValueFactory(c->new SimpleIntegerProperty(c.getValue().getNumber()));
        cleaningStatusColumn.setCellValueFactory(c->new SimpleStringProperty(c.getValue().getStatus()));
        roomInfoObservableList = FXCollections.observableArrayList();
        RoomService roomService = new RoomService();
        roomInfoObservableList.addAll(roomService.list());
        roomUpdateTableView.setItems(roomInfoObservableList);
    }
}
