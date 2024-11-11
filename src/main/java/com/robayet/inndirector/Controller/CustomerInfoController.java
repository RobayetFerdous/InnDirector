package com.robayet.inndirector.Controller;

import com.robayet.inndirector.Main;
import com.robayet.inndirector.model.CustomerInfo;
import com.robayet.inndirector.service.CustomerService;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import java.net.URL;
import java.util.ResourceBundle;

public class CustomerInfoController implements Initializable {
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
    public void clickCustomerInfo() {
        Main.changeScene("customerInfo");
    }

    @FXML
    public void clickUpdateRoom() {
        Main.changeScene("updateRoom");
    }

    @FXML
    void clickPickUpService() {
        Main.changeScene("pickUpService");
    }

    @FXML
    private TableView<CustomerInfo> customerInfoTableView;

    @FXML
    private TableColumn<CustomerInfo, String> dataAndTimeColumn;

    @FXML
    private TableColumn<CustomerInfo, String> genderColumn;

    @FXML
    private TableColumn<CustomerInfo, String> nameColumn;

    @FXML
    private TableColumn<CustomerInfo, String> numberColumn;

    private ObservableList<CustomerInfo> customerInfoObservableList;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        nameColumn.setCellValueFactory(c->new SimpleStringProperty(c.getValue().getName()));
        numberColumn.setCellValueFactory(c->new SimpleStringProperty(c.getValue().getNumber()));
        genderColumn.setCellValueFactory(c->new SimpleStringProperty(c.getValue().getGender()));
        dataAndTimeColumn.setCellValueFactory(c->new SimpleStringProperty(c.getValue().getDate()));
        customerInfoObservableList = FXCollections.observableArrayList();
        CustomerService customerService = new CustomerService();
        customerInfoObservableList.addAll(customerService.list());
        customerInfoTableView.setItems(customerInfoObservableList);
    }
}
