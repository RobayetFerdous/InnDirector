package com.robayet.inndirector.Controller;

import com.robayet.inndirector.HelloApplication;
import javafx.fxml.FXML;

public class ViewRoomController {
    @FXML
    public void clickLogout(){
        HelloApplication.changeScene("login", 600, 400);
    }
    @FXML
    public void clickNewCustomer(){
        HelloApplication.changeScene("newCustomerForm",900,600);
    }
}
