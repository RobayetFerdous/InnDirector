package com.robayet.inndirector.Controller;

import com.robayet.inndirector.Main;
import com.robayet.inndirector.model.RoomInfo;
import com.robayet.inndirector.service.RoomService;
import javafx.beans.property.SimpleDoubleProperty;
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
import java.util.ResourceBundle;

public class ViewRoomAsAdminController implements Initializable {

    @FXML
    private TableColumn<RoomInfo, String> bedColumn;

    @FXML
    private TextField bedField;

    @FXML
    private TableColumn<RoomInfo, Number> numberColumn;

    @FXML
    private TextField numberField;

    @FXML
    private TableColumn<RoomInfo, Number> priceColumn;

    @FXML
    private TextField priceField;

    @FXML
    private TableView<RoomInfo> roominfoTableView;

    @FXML
    private TableColumn<RoomInfo, String> statusColumn;

    @FXML
    private TextField statusField;

    @FXML
    void clickBack() {
        Main.changeScene("adminPanel");
    }

    @FXML
    void clickLogout() {
        Main.changeScene("login");
    }

    @FXML
    void clickUpdate(ActionEvent event) {
        int roomNumber = Integer.parseInt(numberField.getText());
        String cleaningStatus = statusField.getText();
        double roomPrice = Double.parseDouble(priceField.getText());
        String bedType = bedField.getText();

        RoomService roomService = new RoomService();
        roomService.adminUpdateRoom(new RoomInfo(roomNumber,cleaningStatus,roomPrice,bedType));

        roomInfoObservableList.setAll(roomService.list());
        System.out.println("Room status updated");
    }

    @FXML
    void clickRow(MouseEvent event){
        RoomInfo selectRoom = roominfoTableView.getSelectionModel().getSelectedItem();
        if (selectRoom != null){
            numberField.setText(String.valueOf(selectRoom.getNumber()));
            statusField.setText(selectRoom.getStatus());
            priceField.setText(String.valueOf(selectRoom.getPrice()));
            bedField.setText(selectRoom.getBed());
        }
    }

    private ObservableList<RoomInfo> roomInfoObservableList;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        numberColumn.setCellValueFactory(c->new SimpleIntegerProperty(c.getValue().getNumber()));
        statusColumn.setCellValueFactory(c->new SimpleStringProperty(c.getValue().getStatus()));
        priceColumn.setCellValueFactory(c->new SimpleDoubleProperty(c.getValue().getPrice()));
        bedColumn.setCellValueFactory(c->new SimpleStringProperty(c.getValue().getBed()));
        roomInfoObservableList = FXCollections.observableArrayList();
        RoomService roomService = new RoomService();
        roomInfoObservableList.addAll(roomService.list());
        roominfoTableView.setItems(roomInfoObservableList);
    }
}
