package com.robayet.inndirector.Controller;

import com.robayet.inndirector.Main;
import com.robayet.inndirector.model.CustomerInfo;
import com.robayet.inndirector.service.CustomerService;
import com.robayet.inndirector.service.DateAndTimeService;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;

import java.net.URL;
import java.util.ResourceBundle;

public class NewCustomerFormController implements Initializable {
    @FXML
    public void clickLogout(){
        Main.changeScene("login");
    }
    @FXML
    public void clickRoom(){
        Main.changeScene("viewRoom");
    }
    @FXML
    public void clickCheckOut(){
        Main.changeScene("checkOut");
    }
    @FXML
    private RadioButton female;
    @FXML
    private RadioButton male;
    @FXML
    private Label dateTextField;
    @FXML
    private ToggleGroup gender;

    @FXML
    private TextField nameTextField;

    @FXML
    private TextField numberTextField;
    @FXML
    public void clickAddCustomer(){
        String name = nameTextField.getText();
        String number = numberTextField.getText();
        String gender = "";
        if (male.isSelected()){
            gender = "male";
        } else if (female.isSelected()) {
            gender = "female";
        }

        DateAndTimeService dateAndTimeService = new DateAndTimeService();
        String date = dateAndTimeService.getCurrentDataAndTime();

        CustomerService customerService = new CustomerService();
        customerService.addCustomer(new CustomerInfo(name, number, gender, date));

        System.out.println("Customer added");
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        DateAndTimeService dateAndTimeService = new DateAndTimeService();
        String date = dateAndTimeService.getCurrentDataAndTime();

        dateTextField.setText(date);
    }
}
