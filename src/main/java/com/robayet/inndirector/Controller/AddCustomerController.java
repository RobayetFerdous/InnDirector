package com.robayet.inndirector.Controller;

import com.robayet.inndirector.HelloApplication;
import javafx.fxml.FXML;

public class AddCustomerController {
    @FXML
    public void clickLogout(){
        HelloApplication.changeScene("login", 600, 400);
    }
}
